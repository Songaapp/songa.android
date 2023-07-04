package app.songa.presentation.screens.app.user.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import app.songa.data.users.StoreUserData
import app.songa.presentation.components.map.rememberMapViewWithLifecycle
import app.songa.presentation.components.nav.Drawer
import app.songa.presentation.components.nav.TopBarMenu
import app.songa.presentation.screens.app.misc.marketing.InvitedFriendsScreen
import app.songa.presentation.screens.app.misc.support.OnlineSupportScreen
import app.songa.presentation.screens.app.payments.MyWalletScreen
import app.songa.presentation.screens.app.rides.RideHistoryScreen
import app.songa.presentation.screens.app.user.settings.ChangePasswordScreen
import app.songa.presentation.screens.app.user.settings.EditProfileScreen
import app.songa.presentation.screens.app.user.settings.SettingsScreen
import app.songa.presentation.screens.auth.AuthenticationState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


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
            "history" -> RideHistoryScreen()
            "support" -> OnlineSupportScreen()
            "settings" -> SettingsScreen(navController = navController)
            "wallet" -> MyWalletScreen()
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
        val nairobi = LatLng(36.8219, 1.2921)
        var newlocation: LatLng? by remember { mutableStateOf(null) }
        var cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(nairobi, 10f)
        }

        val context = LocalContext.current
        var location: String by remember { mutableStateOf("Your location") }

        val requestPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted: Boolean ->
                if (isGranted) {
                    // Permission granted, update the location
                    CoroutineScope(Dispatchers.Main).launch {
                        val newLocation = getCurrentLocation(context)
                        if (newLocation != null) {
                            val latLng = LatLng(newLocation.first, newLocation.second)
                            location =
                                "Latitude: ${newLocation.first}, Longitude: ${newLocation.second}"
                            cameraPositionState.position =
                                CameraPosition.fromLatLngZoom(latLng, 15f)

                        }
                    }
                }
            }
        )





        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                if (hasLocationPermission(context)) {
                    // Permission already granted, update the location
                    CoroutineScope(Dispatchers.Main).launch {
                        val newLocation = getCurrentLocation(context)
                        if (newLocation != null) {
                            location =
                                "Latitude: ${newLocation.first}, Longitude: ${newLocation.second}"
                            cameraPositionState.position = CameraPosition.fromLatLngZoom(
                                LatLng(
                                    newLocation.first,
                                    newLocation.second
                                ), 15f
                            )
                            newlocation = LatLng(newLocation.first, newLocation.second)
                        }
                        delay(1000)
                    }
                } else {
                    // Request location permission
                    requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }
        )

        {
            val liveLocation = newlocation
            if (liveLocation != null) {
                Marker(
                    state = MarkerState(position = liveLocation),
                    title = "Marker",
                    snippet = "Marker"
                )
            }
        }

    }

}

fun hasLocationPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}

@SuppressLint("MissingPermission")
suspend fun getCurrentLocation(context: Context): Pair<Double, Double>? =
    suspendCoroutine { continuation ->
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val lat = location.latitude
                    val long = location.longitude
                    continuation.resume(Pair(lat, long))
                } else {
                    continuation.resume(null)
                }
            }
            .addOnFailureListener { exception ->
                // Handle location retrieval failure
                exception.printStackTrace()
                continuation.resume(null)
            }
    }