package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.service.user.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public BaseResponse<?> user(@PathVariable Integer id){
        return userService.user(id);
    }

}
