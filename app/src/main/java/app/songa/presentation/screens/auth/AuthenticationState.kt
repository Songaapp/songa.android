package app.songa.presentation.screens.auth

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val firstname: String? = null,
    val lastname: String? = null,
    val phone: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
){
    fun isFormValid(): Boolean {
        if(authenticationMode == AuthenticationMode.SIGN_UP) {
            return firstname?.isNotEmpty() == true && lastname?.isNotEmpty() == true && password?.isNotEmpty() == true &&
                    phone?.isNotEmpty() == true &&
                    (authenticationMode == AuthenticationMode.SIGN_IN
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
