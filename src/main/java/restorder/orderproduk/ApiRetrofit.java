package restorder.orderproduk;

import io.reactivex.Single;
import restorder.orderproduk.model.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRetrofit {

    @GET("users/mojombo")
    Single<GithubResponse> github();

//  @GET("api/cats?tags=cute")
//    Single<CatsResponse> cats();

    @GET("us/33162")
    Single<CatsResponse> cats();


    @GET("/")
    Single<NationResponse> nation(
            @Query("name") String currentName

    );


    @POST("/api/register")
    Single<RegisterResponse> register(
            @Body RegisterRequest registerRequest);



}
