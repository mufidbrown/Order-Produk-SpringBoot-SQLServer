package restorder.orderproduk.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.entity.Enum.ERole;
import restorder.orderproduk.entity.RefreshToken;
import restorder.orderproduk.entity.Role;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.exception.RefreshTokenException;
import restorder.orderproduk.exception.RoleException;
import restorder.orderproduk.jwt.JwtUtils;
import restorder.orderproduk.payload.request.LoginRequest;
import restorder.orderproduk.payload.request.RoleRequest;
import restorder.orderproduk.payload.request.SignupRequest;
import restorder.orderproduk.payload.request.TokenRefreshRequest;
import restorder.orderproduk.payload.response.JWTResponse;
import restorder.orderproduk.payload.response.MessageResponse;
import restorder.orderproduk.payload.response.TokenRefreshResponse;
import restorder.orderproduk.security.CustomUserDetails;
import restorder.orderproduk.service.RefreshToken.RefreshTokenServiceImpl;
import restorder.orderproduk.service.role.RoleServiceImpl;
import restorder.orderproduk.service.user.UserServiceImpl;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    UserServiceImpl userServiceImpl;

    RoleServiceImpl roleServiceImpl;

    RefreshTokenServiceImpl refreshTokenServiceImpl;

    AuthenticationManager authenticationManager;

    PasswordEncoder encoder;

    JwtUtils jwtUtils;

    @Autowired
    public AuthController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl, RefreshTokenServiceImpl refreshTokenServiceImpl,
                          AuthenticationManager authenticationManager, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
        this.refreshTokenServiceImpl = refreshTokenServiceImpl;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/addrole")
    public ResponseEntity<?> addRole(@RequestBody RoleRequest roleRequest) {

        String roleName = roleRequest.getRoleName();
        Role role = null;

        switch (roleName) {
            case "ROLE_ADMIN":

                role = new Role(ERole.ROLE_ADMIN);

                break;

            case "ROLE_MODERATOR":

                role = new Role(ERole.ROLE_MODERATOR);
                break;

            default:

                role = new Role(ERole.ROLE_USER);;
        }

        roleServiceImpl.saveRole(role);

        return ResponseEntity.badRequest().body(new MessageResponse("Role: " + roleName + "saved "));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

        LOGGER.info("AuthController | registerUser is started");

        String username = signUpRequest.getUsername();
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if(userServiceImpl.existsByUsername(username)){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if(userServiceImpl.existsByEmail(email)){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
        }

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));


        if (strRoles != null) {
            strRoles.forEach(role -> {
                LOGGER.info("AuthController | registerUser | role : " + role);
                switch (role) {
                    case "ROLE_ADMIN":

                        Role adminRole = null;

                        if(roleServiceImpl.findByName(ERole.ROLE_ADMIN).isEmpty()){
                            adminRole = new Role(ERole.ROLE_ADMIN);
                        }else{
                            adminRole = roleServiceImpl.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RoleException("Error: Admin Role is not found."));
                        }

                        roles.add(adminRole);
                        break;

                    case "ROLE_MODERATOR":

                        Role moderatorRole = null;

                        if(roleServiceImpl.findByName(ERole.ROLE_MODERATOR).isEmpty()){
                            moderatorRole = new Role(ERole.ROLE_MODERATOR);
                        }else{
                            moderatorRole = roleServiceImpl.findByName(ERole.ROLE_MODERATOR)
                                    .orElseThrow(() -> new RoleException("Error: Moderator Role is not found."));
                        }

                        roles.add(moderatorRole);

                        break;

                    default:

                        Role userRole = null;

                        if(roleServiceImpl.findByName(ERole.ROLE_USER).isEmpty()){
                            userRole = new Role(ERole.ROLE_USER);
                        }else{
                            userRole = roleServiceImpl.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RoleException("Error: User Role is not found."));
                        }

                        roles.add(userRole);

                }

            });
        }else{

            roleServiceImpl.findByName(ERole.ROLE_USER).ifPresentOrElse(roles::add, () -> roles.add(new Role(ERole.ROLE_USER)));
        }

        roleServiceImpl.saveRoles(roles);
        user.setRoles(roles);
        userServiceImpl.saveUser(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        LOGGER.info("AuthController | authenticateUser is started");

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        LOGGER.info("AuthController | authenticateUser | username : " + username);
        LOGGER.info("AuthController | authenticateUser | password : " + password);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);

        LOGGER.info("AuthController | authenticateUser | usernamePasswordAuthenticationToken : " + usernamePasswordAuthenticationToken.toString());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);

        LOGGER.info("AuthController | authenticateUser | jwt : " + jwt);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        LOGGER.info("AuthController | authenticateUser | roles : " + roles.toString());

        RefreshToken refreshToken = refreshTokenServiceImpl.createRefreshToken(userDetails.getId());

        LOGGER.info("AuthController | authenticateUser | refreshToken : " + refreshToken.toString());

        JWTResponse jwtResponse = new JWTResponse();
        jwtResponse.setEmail(userDetails.getEmail());
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setToken(jwt);
        jwtResponse.setRefreshToken(refreshToken.getToken());
        jwtResponse.setRoles(roles);

        LOGGER.info("AuthController | authenticateUser | jwtResponse : " + jwtResponse.toString());

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@ApiIgnore Principal principalUser) {

        LOGGER.info("AuthController | logoutUser is started");

        Object principal = ((UsernamePasswordAuthenticationToken) principalUser).getPrincipal();
        CustomUserDetails user = (CustomUserDetails) principal;

        long userId = user.getId();

        LOGGER.info("AuthController | logoutUser | userId : " + userId);

        long deletedValue = refreshTokenServiceImpl.deleteByUserId(userId);

        if(deletedValue == 1){
            return ResponseEntity.ok(new MessageResponse("Log out successful!"));
        }else{
            return ResponseEntity.ok(new MessageResponse("You're already logout"));
        }

    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody TokenRefreshRequest request) {

        LOGGER.info("AuthController | refreshtoken is started");

        String requestRefreshToken = request.getRefreshToken();

        LOGGER.info("AuthController | refreshtoken | requestRefreshToken : " + requestRefreshToken);

        RefreshToken token = refreshTokenServiceImpl.findByToken(requestRefreshToken)
                .orElseThrow(() -> new RefreshTokenException(requestRefreshToken + "Refresh token is not in database!"));

        LOGGER.info("AuthController | refreshtoken | token : " + token.toString());

        RefreshToken deletedToken = refreshTokenServiceImpl.verifyExpiration(token);

        LOGGER.info("AuthController | refreshtoken | deletedToken : " + deletedToken.toString());

        User userRefreshToken = deletedToken.getUser();

        LOGGER.info("AuthController | refreshtoken | userRefreshToken : " + userRefreshToken.toString());

        String newToken = jwtUtils.generateTokenFromUsername(userRefreshToken.getUsername());

        LOGGER.info("AuthController | refreshtoken | newToken : " + newToken);

        return ResponseEntity.ok(new TokenRefreshResponse(newToken, requestRefreshToken));

    }

}
