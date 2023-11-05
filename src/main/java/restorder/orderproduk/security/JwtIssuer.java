package restorder.orderproduk.security;

import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.security.config.Elements.JWT;

@Component
public class JwtIssuer {

    public String issue(long userId, String email, List<String> roles){
        return JWT.create()
    }
}
