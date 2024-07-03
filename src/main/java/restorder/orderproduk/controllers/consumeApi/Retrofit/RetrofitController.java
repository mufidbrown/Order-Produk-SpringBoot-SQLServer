package restorder.orderproduk.controllers.consumeApi.Retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.service.consumeApi.retrofit.RetrofitService;

@RestController
@RequestMapping("/retrofit")
public class RetrofitController {

    @Autowired
    private RetrofitService retrofitService;

    @GetMapping("/get")
    public BaseResponse<?> github(){
        return retrofitService.github();
    }

}
