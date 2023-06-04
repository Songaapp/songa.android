package app.songa.data.models.login

data class LoginResponse(
    val message: String,
    val user: UserResponse
)

data class UserResponse(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String?,
    val avatar: String?,
    val address: String?,
    val id: String,
    val sessionToken: String
)
