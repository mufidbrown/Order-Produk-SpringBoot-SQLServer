package restorder.orderproduk.controllers.consumeApi.UserRetrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.consumeApi.UpdateUserRequest;
import restorder.orderproduk.service.consumeApi.UserRetrofit.UpdateUserService;

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
