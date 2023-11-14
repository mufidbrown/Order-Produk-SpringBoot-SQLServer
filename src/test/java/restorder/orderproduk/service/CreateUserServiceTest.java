package restorder.orderproduk.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {




    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void whenSaveUser_shouldReturnUser() {
        User user = new User();
        user.setUsername("Test Name");

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User created = UserService.createUser(user);

        assertThat(created.getUsername()).isSameAs(user.getUsername());
        verify(userRepository).save(user);
    }
}
