package restorder.orderproduk.service.ConsumeRestApi.UserRetrofit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.api.ApiRetrofit;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.UserResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserServiceImpl implements UserService {

    private final ApiRetrofit apiRetrofit;


    public UserServiceImpl(@Qualifier("USER_HTTP_CLIENT") Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }


    @Override
    public BaseResponse<?> user(Integer id) {
        AtomicReference<UserResponse> respon = new AtomicReference<>();
        apiRetrofit.user(id)
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(respon::set)
                .subscribe();
        return BaseResponse.ok(respon.get());
    }


}
