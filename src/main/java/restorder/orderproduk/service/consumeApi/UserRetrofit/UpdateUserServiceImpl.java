package restorder.orderproduk.service.consumeApi.UserRetrofit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.api.ApiRetrofit;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.consumeApi.UpdateUserRequest;
import restorder.orderproduk.model.consumeApi.UpdateUserResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {

    private final ApiRetrofit apiRetrofit;

    public UpdateUserServiceImpl(@Qualifier("UPDATEUSER_HTTP_CLIENT") Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }

    @Override
    public BaseResponse<?> updateuser(Integer id, UpdateUserRequest updateUserRequest) {
        AtomicReference<UpdateUserResponse> respon = new AtomicReference<>();
        apiRetrofit.updateuser(id, updateUserRequest)
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(respon::set)
                .subscribe();
        return BaseResponse.ok(respon.get());
    }



}
