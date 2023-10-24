package restorder.orderproduk.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.model.RegisterRequest;
import restorder.orderproduk.service.nation.NationService;
import restorder.orderproduk.service.register.RegisterService;
import retrofit2.http.Body;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/post")
    public BaseResponse<?> register(@RequestBody RegisterRequest registerRequest){
//        public BaseResponse<?> register(@RequestMapping RegisterRequest registerRequest){
//            public BaseResponse<?> register(@RequestParam RegisterRequest registerRequest){
                return registerService.register(registerRequest);
    }


}
