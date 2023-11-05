package restorder.orderproduk.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.model.LoginRequest;
import restorder.orderproduk.model.LoginResponse;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return LoginResponse.builder()
        .accessToken("Fid fid fid")
                .build();
    }
}
