package restorder.orderproduk.controllers.consumeApi.Cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.service.consumeApi.cat.CatsService;

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
