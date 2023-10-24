package restorder.orderproduk.service.nation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import restorder.orderproduk.ApiRetrofit;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.model.GithubResponse;
import restorder.orderproduk.model.NationResponse;
import retrofit2.Retrofit;

import java.util.concurrent.atomic.AtomicReference;


@Service
public class NationServiceImpl implements NationService{

    private final ApiRetrofit apiRetrofit;


    public NationServiceImpl(@Qualifier("NATION_HTTP_CLIENT") Retrofit retrofit) {
        this.apiRetrofit = retrofit.create(ApiRetrofit.class);
    }

    @Override
    public BaseResponse<?> nation(String name) {
        AtomicReference<NationResponse> respon = new AtomicReference<>();
        apiRetrofit.nation(name)
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(respon::set)
                .subscribe();
        return BaseResponse.ok(respon.get());
    }
}
