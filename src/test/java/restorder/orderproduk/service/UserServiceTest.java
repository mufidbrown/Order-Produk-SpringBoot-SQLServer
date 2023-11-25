package restorder.orderproduk.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import static org.mockito.Mockito.doNothing;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


//    @Test
//    public void testGetAllUsers() throws Exception{
//        User returned = new User(1L, "rahul", "mampang", "rahul123@gmail.com", "081387654321", "secret4321");
//        //stub the data
//        Mockito.when(userRepository.getOne(1L)).thenReturn(returned);
//
//        User result = userService.getAllUsers(1L);
//        Assert.assertEquals("rahul", result.getUsername());
//    }

//    @Test(expected = EntityNotFoundException.class)
//    public void testGetCustomer_notFound(){
//        doThrow(new EntityNotFoundException()).when(customerRepository).getOne(1L);
//        customerService.getCustomer(1L);
//    }


    @Test
    public void testCreateUser() throws Exception{
        User input1 = new User(1L, "anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
        User input2 = new User(2L, "rahul", "mampang", "rahul123@gmail.com", "081387654321", "secret4321");

        User returned1 = new User(1L, "anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");
        User returned2 = new User(2L, "rahul", "mampang", "rahul123@gmail.com", "081387654321", "secret4321");

        //stub the data
        Mockito.when(userRepository.save(input1)).thenReturn(returned1);
        Mockito.when(userRepository.save(input2)).thenReturn(returned2);

        //actual method call
        User result1 = userService.createUser(input1);
        User result2 = userService.createUser(input2);

        Assert.assertEquals("anjali", result1.getUsername());
        Assert.assertEquals("rahul", result2.getUsername());
    }

    @Test
    public void testUpdateUser(){
        User input = new User(1L, "anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");

        User returned = new User(1L, "anjali_updated", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");

        //stub the data
        Mockito.when(userRepository.getOne(1L)).thenReturn(input);
        Mockito.when(userRepository.save(input)).thenReturn(returned);

        //actual method call
        User result = userService.updateUser(1L,input);

        Assert.assertEquals("anjali", result.getUsername());
    }


//    @Test(expected = EntityNotFoundException.class)
//    public void testUpdateCustomer_notfound(){
//        doThrow(new EntityNotFoundException()).when(customerRepository).getOne(1L);
//        Customer input = new Customer(1L, "anjali");
//        customerService.updateCustomer(1L,input);
//    }


    @Test
    public void testDeleteUser() throws Exception{
        User input = new User(1L, "anjali", "tebet", "anjali123@gmail.com", "081312345678", "secret1234");

        //stub the data
        Mockito.when(userRepository.getOne(1L)).thenReturn(input);
        doNothing().when(userRepository).delete(input);

        userService.deleteUser(1L);
    }
}
