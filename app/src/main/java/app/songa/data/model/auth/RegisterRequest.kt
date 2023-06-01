package app.songa.data.model.auth

data class RegisterRequest(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val password: String,
    // Additional properties specific to your API request
)