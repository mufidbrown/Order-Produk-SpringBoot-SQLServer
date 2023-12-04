package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
//    String getId();
//    String getUsername();
//    String getPassword();
}
