package restorder.orderproduk.service.user;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.CreateUserRequest;

public interface CreateUserService {

    BaseResponse<?> createuser(CreateUserRequest createUserRequest);


}
