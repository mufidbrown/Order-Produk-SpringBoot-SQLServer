package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.CreateUserRequest;
import restorder.orderproduk.model.RegisterRequest;
import restorder.orderproduk.service.register.RegisterService;
import restorder.orderproduk.service.user.CreateUserService;

@RestController
@RequestMapping("/create")
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping("/post")
    public BaseResponse<?> createuser(@RequestBody CreateUserRequest createUserRequest){
//        public BaseResponse<?> register(@RequestMapping RegisterRequest registerRequest){
//            public BaseResponse<?> register(@RequestParam RegisterRequest registerRequest){
        return createUserService.createuser(createUserRequest);
    }

}
