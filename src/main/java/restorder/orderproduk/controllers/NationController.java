package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.service.nation.NationService;

@RestController
@RequestMapping("/nation")
public class NationController {


    @Autowired
    private NationService nationService;


    @GetMapping("/get")
    public BaseResponse<?> nation(@RequestParam String name){
        return nationService.nation(name);
    }


}
