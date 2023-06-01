package app.songa.data.model.auth

data class LoginRequest(
    val phone: String,
    val password: String
)