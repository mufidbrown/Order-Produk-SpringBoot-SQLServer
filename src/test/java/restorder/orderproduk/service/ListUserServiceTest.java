package restorder.orderproduk.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnAllUsers() {
        List<User> users = new ArrayList();
        users.add(new User());

        given(userRepository.findAll()).willReturn(users);

        List<User> expected = userService.getAllUsers();

        assertEquals(expected, users);
        verify(userRepository).findAll();
    }
}
