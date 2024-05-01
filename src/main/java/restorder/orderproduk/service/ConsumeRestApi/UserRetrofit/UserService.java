package restorder.orderproduk.service.ConsumeRestApi.UserRetrofit;

import restorder.orderproduk.api.BaseResponse;

public interface UserService {

    BaseResponse<?> user(Integer id);

}
