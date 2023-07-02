package app.songa.data.models

@Suppress("unused")
data class UserModel(
    var profile: ProfileModel
)

data class ProfileModel(
    var first_name: String?,
    var last_name: String?,
    var phone: String?,
    var email: String?,
    var avatar: String?,
    var address: String?,
    var id: String?,
    var sessionToken: String?
)

data class AuthModelLogin(
    var message: String? = null,
    var user: ProfileModel? = null
)

data class LoginModel(
    var phone: String?,
    var password: String?
)

data class RegisterModel(
    var first_name: String?,
    var last_name: String?,
    var phone: String?,
    var password: String?
)