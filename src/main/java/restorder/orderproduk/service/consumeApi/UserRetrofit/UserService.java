package restorder.orderproduk.service.consumeApi.UserRetrofit;

import restorder.orderproduk.config.BaseResponse;

public interface UserService {

    BaseResponse<?> user(Integer id);

}
