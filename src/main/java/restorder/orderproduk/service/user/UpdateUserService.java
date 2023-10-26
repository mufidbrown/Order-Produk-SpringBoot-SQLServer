package restorder.orderproduk.service.user;

import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.UpdateUserRequest;

public interface UpdateUserService {


        BaseResponse<?> updateuser(Integer id, UpdateUserRequest updateUserRequest);

}
