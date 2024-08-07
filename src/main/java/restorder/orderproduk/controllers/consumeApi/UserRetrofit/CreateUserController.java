package restorder.orderproduk.controllers.consumeApi.UserRetrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.consumeApi.CreateUserRequest;
import restorder.orderproduk.service.consumeApi.UserRetrofit.CreateUserService;

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
