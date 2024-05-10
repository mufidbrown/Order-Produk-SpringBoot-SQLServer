package restorder.orderproduk.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.model.response.ProductResponse;
import restorder.orderproduk.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    private final EntityManager entityManager;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    //update 08/12/2023
    public Product updateProduct(Long id, Product product) {
        Product productEntity= productRepository.findById(id).orElse(new Product());
        productEntity.setPrice(product.getPrice());
        productEntity.setName(product.getName());
        productRepository.save(productEntity);
        return productEntity;
    }
    //end update 08/12


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }


    /*
        Dibawah ini untuk QueryNative!
    */

    @Override
    public BaseResponse<?> testproduct() {
        Query query = entityManager.createNativeQuery("SELECT name, price from products p WHERE id = 3");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        ProductResponse productResponse = ProductResponse.builder()
                .name(list.get(0).toString())
                .price(list.get(1).toString())
                .build();
        return BaseResponse.ok(productResponse);
    }

    @Override
    public BaseResponse<?> testParameterProduct(Integer idProduct) {
        Query query = entityManager.createNativeQuery("select name, price from products p WHERE id = ?1");
        query.setParameter(1, idProduct);
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        ProductResponse productResponse = ProductResponse.builder()
                .name(list.get(0).toString())
                .price(list.get(1).toString())
                .build();
        return BaseResponse.ok(productResponse);

    }

}
