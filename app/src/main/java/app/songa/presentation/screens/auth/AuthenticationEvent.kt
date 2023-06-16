package app.songa.presentation.screens.auth

import kotlinx.coroutines.flow.MutableStateFlow

sealed class AuthenticationEvent{
    object ToggleAuthenticationMode: AuthenticationEvent()
    val uiState = MutableStateFlow(AuthenticationState())
    class PhoneChanged(val phone: String):
        AuthenticationEvent()

    class PasswordChanged(val password: String):
        AuthenticationEvent()

    object Authenticate: AuthenticationEvent()

    object ErrorDismissed: AuthenticationEvent()
}
