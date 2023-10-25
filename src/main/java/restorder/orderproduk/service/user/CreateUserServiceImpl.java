package restorder.orderproduk.service.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.ApiRetrofit;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.CreateUserRequest;
import restorder.orderproduk.model.CreateUserResponse;
import restorder.orderproduk.model.RegisterRequest;
import restorder.orderproduk.model.RegisterResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    private final ApiRetrofit apiRetrofit;


    public CreateUserServiceImpl(@Qualifier("CREATEUSER_HTTP_CLIENT") Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }



    @Override
    public BaseResponse<?> createuser(CreateUserRequest createUserRequest) {
        AtomicReference<CreateUserResponse> respon = new AtomicReference<>();
        apiRetrofit.createuser(createUserRequest)
                .doOnError((Throwable::printStackTrace))
                .doOnSuccess(respon::set)
                .subscribe();
        return BaseResponse.ok(respon.get());
    }
}
