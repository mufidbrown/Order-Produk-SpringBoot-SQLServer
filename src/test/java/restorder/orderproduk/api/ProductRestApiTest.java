package restorder.orderproduk.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.ProductRepository;
import restorder.orderproduk.service.ProductService;

import java.util.List;
import java.util.Optional;

import static java.lang.reflect.Array.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Product.class)
public class ProductRestApiTest {


    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository productRepository;


    @Test
    void should_return_product_list() throws Exception {
        Product product = this.buildTestingProduct();
        when(productRepository.findAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("NAME")))
                .andExpect((ResultMatcher) jsonPath("$[0].quantity", is("QUANTITY")));
    }

    private RequestBuilder get(String s) {

        return null;
    }

    private Product buildTestingProduct() {
            Product product = new Product();
            product.setId(10L);
            product.setName("NAME");
            product.setQuantity(2);
            return product;
    }

    @Test
    void should_return_product() throws Exception {
        Product product = this.buildTestingProduct();
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));

        mockMvc.perform(get("/api/products/2"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$.name", is("NAME")))
                .andExpect((ResultMatcher) jsonPath("$.quantity", is("QUANTITY")));
    }

//    @Test
//    void should_add_new_product() throws Exception {
//        Product product = this.buildTestingProduct();
//        when(productRepository.save(any(Product.class))).thenReturn(product);
//
//        mockMvc.perform(post("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"firstName\": \"FIRST_NAME\", \"lastName\": \"LAST_NAME\" }"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName", is("FIRST_NAME")))
//                .andExpect(jsonPath("$.lastName", is("LAST_NAME")));
//    }
//
//    @Test
//    void should_update_existing_employee() throws Exception {
//        Product product = this.buildTestingProduct();
//        when(productRepository.save(any(Product.class))).thenReturn(product);
//
//        mockMvc.perform(put("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"id\": 1 , \"firstName\": \"FIRST_NAME\", \"lastName\": \"LAST_NAME\" }"))
//                .andExpect(status().isOk());
//    }

    @Test
    void should_remove_product() throws Exception {
        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());

    }
}


