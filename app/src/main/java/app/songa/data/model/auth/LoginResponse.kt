package app.songa.data.model.auth

data class LoginResponse(
    val token: String,
    val userId: String,
    // Additional properties specific to your API response
)