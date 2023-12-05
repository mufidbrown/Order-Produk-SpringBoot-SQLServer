package restorder.orderproduk.controller;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import restorder.orderproduk.controllers.ProductController;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;


public class ProductControllerrrrrTest {


    @Autowired
    private MockMvc mockMvc;

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

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product product = new Product(); // Create a dummy product or use Mockito to mock product data
//        1L, "gitar", 2, 1.000000, "akustik"
        when(productService.getProductById(productId)).thenReturn(product);

        ResponseEntity<Product> responseEntity = productController.getProductById(productId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }



//    @Test
//    public void testUpdateProduct() throws Exception{
//        Product input = new Product(1L, "",  2, 1000000, "akustik");
//        Product returned = new Product(1L,"gitar",  2, 1.000000, "akustik");
//        //stub the data
//        when(productService.updateProduct(1L,input)).thenReturn(returned);
//
//        //original method call
//        Product result = productController.updateProduct(1L,input).getBody();
//
//        Assert.assertEquals(result.getName(), "gitar");
//    }


//        @Test
//        public void testUpdateProduct() throws Exception {
//            Product product = new Product(1L, "gitar",  2, 1000000, "akustik");
//            Product saveProduct = productService.createProduct(product);
//
//            product.setName("gitar");
//            product.setQuantity(2);
//            product.setPrice(1000000);
//
//            mockMvc.perform(MockMvcRequestBuilders.put("api/products/update/{id}" + saveProduct.getId())
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(new ObjectMapper().writeValueAsString(product)))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(product.getName())));
//        }









    // untuk inject dependencies Unit Test nya pakai JunitTest / JupiterTest? soalnya di pom.xml
    //terdapat dependencies Junit & Jupiter




}
