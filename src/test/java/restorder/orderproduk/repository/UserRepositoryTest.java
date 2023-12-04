package restorder.orderproduk.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;
import restorder.orderproduk.service.UserService;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByAlamat() {
        // Membuat daftar pengguna palsu dengan alamat yang sama
        String alamat = "karawang";
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "User1", "karawang", "user1@gmail.com", "085112345678", "12345678"));
        users.add(new User(2L, "User2", "bekasi", "user2@gmail.com", "08587654321", "87654321"));


        when(userRepository.findByAlamat(alamat)).thenReturn(users);

        List<User> foundUsers = userService.getUsersByAlamat(alamat);

        assertEquals(2, foundUsers.size());

        assertEquals(alamat, foundUsers.get(0).getAlamat());
        assertEquals(alamat, foundUsers.get(1).getAlamat());
    }
}
