package restorder.orderproduk.controller;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.controllers.ProductController;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    // Contoh method untuk menguji pengambilan semua produk
    @Test
    public void getAllProducts_ReturnsListOfProducts() throws Exception {
        // Buat objek tampilan dari produk
        Product product1 = new Product(5L, "Product 1", 1, 10000,"Description 1");
        Product product2 = new Product(6L, "Product 2", 2,  20000, "Description 2");

        // Buat objek tampilan dari semua produk
        List<Product> products = Arrays.asList(product1, product2);

        // Buat objek tampilan dari respons
        BaseResponse<List<Product>> response = BaseResponse.ok("Daftar Semua Produk", products);

        // Mock objek tampilan dari ProductService
        when(productService.getAllProducts()).thenReturn(products);

        // Jalankan permintaan HTTP GET
        mockMvc.perform(MockMvcRequestBuilders.get("/product/v1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is("OK")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Daftar Semua Produk")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name", Matchers.is("Product 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].description", Matchers.is("Description 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].price", Matchers.is(10000)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[1].name", Matchers.is("Product 2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[1].description", Matchers.is("Description 2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[1].price", Matchers.is(20000)));
    }
}







