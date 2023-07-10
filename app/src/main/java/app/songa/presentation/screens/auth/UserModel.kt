package app.songa.presentation.screens.auth

import com.google.gson.Gson
import com.squareup.moshi.Json

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
    var gender: String?,
    var dateCreated: String?,
    var updatedAt: String?,
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