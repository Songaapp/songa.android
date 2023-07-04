package app.songa.presentation.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.songa.R
import app.songa.presentation.screens.auth.AuthenticationMode
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.presentation.theme.GreenPrimary

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    enableAuthentication: Boolean,
    onAuthenticate: () -> Unit,
    authenticationState: AuthenticationState,
) {
    val focusManager = LocalFocusManager.current
    Button(
        modifier = modifier,
        onClick = {
            onAuthenticate()
            focusManager.clearFocus()
        },
        enabled = enableAuthentication,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            backgroundColor = GreenPrimary
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        if (authenticationState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.height(25.dp).width(25.dp),
                color = Color(0xFF0AFF7E),
//                modifier = Modifier.foreg(Color(0xFF0AFF7E)),
            )
        }
        else {
            Text(
                text = stringResource(
                    if (authenticationMode ==
                        AuthenticationMode.SIGN_IN
                    ) {
                        R.string.action_sign_in
                    } else {
                        R.string.action_sign_up
                    }
                )
            )
        }
    }
}