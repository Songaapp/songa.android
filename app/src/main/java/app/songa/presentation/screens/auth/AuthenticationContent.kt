package app.songa.presentation.screens.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.songa.R
import app.songa.presentation.theme.GreenPrimary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,
    alpha: Float = 0.5f
) {
    Scaffold(
        drawerGesturesEnabled = false,
        modifier = modifier,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black, GreenPrimary)
                    )
                )
        ) {}
        Surface(
            color = Color.Black, modifier = Modifier
                .fillMaxSize()
                .alpha(alpha)
        ) {}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFFD9D9D9), shape = CircleShape)
                    .border(
                        BorderStroke(
                            1.dp,
                            SolidColor(
                                Color(0xFFD9D9D9),
                            )
                        ),
                        shape = CircleShape
                    ),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.usergreen),
                    contentDescription = "User Placeholder",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(72.75.dp)
                        .height(67.5.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (authenticationState.isLoading) {
//            Spacer(modifier = Modifier.height(70.dp))
                CircularProgressIndicator()
                println(authenticationState.phone);
                println(authenticationState.password);
            } else {
                AuthenticationForm(
                    modifier = Modifier.fillMaxSize(),
                    authenticationMode = authenticationState.authenticationMode,
                    firstname  = authenticationState.firstname,
                    lastname = authenticationState.lastname,
                    phone = authenticationState.phone,
                    password = authenticationState.password,
                    completedPasswordRequirements = authenticationState.passwordRequirements,
                    enableAuthentication = authenticationState.isFormValid(),
                    onFirstNameChanged = {
                        handleEvent(AuthenticationEvent.FirstNameChanged(it))
                    },
                    onLastNameChanged = {
                        handleEvent(AuthenticationEvent.LastNameChanged(it))
                    },
                    onPhoneChanged = {
                        handleEvent(AuthenticationEvent.PhoneChanged(it))
                    },
                    onPasswordChanged = {
                        handleEvent(
                            AuthenticationEvent.PasswordChanged(it)
                        )
                    },
                    onAuthenticate = {
                        handleEvent(AuthenticationEvent.Authenticate)
                    },
                    onToggleMode = {
                        handleEvent(
                            AuthenticationEvent.ToggleAuthenticationMode
                        )
                    }
                )
                authenticationState.error?.let { error ->
                    AuthenticationErrorDialog(
                        error = error,
                        dismissError = {
                            handleEvent(
                                AuthenticationEvent.ErrorDismissed
                            )
                        }
                    )
                }
            }
        }
    }
}