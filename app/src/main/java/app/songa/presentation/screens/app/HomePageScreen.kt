package app.songa.presentation.screens.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import app.songa.ChangePasswordScreen
import app.songa.EditProfileScreen
import app.songa.presentation.components.TopBarMenu
import app.songa.presentation.components.Drawer
import app.songa.presentation.components.rememberMapViewWithLifecycle
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePageScreen(navController: NavController, custompage: String) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer(scope = coroutineScope, scaffoldState = scaffoldState, navController = navController)
        },
        topBar = {
            TopBarMenu(scope = coroutineScope, scaffoldState = scaffoldState, navController= navController)
                 },
        drawerGesturesEnabled = true,
        content = {
            when(custompage){
                "index" -> mapUI()
                "invite" -> InvitedFriendsScreen(navController = navController)
                "history" -> RideHistoryScreen(navController = navController)
                "support" -> OnlineSupportScreen(navController = navController)
                "settings" -> SettingsScreen(navController = navController)
                "wallet" -> MyWalletScreen(navController = navController)
                "edit_profile" -> EditProfileScreen(navController = navController)
                "change_password" -> ChangePasswordScreen(navController = navController)
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