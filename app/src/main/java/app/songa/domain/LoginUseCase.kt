package app.songa.domain

interface LoginUseCase {
    suspend fun login(phone: String, password: String): User
}

