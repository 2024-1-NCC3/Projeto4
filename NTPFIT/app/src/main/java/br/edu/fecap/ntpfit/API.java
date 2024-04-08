package br.edu.fecap.ntpfit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {
    @POST("user.accounts/checkout")
    Call<String> loginCheck(@Header("AUTO")String autoToken);

}

