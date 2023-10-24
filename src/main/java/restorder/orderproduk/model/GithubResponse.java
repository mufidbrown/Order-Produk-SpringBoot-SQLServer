package restorder.orderproduk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GithubResponse {

    private String login;

    private Integer id;

    private String node_id;

    private String avatar_url;

    private Integer gravatar_id;

    private String url;

    private String html_url;

    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String site_admin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private String twitter_username;
    private Integer public_repos;
    private Integer public_gists;
    private Integer followers;
    private Integer following;
    private Timestamp created_at;
    private Timestamp updated_at;



    // consume api Get
}
