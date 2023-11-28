package restorder.orderproduk.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.repositories.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductById() {
        long productId = 1L;
        Product sampleProduct = new Product();
        sampleProduct.setId(productId);
        sampleProduct.setName("Test Product");

        // Mocking the behavior of the productRepository
        when(productRepository.findById(productId)).thenReturn(Optional.of(sampleProduct));

        // Invoking the method to test
        Product foundProduct = productService.getProductById(productId);

        // Assertions
        assertEquals(productId, foundProduct.getId());
        assertEquals("Test Product", foundProduct.getName());

        // Verifying that the repository method was called with the correct ID
        verify(productRepository, times(1)).findById(productId);
    }
}

