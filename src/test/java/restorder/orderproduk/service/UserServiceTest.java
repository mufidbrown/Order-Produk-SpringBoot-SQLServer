package restorder.orderproduk.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllUsers() {
        //given
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678"));
        users.add(new User(2L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678"));

        when(userRepository.findAll()).thenReturn(users);

        //when
        List<User> found = userService.getAllUsers();

        //then
        assertThat(found).isNotNull();
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getId()).isEqualTo(1L);
        assertThat(found.get(0).getUsername()).isEqualTo("John");
        assertThat(found.get(0).getAlamat()).isEqualTo("Jakarta");
        assertThat(found.get(0).getEmail()).isEqualTo("john.doe@example.com");
    }

    @Test
    public void getUserById() {
        //given
        User user = new User(1L,"John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //when
        User found = userService.getUserById(1L);

        //then
        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(1L);
        assertThat(found.getUsername()).isEqualTo("user1");
        assertThat(found.getAlamat()).isEqualTo("Jakarta");
        assertThat(found.getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void createUser() {
        //given
        User user = new User(null, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");

        when(userRepository.save(user)).thenReturn(user);

        //when
        User created = userService.createUser(user);

        //then
        assertThat(created).isNotNull();
        assertThat(created.getId()).isNull();
        assertThat(created.getUsername()).isEqualTo("user1");
        assertThat(created.getUsername()).isEqualTo("jakarta");
        assertThat(created.getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void updateUser() {
        //given
        User user = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");

        when(userRepository.save(user)).thenReturn(user);

        //when
        User updated = userService.updateUser(1L, user);

        //then
        assertThat(updated).isNotNull();
        assertThat(updated.getId()).isEqualTo(1L);
        assertThat(updated.getUsername()).isEqualTo("user1");
        assertThat(updated.getAlamat()).isEqualTo("jakarta");
        assertThat(updated.getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void deleteUser() {
        //given
        User user = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //when
        userService.deleteUser(1L);

        //then
        verify(userRepository, times(1)).deleteById(1L);
    }
}
