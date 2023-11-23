package restorder.orderproduk.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import restorder.orderproduk.controllers.UserController;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
//
//        @Autowired
//        private UserService userService;
//
//        @BeforeEach
//        public void setUp() {
//            userService.deleteAllUsers();
//        }

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

        @Test
        public void testGetAllUsers() throws Exception {
            User user1 = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");
            User user2 = new User(2L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");
            userService.createUser(user1);
            userService.createUser(user2);

            mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].username", Matchers.is(user1.getUsername())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].username", Matchers.is(user2.getUsername())));
        }

        @Test
        public void testGetUserById() throws Exception {
            User user = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");
            User savedUser = userService.createUser(user);

            mockMvc.perform(MockMvcRequestBuilders.get("api/users/" + savedUser.getId()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is(user.getUsername())));
        }

        @Test
        public void testCreateUser() throws Exception {
            User user = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");

            mockMvc.perform(MockMvcRequestBuilders.post("api/users/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(user)))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is(user.getUsername())));
        }

        @Test
        public void testUpdateUser() throws Exception {
            User user = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");
            User savedUser = userService.createUser(user);

            user.setUsername("Joni");
            user.setAlamat("Surabaya");
            user.setEmail("joni@example.com");

            mockMvc.perform(MockMvcRequestBuilders.put("api/users/update/{id}" + savedUser.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(user)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is(user.getUsername())));
        }

        @Test
        public void testDeleteUser() throws Exception {
            User user = new User(1L, "John", "Jakarta", "john.doe@example.com", "081312344556", "secret12345678");
            User savedUser = userService.createUser(user);

            mockMvc.perform(MockMvcRequestBuilders.delete("api/users/delete/{id}" + savedUser.getId()))
                    .andExpect(MockMvcResultMatchers.status().isNoContent());
        }

    } //keyword: buatkan saya UserControllerTest dengan kode ini





