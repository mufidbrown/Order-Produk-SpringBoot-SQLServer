package restorder.orderproduk.service.ConsumeRestApi.retrofit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.api.ApiRetrofit;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.model.ConsumeRestApi.GithubResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;

@Service

public class RetrofitServiceImpl implements RetrofitService {


    private final ApiRetrofit apiRetrofit;

    public RetrofitServiceImpl(@Qualifier("GIHUB_HTTP_CLIENT")Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }

    @Override
    public BaseResponse<?> github() {
        AtomicReference<GithubResponse> respon = new AtomicReference<>();
        apiRetrofit.github()
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(respon::set)
                .subscribe();
        return BaseResponse.ok(respon.get());
    }
}
