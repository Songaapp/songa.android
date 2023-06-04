package app.songa.domain

import app.songa.data.models.login.LoginRequest
import app.songa.data.models.login.UserRepository

class LoginUseCaseImpl(private val userRepository: UserRepository) : LoginUseCase {
    override suspend fun login(phone: String, password: String): User {
        val loginRequest = LoginRequest(phone, password)
        val loginResponse = userRepository.login(loginRequest.phone, loginRequest.password)
        return User(loginResponse.user.id, loginResponse.user.firstName, loginResponse.user.lastName, loginResponse.user.phone, loginResponse.user.email)
    }
}
