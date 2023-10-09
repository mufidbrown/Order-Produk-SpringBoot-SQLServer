package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

//    public void registerUser(User user) {
//        userRepository.save(user);
//    }
//    public User createUser(User user) {
//        User User = null;
//        userRepository.save(User);
//        return user;
//    }

    public User updateUser(Long id, User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
