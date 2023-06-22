package app.songa.presentation.screens.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationViewModel : ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())
    private fun toggleAuthenticationMode() {
        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationMode = if (
            authenticationMode == AuthenticationMode.SIGN_IN
        ) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(
            authenticationMode = newAuthenticationMode
        )
    }
    private fun updateFirstName(firstname: String) {
        uiState.value = uiState.value.copy(
            firstname = firstname
        )
    }
    private fun updateLastName(lastname: String) {
        uiState.value = uiState.value.copy(
            lastname = lastname
        )
    }
    private fun updatePhone(phone: String) {
        uiState.value = uiState.value.copy(
            phone = phone
        )
    }
    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }
        uiState.value = uiState.value.copy(
            password = password,
            passwordRequirements = requirements.toList()
        )
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(
            isLoading = true
        )
        // trigger network request
    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(
            error = null
        )
    }

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
            is AuthenticationEvent.FirstNameChanged -> {
                updateFirstName(authenticationEvent.firstname)
            }
            is AuthenticationEvent.LastNameChanged -> {
                updateLastName(authenticationEvent.lastname)
            }
            is AuthenticationEvent.PhoneChanged -> {
                updatePhone(authenticationEvent.phone)
            }
            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }
            is AuthenticationEvent.Authenticate -> {
                authenticate()
            }
            is AuthenticationEvent.ErrorDismissed -> {
                dismissError()
            }
        }
    }
}
