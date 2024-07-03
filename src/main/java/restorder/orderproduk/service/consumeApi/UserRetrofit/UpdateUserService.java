package restorder.orderproduk.service.consumeApi.UserRetrofit;

import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.model.consumeApi.UpdateUserRequest;

public interface UpdateUserService {


        BaseResponse<?> updateuser(Integer id, UpdateUserRequest updateUserRequest);

}
