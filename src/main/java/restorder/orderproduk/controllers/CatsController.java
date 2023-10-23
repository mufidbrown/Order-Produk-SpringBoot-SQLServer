package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.service.cat.CatsService;
import restorder.orderproduk.service.retrofit.RetrofitService;

@RestController
@RequestMapping("/cats")
public class CatsController {

    @Autowired
    private CatsService catsService;

    @GetMapping("/get")
    public BaseResponse<?> cats(){
        return catsService.cats();
    }
}
