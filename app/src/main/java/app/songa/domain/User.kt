package app.songa.domain

data class User(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val phone: String?,
    val email: String?
)
