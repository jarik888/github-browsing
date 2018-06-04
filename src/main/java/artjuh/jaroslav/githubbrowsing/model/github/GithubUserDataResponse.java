package artjuh.jaroslav.githubbrowsing.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUserDataResponse {
    private String login;
    private String id;
    private String avatar_url;
    private String html_url;
    private String name;
    private String email;
}
