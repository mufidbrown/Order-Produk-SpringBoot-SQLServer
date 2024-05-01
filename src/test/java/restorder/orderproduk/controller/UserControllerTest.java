package restorder.orderproduk.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import restorder.orderproduk.controllers.UserController;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserControllerTest {



        @InjectMocks
        private UserController userController;

        @Mock
        private UserService userService;




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

    @Test
    public void testDeleteUser(){
        // Arrange
        Long userId = 1L;

        // Act
        ResponseEntity<Void> responseEntity = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).deleteUser(userId);
    }

}
