package restorder.orderproduk.service.consumeApi.register;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.config.ApiRetrofit;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.model.consumeApi.RegisterRequest;
import restorder.orderproduk.model.consumeApi.RegisterResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class RegisterServiceImpl implements RegisterService{

    private final ApiRetrofit apiRetrofit;

    public RegisterServiceImpl(@Qualifier("REGISTER_HTTP_CLIENT") Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }

    @Override
    public BaseResponse<?> register(RegisterRequest registerRequest) {
        AtomicReference<RegisterResponse> request = new AtomicReference<>();
        apiRetrofit.register(registerRequest)
                .doOnError((Throwable::printStackTrace))
                .doOnSuccess(request::set)
                .subscribe();
                return BaseResponse.ok(request.get());

    }
}


