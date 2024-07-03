package restorder.orderproduk.service.consumeApi.cat;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import restorder.orderproduk.config.ApiRetrofit;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.model.consumeApi.CatsResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class CatsServiceImpl implements CatsService {


    private final ApiRetrofit apiRetrofit;

    public CatsServiceImpl(@Qualifier("CATS_HTTP_CLIENT")Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }


    @Override
    public BaseResponse<?> cats() {
        AtomicReference<CatsResponse> respon = new AtomicReference<>();
        apiRetrofit.cats()
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(respon::set)
                .subscribe();
        return BaseResponse.ok(respon.get());
    }
}
