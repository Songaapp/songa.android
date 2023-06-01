package app.songa.data.repositoryImplementation

import app.songa.data.api.AuthService
import app.songa.data.model.auth.LoginRequest
import app.songa.data.model.auth.LoginResponse
import app.songa.data.model.auth.RegisterRequest
import app.songa.data.model.auth.RegisterResponse
import retrofit2.Response

class AuthRepositoryImpl : AuthService {
    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun register(registerRequest: RegisterRequest): Response<RegisterResponse> {
        TODO("Not yet implemented")
    }
}