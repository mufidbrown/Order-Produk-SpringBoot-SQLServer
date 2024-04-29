package restorder.orderproduk.service.ConsumeRestApi.UserRetrofit;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.ConsumeRestApi.CreateUserRequest;

public interface CreateUserService {

    BaseResponse<?> createuser(CreateUserRequest createUserRequest);


}
