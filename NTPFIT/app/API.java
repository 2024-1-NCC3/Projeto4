import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("/login")
    Call<Void> Login(@Body LoginReq loginReq);
}
