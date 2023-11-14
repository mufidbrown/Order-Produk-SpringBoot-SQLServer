package restorder.orderproduk.repository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;
import restorder.orderproduk.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void findAll_should_return_user_list() {

        List<User> users = this.userRepository.findAll();

        assertEquals(4, users.size());
    }

    @Test
    public void findById_should_return_user() {

        Optional<User> user = this.userRepository.findById(2L);

        assertTrue(user.isPresent());
    }

    @Test
    public void save_should_insert_new_user() {

        User newUser = new User();
        newUser.setUsername("USERNAME");
        newUser.setEmail("EMAIL");

        User persistedUser = this.userRepository.save(newUser);

        assertNotNull(persistedUser);
        assertEquals(5, persistedUser.getId());
    }

    @Test
    public void save_should_update_existing_user() {

        User existingUser = new User();
        existingUser.setId(3L);
        existingUser.setUsername("USERNAME");
        existingUser.setEmail("EMAIL");

        User updatedUser = this.userRepository.save(existingUser);

        assertNotNull(updatedUser);
        assertEquals("USERNAME", updatedUser.getUsername());
        assertEquals("EMAIL", updatedUser.getEmail());
    }

    @Test
    public void deleteById_should_delete_user() {

        this.userRepository.deleteById(2L);
        Optional<User> user = this.userRepository.findById(2L);

        assertFalse(user.isPresent());
    }
}






















//    @Autowired
//    private UserRepository userRepository;
//
//    private User user;
//
//
//    // JUnit test for delete employee operation
//    @DisplayName("JUnit test for delete user operation")
//    @Test
//    public void givenUserObject_whenDelete_thenRemoveUser(){
//
//        userRepository.save(user);
//
//        // when -  action or the behaviour that we are going test
//        userRepository.deleteById(user.getId());
//        Optional<User> userOptional = userRepository.findById(user.getId());
//
//        // then - verify the output
//        assertThat(userOptional).isEmpty();
//    }

//
//    @BeforeEach
//    public void setup(){
//        user = User.builder()
//                .username("a")
//                .alamat("mampang")
//                .email("bunny@gmail,com")
//                .build();
//    }
//
//    // JUnit test for save employee operation
//    //@DisplayName("JUnit test for save employee operation")
//    @Test
//    public void givenUserObject_whenSave_thenReturnSavedUser(){
//
//        //given - precondition or setup
//        User user = User.builder()
//                .username("Ramesh")
//                .alamat("Ramesh")
//                .email("ramesh@gmail,com")
//                .build();
//        // when - action or the behaviour that we are going test
//        User savedUser = userRepository.save(user);
//
//        // then - verify the output
//        assertThat(savedUser).isNotNull();
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//
//    // JUnit test for get all employees operation
//    @DisplayName("JUnit test for get all employees operation")
//    @Test
//    public void givenUsersList_whenFindAll_thenUsersList(){
//        // given - precondition or setup
//
//        User user1 = User.builder()
//                .username("John")
//                .alamat("Cena")
//                .email("cena@gmail,com")
//                .build();
//
//        userRepository.save(user);
//        userRepository.save(user1);
//
//        // when -  action or the behaviour that we are going test
//        List<User> userList = userRepository.findAll();
//
//        // then - verify the output
//        assertThat(userList).isNotNull();
//        assertThat(userList.size()).isEqualTo(2);
//
//    }
//
//    @BeforeEach
//    public void setup(){
//        user = User.builder()
//                .firstName("Ramesh")
//                .lastName("Fadatare")
//                .email("ramesh@gmail,com")
//                .build();
//    }


