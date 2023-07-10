package app.songa.presentation.screens.auth

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.songa.R
import app.songa.presentation.screens.app.ChangePasswordScreen
import app.songa.presentation.screens.app.EditProfileScreen
import app.songa.presentation.screens.auth.users.StoreUserData
import app.songa.presentation.theme.GreenPrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,
    navController: NavController,
    alpha: Float = 0.5f,
) {
    if(authenticationState.isSignedIn && authenticationState.authenticationMode == AuthenticationMode.CHANGE_PASSWORD) {

        Text(text = "Password", color = Color.Red)
    }
    if(authenticationState.isSignedIn && authenticationState.authenticationMode == AuthenticationMode.CHANGE_PASSWORD) {
        authenticationState.authenticationMode.apply {
            AuthenticationMode.ACCOUNT_SETTINGS
        }
        Text(text = "Account Settings", color = Color.Red)
    }
    if(authenticationState.isSignedIn && authenticationState.authenticationMode != AuthenticationMode.CHANGE_PASSWORD) {
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        val userDataStore = StoreUserData(context)
        LaunchedEffect(Unit) {
            while(true) {
                delay(500)
                scope.launch {
                    userDataStore.saveLogin(name = "true")
                    authenticationState.first_name?.let { userDataStore.saveFirstName(name = it) }
                    authenticationState.last_name?.let { userDataStore.saveLastName(name = it) }
                    authenticationState.phone?.let { userDataStore.savePhone(name = it) }
                    authenticationState.email?.let { userDataStore.saveEmail(name = it) }
                    authenticationState.avatar?.let { userDataStore.saveAvatar(name = it) }
                    authenticationState.address?.let { userDataStore.saveAddress(name = it) }
                    authenticationState.gender?.let { userDataStore.saveAddress(name = it) }
                    authenticationState.address?.let { userDataStore.saveAddress(name = it) }
                    authenticationState.address?.let { userDataStore.saveAddress(name = it) }
                    authenticationState.id?.let { userDataStore.saveUserId(name = it) }
                    authenticationState.sessionToken?.let { userDataStore.saveSessionToken(name = it) }
                }
                 navController.navigate("home_page_screen")
            }
        }
    }
    else {
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
                    .padding(top = 10.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if(authenticationState.authenticationMode == AuthenticationMode.CHANGE_PASSWORD || authenticationState.authenticationMode == AuthenticationMode.ACCOUNT_SETTINGS) {}
                else {
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
                }
                Spacer(modifier = Modifier.height(10.dp))
//            if (authenticationState.isLoading) {
////            Spacer(modifier = Modifier.height(70.dp))
//                CircularProgressIndicator()
//                println(authenticationState.phone);
//                println(authenticationState.password);
//            } else {
                AuthenticationForm(
                    modifier = Modifier.fillMaxSize(),
                    authenticationMode = authenticationState.authenticationMode,
                    firstname = authenticationState.first_name,
                    lastname = authenticationState.last_name,
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
                    onOldPasswordChanged =  {
                        handleEvent(AuthenticationEvent.OldPasswordChanged(it))
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
                    },
                    authenticationState = authenticationState
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
//            }
            }
        }
    }
}