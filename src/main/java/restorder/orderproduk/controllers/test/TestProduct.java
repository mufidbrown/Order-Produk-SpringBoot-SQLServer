package restorder.orderproduk.controllers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.service.product.ProductService;

@RestController
public class TestProduct {

    @Autowired
    private ProductService productService;

    @GetMapping("/testproduct")
    public BaseResponse<?> testproduct() {
        return productService.testproduct();
    }

    @GetMapping("/testproduct/v1/{id_product}")
    public BaseResponse<?> testParameterProduct(@PathVariable Integer id_product){
        return productService.testParameterProduct(id_product);
    }

/*
    untuk selanjutnya tambahkan put & delete
*/

}
