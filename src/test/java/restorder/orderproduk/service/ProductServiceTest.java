package restorder.orderproduk.service;


import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void getAllProducts_ShouldReturnProductList() {
        // Arrange
        List<Product> productList = Arrays.asList(
                new Product(1L, "Product1", 10.0),
                new Product(2L, "Product2", 15.0));
        Mockito.when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> result = productService.getAllProducts();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getName());
        assertEquals("Product2", result.get(1).getName());
    }

    @Test
    public void getProductById_ShouldReturnProduct() {
        // Arrange
        Long productId = 1L;
        Product product = new Product(productId, "Product1", 10.0);
        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Act
        Product result = productService.getProductById(productId);

        // Assert
        assertEquals(productId, result.getId());
        assertEquals("Product1", result.getName());
        assertEquals(10.0, result.getPrice(), 0.01);
    }

}
