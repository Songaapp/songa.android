package app.songa.presentation.components.forms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.songa.presentation.components.buttons.AuthenticationButton
import app.songa.presentation.screens.auth.AuthenticationMode
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.presentation.screens.auth.AuthenticationTitle
import app.songa.presentation.components.inputs.auth.FirstNameInput
import app.songa.presentation.components.inputs.auth.LastNameInput
import app.songa.presentation.components.inputs.auth.PasswordInput
import app.songa.presentation.screens.auth.PasswordRequirement
import app.songa.presentation.screens.auth.PasswordRequirements
import app.songa.presentation.components.inputs.auth.PhoneInput
import app.songa.presentation.screens.auth.ToggleAuthenticationMode

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    firstname: String?,
    lastname: String?,
    phone: String?,
    password: String?,
    completedPasswordRequirements: List<PasswordRequirements>,
    enableAuthentication: Boolean,
    authenticationMode: AuthenticationMode,
    onFirstNameChanged:(firstname: String) -> Unit,
    onLastNameChanged: (lastname: String) -> Unit,
    onPhoneChanged: (phone: String) -> Unit,
    onPasswordChanged: (password: String) -> Unit,
    onAuthenticate: () -> Unit,
    onToggleMode: () -> Unit,
    authenticationState: AuthenticationState
) {
    remember { mutableStateOf("")}
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuthenticationTitle(
            authenticationMode = authenticationMode
        )
        Spacer(modifier = Modifier.height(25.dp))
        val passwordFocusRequester = FocusRequester()
        val lastNameFocusRequester = FocusRequester()
        val phoneFocusRequester = FocusRequester()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            elevation = 0.dp,
            backgroundColor = Color.Transparent
        ) {
            Column(
//                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(
                    visible = authenticationMode ==
                            AuthenticationMode.SIGN_UP
                ) {
                    Row {
                        FirstNameInput(
                            modifier = Modifier
                                .height(50.dp)
                                .width(170.dp),
                            firstname = firstname ?: "",
                            onFirstNameChanged = onFirstNameChanged
                        ) {
                            lastNameFocusRequester.requestFocus()
                        }
                        LastNameInput(
                            modifier = Modifier.focusRequester(lastNameFocusRequester)
                                .height(50.dp)
                                .width(170.dp),
                            lastname = lastname ?: "",
                            onLastNameChanged = onLastNameChanged
                        ) {
                            phoneFocusRequester.requestFocus()
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                PhoneInput(
                    modifier = Modifier
                        .focusRequester(phoneFocusRequester)
                        .height(50.dp),
                    phone = phone?: "",
                    onPhoneChanged = onPhoneChanged
                )
                {
                        passwordFocusRequester.requestFocus()
                }
                Spacer(modifier = Modifier.height(10.dp))
                PasswordInput(
                    modifier = Modifier
                        .height(50.dp)
                        .focusRequester(passwordFocusRequester),
                    password = password ?: "",
                    onPasswordChanged = onPasswordChanged,
                    onDoneClicked = onAuthenticate,
                )
                Spacer(modifier = Modifier.height(10.dp))

                AnimatedVisibility(
                    visible = authenticationMode ==
                            AuthenticationMode.SIGN_UP
                ) {
                    PasswordRequirement(satisfiedRequirements = completedPasswordRequirements)
                }
                Spacer(modifier = Modifier.height(10.dp))

                AuthenticationButton(
                    enableAuthentication = enableAuthentication,
                    authenticationMode = authenticationMode,
                    onAuthenticate = onAuthenticate,
                    modifier = Modifier.width(170.dp),
                    authenticationState = authenticationState
                )

                Spacer(
                modifier = Modifier.height(20.dp)
                )

                ToggleAuthenticationMode(
                    authenticationMode = authenticationMode
                ) {
                    onToggleMode()
                }
            }
        }
    }
}
