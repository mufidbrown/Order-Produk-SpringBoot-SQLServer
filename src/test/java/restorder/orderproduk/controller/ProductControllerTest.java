package restorder.orderproduk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import restorder.orderproduk.controllers.ProductController;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct() {
        // Mock data
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Test Product");

        when(productService.createProduct(any(Product.class))).thenReturn(mockProduct);

        // Perform POST request
        ResponseEntity<Product> responseEntity = productController.createProduct(mockProduct);

        // Verify productService.createProduct is called and returns correct response
        verify(productService, times(1)).createProduct(any(Product.class));
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        Product createdProduct = responseEntity.getBody();
        assertEquals(mockProduct.getId(), createdProduct.getId());
        assertEquals(mockProduct.getName(), createdProduct.getName());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();

        when(productService.getAllProducts()).thenReturn(productList);

        ResponseEntity<List<Product>> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productList, responseEntity.getBody());
    }




//    @Test
//    public void  testCreateProduct() throws Exception{
//        Product input = new Product(1L, "keyboard", 2, 500.000, "mechanical");
//        Product returned = new Product(1L, "keyboard", 2, 500.000, "mechanical");
//        //stub the data
//        when(productService.createProduct(input)).thenReturn(returned);
//
//        //original method call
//        Product result = productController.createProduct(input).getBody();
//
//        Assert.assertEquals(result.getName(),"keyboard");
//    }


    @Test
    public void testUpdateProduct() throws Exception{
        Long product = 1L;
        Product input = new Product(1L, "piano", 3, 1000.000, "bagus");
        Product returned = new Product(1L, "piano_updated", 3, 1000.000, "bagus");
        //stub the data
        when(productService.updateProduct(1L,input)).thenReturn(returned);
        //original method call
        Product result = productController.updateProduct(1L,input).getBody();

        Assert.assertEquals(result.getName(), "piano_updated");
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product product = new Product(); // Create a dummy product or use Mockito to mock product data

        when(productService.getProductById(productId)).thenReturn(product);

        ResponseEntity<Product> responseEntity = productController.getProductById(productId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testDeleteProduct(){
        // Arrange
        Long productId = 1L;

        // Act
        ResponseEntity<Void> responseEntity = productController.deleteProduct(productId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(productService, Mockito.times(1)).deleteProduct(productId);
    }
}
