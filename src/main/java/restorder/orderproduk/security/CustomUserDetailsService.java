package restorder.orderproduk.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.exception.UserNotFoundException;
import restorder.orderproduk.service.user.UserServiceImpl;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userServiceImpl.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User Name " + username + " not found"));

        return new CustomUserDetails(user);
    }
}
