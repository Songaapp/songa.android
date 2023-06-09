package app.songa.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.songa.presentation.screens.app.user.home.HomeScreen
import app.songa.presentation.screens.app.misc.support.Faqs
import app.songa.presentation.screens.app.user.home.HomePageScreen
import app.songa.presentation.screens.auth.Authentication
import app.songa.presentation.screens.auth.login.LogInScreen
import app.songa.presentation.screens.auth.SignUpScreen
import app.songa.presentation.screens.onboarding.SplashScreen
import app.songa.presentation.screens.onboarding.WebOpen
import kotlinx.coroutines.delay

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val isLoading = remember { mutableStateOf(true) }
    val isSplashScreenShown = remember { mutableStateOf(true) }

    LaunchedEffect(key1 = isLoading.value) {
        delay(2000)
        isLoading.value = false
        isSplashScreenShown.value = true
    }

    NavHost(navController = navController, startDestination =  "splash_screen" ){
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
            WebOpen(mUrl = "https://songa.app")
        }
        composable("home_page_screen") {
            HomePageScreen(navController = navController, "index")
        }
        composable("ride_history_screen") {
            HomePageScreen(navController = navController, "history")
        }
        composable("invite_friends_screen") {
            HomePageScreen(navController = navController, "invite")
        }
        composable("online_support_screen") {
            HomePageScreen(navController = navController, "support")
        }
        composable("settings_screen") {
            HomePageScreen(navController = navController, "settings")
        }
        composable("my_wallet_screen") {
            HomePageScreen(navController = navController, "wallet")
        }
        composable("login_screen") {
            LogInScreen(navController = navController, alpha = 0.75f)
        }

        composable("sign_up_screen") {
            SignUpScreen(navController = navController, 0.75f)
        }
        composable("edit_profile_screen") {
            HomePageScreen(navController = navController, "edit_profile")
        }
        composable("change_password_screen") {
            HomePageScreen(navController = navController, "change_password")
        }
        composable("authentication") {
            Authentication(navController = navController)
        }
    }
}

