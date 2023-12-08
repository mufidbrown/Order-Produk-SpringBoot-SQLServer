package restorder.orderproduk.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQLDB)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = userRepository.save(User
                .builder()
                .username("Ilham Mufid")
                .alamat("Surabaya")
                .email("ilham@gmail.com")
                .telepon("081312345678")
                .password("12345678")
                .build()
        );
    }

    @Test
    public void shouldFindUserByEmail() {
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get()).isEqualTo(user);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenUserDoesNotExistByEmail() {
        Optional<User> foundUser = userRepository.findByEmail("invalid-email@example.com");
        assertThat(foundUser).isEmpty();
    }

    @Test
    public void shouldExistsByEmail() {
        Boolean exists = userRepository.existsByEmail(user.getEmail());
        assertThat(exists).isTrue();
    }

    @Test
    public void shouldNotExistsByEmailWhenUserDoesNotExist() {
        Boolean exists = userRepository.existsByEmail("invalid-email@example.com");
        assertThat(exists).isFalse();
    }

    @Test
    public void shouldExistsByTelepon() {
        Boolean exists = userRepository.existsByTelepon(user.getTelepon());
        assertThat(exists).isTrue();
    }

    @Test
    public void shouldNotExistsByTeleponWhenUserDoesNotExist() {
        Boolean exists = userRepository.existsByTelepon("081312345678");
        assertThat(exists).isFalse();
    }


}
