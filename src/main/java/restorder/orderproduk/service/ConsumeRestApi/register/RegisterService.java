package restorder.orderproduk.service.ConsumeRestApi.register;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.RegisterRequest;

public interface RegisterService {


    BaseResponse<?>register(RegisterRequest registerRequest);



}