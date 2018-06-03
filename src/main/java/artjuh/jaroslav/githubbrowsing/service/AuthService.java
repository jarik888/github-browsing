package artjuh.jaroslav.githubbrowsing.service;

import artjuh.jaroslav.githubbrowsing.model.UserData;
import artjuh.jaroslav.githubbrowsing.model.github.GithubAuthRequest;
import artjuh.jaroslav.githubbrowsing.model.github.GithubAuthResponse;
import artjuh.jaroslav.githubbrowsing.model.github.GithubUserDataResponse;
import artjuh.jaroslav.githubbrowsing.model.github.GithubUserRepoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthService {

    @Value("${github.oauth.clientId}")
    private String clientId;
    @Value("${github.oauth.clientSecret}")
    private String clientSecret;
    @Value("${github.authUrl}")
    private String authUrl;
    @Value("${github.apiUrl}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    private final String ACCESS_TOKEN = "access_token";

    public UserData getUserData(String code) {
        UserData userData = new UserData();
        String accessToken = authGithubUser(code).getAccess_token();

        if (accessToken != null && !accessToken.equals("null")) {
            GithubUserDataResponse user = getGithubUserData(accessToken);
            userData.setUser(user);
            userData.setRepos(getGithubUserRepos(accessToken, user.getLogin()));
        }

        return userData;
    }

    private GithubAuthResponse authGithubUser(String code) {
        GithubAuthRequest request = GithubAuthRequest.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .code(code)
                .build();

        return restTemplate.postForObject(authUrl, request, GithubAuthResponse.class);
    }

    private GithubUserDataResponse getGithubUserData(String accessToken) {
        return restTemplate.getForEntity(apiUrl + "/user?" + ACCESS_TOKEN + "=" + accessToken,
                GithubUserDataResponse.class).getBody();
    }

    private List<GithubUserRepoResponse> getGithubUserRepos(String accessToken, String userLogin) {
        return Arrays.asList(restTemplate.getForEntity("https://api.github.com/users" + "/" + userLogin
                        + "/repos?" + ACCESS_TOKEN + "=" + accessToken,
                GithubUserRepoResponse[].class).getBody());
    }
}
