package restorder.orderproduk.service.consumeApi.register;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.consumeApi.RegisterRequest;

public interface RegisterService {


    BaseResponse<?> register(RegisterRequest registerRequest);



}
