package restorder.orderproduk.service.register;

import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.RegisterRequest;

public interface RegisterService {


    BaseResponse<?>register(RegisterRequest registerRequest);



}
