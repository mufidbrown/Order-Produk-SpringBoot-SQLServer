package restorder.orderproduk.controller;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import restorder.orderproduk.controllers.UserController;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserControllerTest {



        @InjectMocks
        private UserController userController;

        @Mock
        private UserService userService;






//        @Test
//        public void testGetAllUsers(){
//            User returned = new User(1L,"anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
//            String expected = "{id:1,name:anjali,alamat:tebet,email:anjali123@gmail.com,telepon:081312345678,password:secret1234}";
//            //mock the data
//            Mockito.when(userService.getAllUsers(1L)).thenReturn(returned);
//
//            //original method call
//            User result = userController.getAllUsers(1L);
//
//            Assert.assertEquals(result.getUsername(),"anjali");
//        }



//    @Test
//    public void testGetUserById() throws Exception {
//        Long userId = 1L;
//        User user = new User(1L,"anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
//
//        when(userService.getUserById(userId)).thenReturn(user);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", userId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("Anjali")));
//    }



    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        // Add some dummy products to the list or use Mockito to mock product data

        when(userService.getAllUsers()).thenReturn(userList);

        ResponseEntity<List<User>> responseEntity = userController.getAllUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userList, responseEntity.getBody());
    }

        @Test
        public void  testCreateUser() throws Exception{
            User input = new User(1L,"anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
            User returned = new User(1L,"anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
            //stub the data
            when(userService.createUser(input)).thenReturn(returned);

            //original method call
            User result = userController.createUser(input).getBody();

            Assert.assertEquals(result.getUsername(),"anjali");
        }


        @Test
        public void testUpdateUser() throws Exception{
            User input = new User(1L, "rahul", "mampang", "rahul123@gmail.com", "081387654321", "secret4321");
            User returned = new User(1L,"rahul_updated",  "mampang", "rahul123@gmail.com", "081387654321", "secret4321");
            //stub the data
            when(userService.updateUser(1L,input)).thenReturn(returned);

            //original method call
            User result = userController.updateUser(1L,input).getBody();

            Assert.assertEquals(result.getUsername(), "rahul_updated");
        }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User user = new User(); // Create a dummy product or use Mockito to mock product data
//        1L, "gitar", 2, 1.000000, "akustik"
        when(userService.getUserById(userId)).thenReturn(user);

        ResponseEntity<User> responseEntity = userController.getUserById(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

}
