package restorder.orderproduk.service.register;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.RegisterRequest;

public interface RegisterService {


    BaseResponse<?>register(RegisterRequest registerRequest);



}
