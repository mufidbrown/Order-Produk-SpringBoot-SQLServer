package restorder.orderproduk.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        User user = new User();
        user.setId(9L);
        user.setUsername("a");

        User newUser = new User();
        user.setUsername("New Test Name");

        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));
        UserService.updateUser(user.getId(), newUser);

        verify(userRepository).save(newUser);
        verify(userRepository).findById(user.getId());
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() {
        User user = new User();
        user.setId(9L);
        user.setUsername("Test Name");

        User newUser = new User();
        user.setId(90L);
        user.setUsername("New Test Name");

        given(userRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        UserService.updateUser(user.getId(), newUser);
    }
}
