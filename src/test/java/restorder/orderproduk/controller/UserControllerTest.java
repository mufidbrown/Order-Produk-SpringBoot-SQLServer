package restorder.orderproduk.controller;


import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {




        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private UserService userService;

        @BeforeEach
        public void setUp() {
            userService.deleteAllUsers();
        }

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
            User user = new User("John", "Doe", "john.doe@example.com");
            User savedUser = userService.createUser(user);

            mockMvc.perform(MockMvcRequestBuilders.get("/user/" + savedUser.getId()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is(user.getFirstName())));
        }

        @Test
        public void testCreateUser() throws Exception {
            User user = new User("John", "Doe", "john.doe@example.com");

            mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(user)))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is(user.getFirstName())));
        }

        @Test
        public void testUpdateUser() throws Exception {
            User user = new User("John", "Doe", "john.doe@example.com");
            User savedUser = userService.createUser(user);

            user.setFirstName("Jane");
            user.setLastName("Smith");
            user.setEmail("jane.smith@example.com");

            mockMvc.perform(MockMvcRequestBuilders.put("/user/update/" + savedUser.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(user)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is(user.getFirstName())));
        }

        @Test
        public void testDeleteUser() throws Exception {
            User user = new User("John", "Doe", "john.doe@example.com");
            User savedUser = userService.createUser(user);

            mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/" + savedUser.getId()))
                    .andExpect(MockMvcResultMatchers.status().isNoContent());
        }

    }

}




