package artjuh.jaroslav.githubbrowsing.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUserRepoResponse {
    private String name;
    private String html_url;
    private String created_at;
    private String pushed_at;
    private String language;
}
