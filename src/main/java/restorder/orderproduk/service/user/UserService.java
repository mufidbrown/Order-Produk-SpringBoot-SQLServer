package restorder.orderproduk.service.user;

import restorder.orderproduk.entity.User;

import java.util.Optional;

public interface UserService {

    void saveUser(User user);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findById(long userId);

}
