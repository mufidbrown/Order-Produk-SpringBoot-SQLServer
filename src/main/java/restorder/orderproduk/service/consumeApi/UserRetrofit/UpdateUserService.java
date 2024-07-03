package restorder.orderproduk.service.ConsumeRestApi.UserRetrofit;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.ConsumeRestApi.UpdateUserRequest;

public interface UpdateUserService {


        BaseResponse<?> updateuser(Integer id, UpdateUserRequest updateUserRequest);

}
