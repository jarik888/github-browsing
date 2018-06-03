package artjuh.jaroslav.githubbrowsing.model;

import artjuh.jaroslav.githubbrowsing.model.github.GithubUserDataResponse;
import artjuh.jaroslav.githubbrowsing.model.github.GithubUserRepoResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserData {
    private GithubUserDataResponse user;
    private List<GithubUserRepoResponse> repos;
}
