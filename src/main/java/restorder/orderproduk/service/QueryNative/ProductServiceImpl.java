package restorder.orderproduk.service.QueryNative;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.ProductResponse;
import restorder.orderproduk.service.QueryNative.ServiceProduct;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ServiceProduct {

    private final EntityManager entityManager;


    @Override
    public BaseResponse<?> testproduct() {
        Query query = entityManager.createNativeQuery("SELECT name, price from products p WHERE id = 3");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        ProductResponse productResponse = ProductResponse.builder()
                .name(list.get(0).toString())
                .price(list.get(1).toString())
                .build();
        return BaseResponse.ok(productResponse);
    }

    @Override
    public BaseResponse<?> testParameterProduct(Integer idProduct) {
        Query query = entityManager.createNativeQuery("select name, price from products p WHERE id = ?1");
        query.setParameter(1, idProduct);
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        ProductResponse productResponse = ProductResponse.builder()
                .name(list.get(0).toString())
                .price(list.get(1).toString())
                .build();
        return BaseResponse.ok(productResponse);

    }

}
