package app.songa.presentation.screens.app

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import app.songa.presentation.components.TopBarMenu
import app.songa.presentation.components.Drawer
import app.songa.presentation.components.rememberMapViewWithLifecycle
import app.songa.presentation.screens.auth.AuthenticationEvent
import app.songa.presentation.screens.auth.AuthenticationMode
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.presentation.screens.auth.AuthenticationViewModel
import app.songa.presentation.screens.auth.ProfileModel
import app.songa.presentation.screens.auth.users.StoreUserData
import app.songa.presentation.theme.GreenPrimary
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePageScreen(navController: NavController, custompage: String, viewModel: AuthenticationViewModel) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val authenticationState =
        viewModel.uiState.collectAsState().value
    //context
    val context = LocalContext.current
    // we instantiate the saveEmail class
    val dataStore = StoreUserData(context)

    val isSignedIn = dataStore.getLogin.collectAsState(initial = "")
    val firstName = dataStore.getFirstName.collectAsState(initial = "")
    val lastName = dataStore.getLastName.collectAsState(initial = "")
    val phone = dataStore.getPhone.collectAsState(initial = "")
    val email = dataStore.getEmail.collectAsState(initial = "")
    val avatar = dataStore.getAvatar.collectAsState(initial = "")
    val address = dataStore.getAddress.collectAsState(initial = "")
    val gender = dataStore.getGender.collectAsState(initial = "")
    val dateCreated = dataStore.getDateCreated.collectAsState(initial = "")
    val updatedAt = dataStore.getUpdatedAt.collectAsState(initial = "")
    val userid = dataStore.getUserId.collectAsState(initial = "")
    val sessionToken = dataStore.getSessionToken.collectAsState(initial = "")

    authenticationState.isSignedIn = if(isSignedIn.value!! == "true") {true}else{false}
    authenticationState.first_name = firstName.value!!
    authenticationState.last_name = lastName.value!!
    authenticationState.phone = phone.value!!
    authenticationState.email = email.value!!
    authenticationState.avatar = avatar.value!!
    authenticationState.address = address.value!!
    authenticationState.gender = gender.value!!
    authenticationState.dateCreated = dateCreated.value!!
    authenticationState.updatedAt = updatedAt.value!!
    authenticationState.id = userid.value!!
    authenticationState.sessionToken = sessionToken.value!!

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer(scope = coroutineScope, scaffoldState = scaffoldState, navController = navController, authenticationState, dataStore)
        },
        topBar = {
            TopBarMenu(scope = coroutineScope, scaffoldState = scaffoldState)
                 },
        drawerGesturesEnabled = true,
        content = {
            val handleEvent = viewModel::handleEvent
            when(custompage){
                "index" -> mapUI()
                "invite" -> InvitedFriendsScreen(navController = navController)
                "history" -> RideHistoryScreen(navController = navController)
                "support" -> OnlineSupportScreen(navController = navController)
                "settings" -> SettingsScreen(navController = navController)
                "wallet" -> MyWalletScreen(navController = navController)
                "edit_profile" -> EditProfileScreen(navController = navController)
                "change_password" -> {
                    val newAuthenticationMode = AuthenticationMode.CHANGE_PASSWORD
                    handleEvent(
                        AuthenticationEvent.ChangePasswordAuthenticationMode
                    )
                    Log.d("Main", "-------> Changed Mode: "+ authenticationState.authenticationMode)
                    ChangePasswordScreen(
                        navController = navController,
                        authenticationState = authenticationState,
                        handleEvent = handleEvent,
                    )
                }
            }
        }
    )
}

@Composable
fun mapUI() {
    val mapView = rememberMapViewWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        AndroidView({mapView}) { mapView ->
            CoroutineScope(Dispatchers.Main).launch {
                val map = mapView.awaitMap()

                map.uiSettings.isZoomControlsEnabled = true
            }
        }
    }


}