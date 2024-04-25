package restorder.orderproduk.service.ConsumeRestApi.CreateUser;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.CreateUserRequest;

public interface CreateUserService {

    BaseResponse<?> createuser(CreateUserRequest createUserRequest);


}
