package app.songa.presentation.screens.auth

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val phone: String? = null,
    val password: String? = null,
//    val passwordRequirements: List = emptyList(),
    val passwordRequirements: List = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
){
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true &&
                phone?.isNotEmpty() == true &&
                (authenticationMode == AuthenticationMode.SIGN_IN
                        || passwordRequirements.containsAll(
                    PasswordRequirements.values().toList()))
    }
}
