package restorder.orderproduk.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;
import restorder.orderproduk.service.user.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


//    @InjectMocks
//    private UserServiceImpl userService;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


//    @Test
//    void findAll_should_return_user_list() {
//        // Given
//        User user = this.buildTestingUser();
//        // When
//        when(userRepository.findAll()).thenReturn(List.of(user));
//        List<User> users = this.userRepository.findAll();
//        // Then
//        assertEquals(10L, users.size());
//        verify(this.userRepository).findAll();
//    }
//
//    @Test
//    void findById_should_return_user() {
//        // Given
//        User user = this.buildTestingUser();
//        // When
//        when(userRepository.findById(10L)).thenReturn(Optional.of(user));
//        Optional returnedUser = this.userRepository.findById(10L);
//        // Then
//        assertEquals(user.getId(), returnedUser.get()
//                .getId());
//        verify(this.userRepository).findById(10L);
//    }

    @Test
    void save_should_insert_new_user() {
        // Given
        User user = this.buildTestingUser();
        // When
        this.userRepository.save(user);
        // Then
        verify(this.userRepository).save(user);
    }

    @Test
    void deleteById_should_delete_user() {
        // When
        this.userRepository.deleteById(10L);
        // Then
        verify(this.userRepository).deleteById(10L);
    }

    private User buildTestingUser() {
        User user = new User();
        user.setId(10L);
        user.setUsername("USERNAME");
        user.setEmail("EMAIL");
        return user;



    }
}
