package restorder.orderproduk.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import restorder.orderproduk.controllers.UserController;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;
import restorder.orderproduk.service.UserService;
import restorder.orderproduk.util.JsonUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class CreateUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser_whenPostMethod() throws Exception {

        User user = new User();
        user.setUsername("Test Name");

        given(UserService.createUser(user)).willReturn(user);

        mockMvc.perform(post("/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(user.getUsername())));
    }
}
