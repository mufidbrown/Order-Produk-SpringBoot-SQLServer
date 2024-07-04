package restorder.orderproduk.service.consumeApi.UserRetrofit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.api.ApiRetrofit;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.consumeApi.CreateUserRequest;
import restorder.orderproduk.model.consumeApi.CreateUserResponse;
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
