package restorder.orderproduk.service.consumeApi.UserRetrofit;

import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.model.consumeApi.CreateUserRequest;

public interface CreateUserService {

    BaseResponse<?> createuser(CreateUserRequest createUserRequest);


}
