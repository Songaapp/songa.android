package app.songa.presentation.screens.auth.login

sealed class LoginState {
    object Loading: LoginState()
    data class Error(val e: String): LoginState()
}
