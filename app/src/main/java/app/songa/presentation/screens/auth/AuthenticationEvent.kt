package app.songa.presentation.screens.auth

import kotlinx.coroutines.flow.MutableStateFlow

sealed class AuthenticationEvent{
    object ToggleAuthenticationMode: AuthenticationEvent()
    object ChangePasswordAuthenticationMode: AuthenticationEvent()
    object AccountSettingsAuthenticationMode: AuthenticationEvent()
    val uiState = MutableStateFlow(AuthenticationState())
    class FirstNameChanged(val firstname: String):
        AuthenticationEvent()

    class LastNameChanged(val lastname: String):
        AuthenticationEvent()

    class PhoneChanged(val phone: String):
        AuthenticationEvent()

    class PasswordChanged(val password: String):
        AuthenticationEvent()

    class OldPasswordChanged(val oldPassword: String):
        AuthenticationEvent()

    object Authenticate: AuthenticationEvent()

    object ErrorDismissed: AuthenticationEvent()
}
