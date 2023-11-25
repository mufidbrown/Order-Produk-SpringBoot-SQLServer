package restorder.orderproduk.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import restorder.orderproduk.controllers.UserController;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.service.UserService;

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


        @Test
        public void  testCreateUser() throws Exception{
            User input = new User(1L,"anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
            User returned = new User(1L,"anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
            //stub the data
            Mockito.when(userService.createUser(input)).thenReturn(returned);

            //original method call
            User result = userController.createUser(input).getBody();

            Assert.assertEquals(result.getUsername(),"anjali");
        }


        @Test
        public void testUpdateUser() throws Exception{
            User input = new User(1L, "rahul", "mampang", "rahul123@gmail.com", "081387654321", "secret4321");
            User returned = new User(1L,"rahul_updated",  "mampang", "rahul123@gmail.com", "081387654321", "secret4321");
            //stub the data
            Mockito.when(userService.updateUser(1L,input)).thenReturn(returned);

            //original method call
            User result = userController.updateUser(1L,input).getBody();

            Assert.assertEquals(result.getUsername(), "rahul_updated");
        }

    }
