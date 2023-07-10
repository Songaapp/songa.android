package app.songa.presentation.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.songa.HomeScreen
import app.songa.domain.LoginUseCase
import app.songa.presentation.screens.app.Faqs
import app.songa.presentation.screens.app.HomePageScreen
import app.songa.presentation.screens.app.RecoverScreen
import app.songa.presentation.screens.auth.Authentication
import app.songa.presentation.screens.auth.AuthenticationEvent
import app.songa.presentation.screens.auth.AuthenticationMode
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.presentation.screens.auth.AuthenticationViewModel
import app.songa.presentation.screens.auth.login.LogInScreen
import app.songa.presentation.screens.auth.LogOutScreen
import app.songa.presentation.screens.auth.SignUpScreen
import app.songa.presentation.screens.onboarding.SplashScreen
import app.songa.presentation.screens.onboarding.WebOpen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Navigation() {
    val navController = rememberNavController()
//    val isLoading = remember { mutableStateOf(true) }
//    val isSplashScreenShown = remember { mutableStateOf(true) }
//    val scope = rememberCoroutineScope()
    val viewModel: AuthenticationViewModel = viewModel()
//    val authenticationState = viewModel.uiState.collectAsState().value
//    val handleEvent = viewModel::handleEvent

//    LaunchedEffect(key1 = isLoading.value) {
//        delay(2000)
//        isLoading.value = false
//        isSplashScreenShown.value = true
//    }

    NavHost(navController = navController, startDestination =  "splash_screen" ){// if (isSplashScreenShown.value) "splash_screen" else "login_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController, 0.9f)
        }
        composable("home_screen"){
            HomeScreen(navController = navController, 0.9f)
        }
        composable("faqs_screen"){
            Faqs(navController = navController, 0.75f)
        }
        composable("website_screen") {
            WebOpen(navController = navController, mUrl = "https://songa.app")
        }
        composable("home_page_screen") {
            HomePageScreen(navController = navController, "index", viewModel)
        }
        composable("ride_history_screen") {
            HomePageScreen(navController = navController, "history", viewModel)
        }
        composable("invite_friends_screen") {
            HomePageScreen(navController = navController, "invite", viewModel)
        }
        composable("online_support_screen") {
            HomePageScreen(navController = navController, "support", viewModel)
        }
        composable("settings_screen") {
            HomePageScreen(navController = navController, "settings", viewModel)
        }
        composable("my_wallet_screen") {
            HomePageScreen(navController = navController, "wallet", viewModel)
        }
        composable("logout_screen") {
            LogOutScreen(navController = navController)
        }
        composable("login_screen") {
            LogInScreen(navController = navController, alpha = 0.75f)
        }

        composable("sign_up_screen") {
            SignUpScreen(navController = navController, 0.75f)
        }
        composable("recover_screen") {
            RecoverScreen(navController = navController, 0.75f)
        }
        composable("edit_profile_screen") {
            HomePageScreen(navController = navController, "edit_profile", viewModel)
//            Authentication(navController = navController, viewModel)
        }
        composable("change_password_screen") {
            HomePageScreen(navController = navController, "change_password", viewModel)
//            Authentication(navController = navController, viewModel)
        }
        composable("authentication") {
            Authentication(navController = navController, viewModel)
        }
//        composable("menu_pages") {
//            MenuPages(navController = navController)
//        }
    }
}

