package restorder.orderproduk.service;

import restorder.orderproduk.api.BaseResponse;

public interface ServiceProduct {

    BaseResponse<?> testproduct();

    BaseResponse<?> testParameterProduct(Integer idProduct);

}
