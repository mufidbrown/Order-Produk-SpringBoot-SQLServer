package restorder.orderproduk.service.userrr;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.UpdateUserRequest;

public interface UpdateUserService {


        BaseResponse<?> updateuser(Integer id, UpdateUserRequest updateUserRequest);

}
