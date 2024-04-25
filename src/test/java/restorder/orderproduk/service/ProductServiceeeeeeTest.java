package restorder.orderproduk.service;


import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.repositories.ProductRepository;
import restorder.orderproduk.service.product.ProductService;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceeeeeeTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        // Prepare data
        Product product = new Product(5L, "Product 1", 2, 10000, "Description 1");

        // Mock behaviour
        when(productRepository.save(product)).thenReturn(product);

        // Execute service method
        Product savedProduct = productService.createProduct(product);

        // Assert result
        assertEquals(product, savedProduct);
    }

    @Test
    public void testGetProductById() {
        // Prepare data
        Long id = 1L;
        Product product = new Product(1L, "Product 1", 2, 10000, "Description 1");

        // Mock behaviour
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        // Execute service method
        Product fetchedProduct = productService.getProductById(id);

        // Assert result
        assertEquals(product, fetchedProduct);
    }

    @Test
    public void testUpdateProduct() {
        // Prepare data
        Long id = 1L;
        Product product = new Product(1L, "Product 2", 3, 10000, "Description 1");

        // Mock behaviour
        when(productRepository.save(product)).thenReturn(product);

        // Execute service method
        Product updatedProduct = productService.updateProduct(id, product);

        // Assert result
        assertEquals(product, updatedProduct);
    }

    @Test
    public void testDeleteProduct() {
        // Prepare data
        Long id = 1L;

        // Execute service method
        productService.deleteProduct(id);

        // Assert result
        verify(productRepository).deleteById(id);
    }
}
