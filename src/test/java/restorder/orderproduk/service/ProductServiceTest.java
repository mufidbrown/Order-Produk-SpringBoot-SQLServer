package restorder.orderproduk.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.repositories.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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

    @Test
    public void testCreateProduct() throws Exception{
        Product input1 = new Product(1L, "keyboard", 2, 500.000, "mechanical");
        Product input2 = new Product(2L,"mouse", 1, 400.000, "wirelles");

        Product returned1 = new Product(1L, "keyboard", 2, 500.000, "mechanical");
        Product returned2 = new Product(2L,"mouse", 1, 400.000, "wirelles");

        //stub the data
        Mockito.when(productRepository.save(input1)).thenReturn(returned1);
        Mockito.when(productRepository.save(input2)).thenReturn(returned2);

        //actual method call
        Product result1 = productService.createProduct(input1);
        Product result2 = productService.createProduct(input2);

        Assert.assertEquals("keyboard", result1.getName());
        Assert.assertEquals("mouse", result2.getName());
    }

    @Test
    public void testUpdateProduct(){
        Product input = new Product(1L, "keyboard", 2, 500.000, "mechanical");

        Product returned = new Product(1L, "keyboard_updated", 2, 600.000, "mechanical");

        //stub the data
        Mockito.when(productRepository.getOne(1L)).thenReturn(input);
        Mockito.when(productRepository.save(input)).thenReturn(returned);

        //actual method call
        Product result = productService.updateProduct(1L,input);

        Assert.assertEquals("keyboard", result.getName());
    }


    @Test
    public void testDeleteProduct() throws Exception{
        Product input = new Product(1L, "keyboard", 2, 600.000, "mechanical");

        //stub the data
        Mockito.when(productRepository.getOne(1L)).thenReturn(input);
        doNothing().when(productRepository).delete(input);

        productService.deleteProduct(1L);
    }
}

