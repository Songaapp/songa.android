package app.songa.presentation.screens.auth

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AuthenticationAPI {
//    @Headers(
//        "Accept: application/json"
//    )
    @GET("users/{id}")
    abstract fun getUserById(@Path("id") id: String): Call<UserModel?>?


    @Headers(
        "Accept: application/json"
    )
    @POST("login-user")
    fun login(@Body loginModel: LoginModel?): Call<AuthModelLogin?>?
}