package restorder.orderproduk;

import io.reactivex.Single;
import org.springframework.web.bind.annotation.RequestBody;
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


    @POST("/api/users")
    Single<CreateUserResponse> createuser(
            @Body CreateUserRequest createUserRequest
    );


    @GET("/api/users/{id}")
    Single<UserResponse> user(
            @Path("id") Integer id
    );


    @PUT("/api/users/{id}")
    Single<UpdateUserResponse> updateuser(
            @Path("id") Integer id, @Body UpdateUserRequest updateUserRequest
    );



}
