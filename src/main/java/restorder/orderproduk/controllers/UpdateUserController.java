package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.CreateUserRequest;
import restorder.orderproduk.model.RegisterRequest;
import restorder.orderproduk.model.UpdateUserRequest;
import restorder.orderproduk.model.UpdateUserResponse;
import restorder.orderproduk.service.register.RegisterService;
import restorder.orderproduk.service.user.UpdateUserService;

@RestController
@RequestMapping("/update")
public class UpdateUserController {

    @Autowired
    private UpdateUserService updateUserService;


    @PutMapping("/{id}")
    public BaseResponse<?> updateuser(@PathVariable Integer id, @RequestBody UpdateUserRequest updateUserRequest){
        return updateUserService.updateuser(id, updateUserRequest);
//        return registerService.register(registerRequest);

    }

}
