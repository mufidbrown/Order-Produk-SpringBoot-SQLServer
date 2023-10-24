package restorder.orderproduk;

import io.reactivex.Single;
import jakarta.persistence.Id;
import restorder.orderproduk.model.*;
import retrofit2.http.*;

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
            @Body RegisterRequest registerRequest
    );


    @GET("/api/users/{id}")
    Single<UserResponse> user(
            @Path("id") Integer id
    );




}
