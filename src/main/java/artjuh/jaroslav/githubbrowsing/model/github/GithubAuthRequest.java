package artjuh.jaroslav.githubbrowsing.model.github;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GithubAuthRequest {
    private String client_id;
    private String client_secret;
    private String code;
}
