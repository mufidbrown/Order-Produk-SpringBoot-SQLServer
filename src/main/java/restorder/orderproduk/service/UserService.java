package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.exception.UserNotFoundException;
import restorder.orderproduk.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    

    public static User updateUser(Long id, User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id) {

//        userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.deleteById(id);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
