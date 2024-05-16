package restorder.orderproduk.service.product;

import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product createProduct(Product product);


    /*
    Dibawah ini untuk QueryNative!
  */
    BaseResponse<?> testproduct();

    BaseResponse<?> testParameterProduct(Integer idProduct);

}
