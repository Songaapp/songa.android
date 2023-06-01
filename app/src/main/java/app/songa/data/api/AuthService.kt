package app.songa.data.api

import app.songa.data.model.auth.LoginRequest
import app.songa.data.model.auth.LoginResponse
import app.songa.data.model.auth.RegisterRequest
import app.songa.data.model.auth.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
}
