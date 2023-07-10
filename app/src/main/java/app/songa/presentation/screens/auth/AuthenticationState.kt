package app.songa.presentation.screens.auth

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    var first_name: String? = null,
    var last_name: String? = null,
    var phone: String? = "", // "0757478812",
    val password: String? = "", // "manyara5766",
    val oldpassword: String? = "",
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    var isSignedIn: Boolean = false,
    var email: String? = null,
    var avatar: String? = null,
    var address: String? = null,
    var gender: String? = null,
    var dateCreated: String? = null,
    var updatedAt: String? = null,
    var id: String? = null,
    var sessionToken: String? = null

){
    fun isFormValid(): Boolean {
        if(authenticationMode == AuthenticationMode.SIGN_UP) {
            return first_name?.isNotEmpty() == true && last_name?.isNotEmpty() == true && password?.isNotEmpty() == true &&
                    phone?.isNotEmpty() == true &&
                    (authenticationMode == AuthenticationMode.SIGN_IN
                            || passwordRequirements.containsAll(
                        PasswordRequirements.values().toList()))
        }
        else if(authenticationMode == AuthenticationMode.CHANGE_PASSWORD) {
            return password?.isNotEmpty() == true &&
                    oldpassword?.isNotEmpty() == true &&
                    (authenticationMode == AuthenticationMode.CHANGE_PASSWORD
                            || passwordRequirements.containsAll(
                        PasswordRequirements.values().toList()))
        }
        else {
            return password?.isNotEmpty() == true &&
                    phone?.isNotEmpty() == true &&
                    (authenticationMode == AuthenticationMode.SIGN_IN
                            || passwordRequirements.containsAll(
                        PasswordRequirements.values().toList()))
        }
    }
}
