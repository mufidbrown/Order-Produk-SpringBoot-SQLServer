package restorder.orderproduk.service.user;

import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(User user);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findById(long userId);



/*
    ini untuk Upload Excel to DB
*/
    void saveUsersToDatabase(MultipartFile file);

    List<User> getUsers();



/*
    ini untuk Download Excel from DB
*/

    boolean isValidExcelFile(MultipartFile file);

    List<User> getUsersDataFromExcel(InputStream inputStream);

}
