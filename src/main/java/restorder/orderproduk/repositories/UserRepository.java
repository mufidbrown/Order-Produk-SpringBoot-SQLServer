package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
//    String getId();
//    String getUsername();
//    String getPassword();

}
