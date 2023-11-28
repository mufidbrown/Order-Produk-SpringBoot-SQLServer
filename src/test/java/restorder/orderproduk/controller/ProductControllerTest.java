package restorder.orderproduk.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import restorder.orderproduk.controllers.ProductController;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        // Add some dummy products to the list or use Mockito to mock product data

        when(productService.getAllProducts()).thenReturn(productList);

        ResponseEntity<List<Product>> responseEntity = productController.getAllProducts();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(productList, responseEntity.getBody());
    }








    
    // untuk inject dependencies Unit Test nya pakai JunitTest / JupiterTest? soalnya di pom.xml
    //terdapat dependencies Junit & Jupiter



}
