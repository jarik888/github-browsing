package artjuh.jaroslav.githubbrowsing.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubAuthResponse {
    private String access_token;
    private String token_type;
    private String scope;
    private String error;
    private String error_description;
    private String error_uri;
}
