package restorder.orderproduk.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.service.ServiceProduct;

@RestController
public class TestProduct {

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping("/testproduct")
    public BaseResponse<?> testproduct() {
        return serviceProduct.testproduct();
    }

}
