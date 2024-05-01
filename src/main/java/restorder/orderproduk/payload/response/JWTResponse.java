package restorder.orderproduk.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class JWTResponse {
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private long id;
    private String username;
    private String email;
    private List<String> roles;
}
