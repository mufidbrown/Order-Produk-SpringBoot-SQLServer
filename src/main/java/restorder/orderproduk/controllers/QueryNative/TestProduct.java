package restorder.orderproduk.controllers.QueryNative;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.service.QueryNative.ServiceProduct;

@RestController
public class TestProduct {

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping("/testproduct")
    public BaseResponse<?> testproduct() {
        return serviceProduct.testproduct();
    }

    @GetMapping("/testproduct/v1/{id_product}")
    public BaseResponse<?> testParameterProduct(@PathVariable Integer id_product){
        return serviceProduct.testParameterProduct(id_product);
    }

}
