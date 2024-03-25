package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;
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

}
