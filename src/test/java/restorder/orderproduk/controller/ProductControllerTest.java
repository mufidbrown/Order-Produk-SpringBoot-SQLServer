package restorder.orderproduk.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import restorder.orderproduk.controllers.ProductController;
import restorder.orderproduk.controllers.UserController;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();

        when(productService.getAllProducts()).thenReturn(productList);

        ResponseEntity<List<Product>> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productList, responseEntity.getBody());
    }

    @Test
    public void  testCreateProduct() throws Exception{
        Product input = new Product(1L, "keyboard", 2, 500.000, "mechanical");
        Product returned = new Product(1L, "keyboard", 2, 500.000, "mechanical");
        //stub the data
        when(productService.createProduct(input)).thenReturn(returned);

        //original method call
        Product result = productController.createProduct(input).getBody();

        Assert.assertEquals(result.getName(),"keyboard");
    }


    @Test
    public void testUpdateProduct() throws Exception{
        Product input = new Product(1L, "keyboard", 2, 500.000, "mechanical");
        Product returned = new Product(1L, "keyboard", 2, 500.000, "mechanical");
        //stub the data
        when(productService.updateProduct(1L,input)).thenReturn(returned);

        //original method call
        Product result = productController.updateProduct(1L,input).getBody();

        Assert.assertEquals(result.getName(), "keyboard");
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
        Mockito.verify(productService, Mockito.times(1)).deleteProduct(productId);
    }
}
