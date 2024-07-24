package restorder.orderproduk.controllers.ConsumeRestApi.Register;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.ConsumeRestApi.RegisterRequest;
import restorder.orderproduk.service.ConsumeRestApi.register.RegisterService;

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