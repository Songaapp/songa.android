package app.songa.presentation.screens.app.user.home

import android.annotation.SuppressLint
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
import app.songa.presentation.components.nav.TopBarMenu
import app.songa.presentation.components.nav.Drawer
import app.songa.presentation.components.map.rememberMapViewWithLifecycle
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.data.users.StoreUserData
import app.songa.presentation.screens.app.user.settings.ChangePasswordScreen
import app.songa.presentation.screens.app.user.settings.EditProfileScreen
import app.songa.presentation.screens.app.misc.marketing.InvitedFriendsScreen
import app.songa.presentation.screens.app.payments.MyWalletScreen
import app.songa.presentation.screens.app.misc.support.OnlineSupportScreen
import app.songa.presentation.screens.app.rides.RideHistoryScreen
import app.songa.presentation.screens.app.user.settings.SettingsScreen
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePageScreen(navController: NavController, custompage: String) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val authenticationState = AuthenticationState()
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
    val userid = dataStore.getUserId.collectAsState(initial = "")
    val sessionToken = dataStore.getSessionToken.collectAsState(initial = "")

    authenticationState.isSignedIn = isSignedIn.value!! == "true"
    authenticationState.first_name = firstName.value!!
    authenticationState.last_name = lastName.value!!
    authenticationState.phone = phone.value!!
    authenticationState.email = email.value!!
    authenticationState.avatar = avatar.value!!
    authenticationState.address = address.value!!
    authenticationState.id = userid.value!!
    authenticationState.sessionToken = sessionToken.value!!

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer(
                scaffoldState = scaffoldState,
                navController = navController,
                authenticationState,
                dataStore
            )
        },
        topBar = {
            TopBarMenu(scope = coroutineScope, scaffoldState = scaffoldState)
                 },
        drawerGesturesEnabled = true
    ) {
        when (custompage) {
            "index" -> MapUI()
            "invite" -> InvitedFriendsScreen(navController = navController)
            "history" -> RideHistoryScreen(navController = navController)
            "support" -> OnlineSupportScreen(navController = navController)
            "settings" -> SettingsScreen(navController = navController)
            "wallet" -> MyWalletScreen(navController = navController)
            "edit_profile" -> EditProfileScreen(navController = navController)
            "change_password" -> ChangePasswordScreen(navController = navController)
        }
    }
}

@Composable
fun MapUI() {
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