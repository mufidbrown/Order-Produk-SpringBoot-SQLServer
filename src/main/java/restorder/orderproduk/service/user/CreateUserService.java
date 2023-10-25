package restorder.orderproduk.service.user;

import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.CreateUserRequest;
import restorder.orderproduk.model.RegisterRequest;

public interface CreateUserService {

    BaseResponse<?> createuser(CreateUserRequest createUserRequest);


}
