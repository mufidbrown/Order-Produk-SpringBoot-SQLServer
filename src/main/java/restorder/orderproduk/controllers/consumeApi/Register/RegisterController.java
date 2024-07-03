package restorder.orderproduk.controllers.consumeApi.Register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.model.consumeApi.RegisterRequest;
import restorder.orderproduk.service.consumeApi.register.RegisterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;


//    ngecek validasi isi2 an: berapa panjang String, Maksimal/Minimal huruf angka, dan jumlah isian seperti password
    @PostMapping("/post")
    public BaseResponse<?> register(@RequestBody @Valid RegisterRequest registerRequest){
//        public BaseResponse<?> register(@RequestMapping RegisterRequest registerRequest){
//            public BaseResponse<?> register(@RequestParam RegisterRequest registerRequest){
                return registerService.register(registerRequest);
    }


}
