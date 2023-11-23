package restorder.orderproduk.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
        users.add(new User(1L, "user1", "user1@example.com"));
        users.add(new User(2L, "user2", "user2@example.com"));

        when(userRepository.findAll()).thenReturn(users);

        //when
        List<User> found = userService.getAllUsers();

        //then
        assertThat(found).isNotNull();
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getId()).isEqualTo(1L);
        assertThat(found.get(0).getName()).isEqualTo("user1");
        assertThat(found.get(0).getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void getUserById() {
        //given
        User user = new User(1L, "user1", "user1@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //when
        User found = userService.getUserById(1L);

        //then
        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(1L);
        assertThat(found.getName()).isEqualTo("user1");
        assertThat(found.getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void createUser() {
        //given
        User user = new User(null, "user1", "user1@example.com");

        when(userRepository.save(user)).thenReturn(user);

        //when
        User created = userService.createUser(user);

        //then
        assertThat(created).isNotNull();
        assertThat(created.getId()).isNull();
        assertThat(created.getName()).isEqualTo("user1");
        assertThat(created.getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void updateUser() {
        //given
        User user = new User(1L, "user1", "user1@example.com");

        when(userRepository.save(user)).thenReturn(user);

        //when
        User updated = userService.updateUser(1L, user);

        //then
        assertThat(updated).isNotNull();
        assertThat(updated.getId()).isEqualTo(1L);
        assertThat(updated.getName()).isEqualTo("user1");
        assertThat(updated.getEmail()).isEqualTo("user1@example.com");
    }

    @Test
    public void deleteUser() {
        //given
        User user = new User(1L, "user1", "user1@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //when
        userService.deleteUser(1L);

        //then
        verify(userRepository, times(1)).deleteById(1L);
    }
}
