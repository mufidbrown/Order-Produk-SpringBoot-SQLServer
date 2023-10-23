package restorder.orderproduk;

import io.reactivex.Single;
import restorder.orderproduk.model.CatsResponse;
import restorder.orderproduk.model.GithubResponse;
import retrofit2.http.GET;

public interface ApiRetrofit {

    @GET("users/mojombo")
    Single<GithubResponse> github();

  @GET("api/cats?tags=cute")
    Single<CatsResponse> cats();


}
