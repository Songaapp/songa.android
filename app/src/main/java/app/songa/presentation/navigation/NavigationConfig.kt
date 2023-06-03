package app.songa.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.songa.HomeScreen
import app.songa.data.api.AuthService
import app.songa.data.repositoryImplementation.AuthRepositoryImpl
import app.songa.presentation.screens.app.Faqs
import app.songa.presentation.screens.app.HomePageScreen
import app.songa.presentation.screens.app.RecoverScreen
import app.songa.presentation.screens.auth.LogInScreen
import app.songa.presentation.screens.auth.LogOutScreen
import app.songa.presentation.screens.auth.SignUpScreen
import app.songa.presentation.screens.onboarding.SplashScreen
import app.songa.presentation.screens.onboarding.WebOpen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_page_screen") {
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
        composable("logout_screen") {
            LogOutScreen(navController = navController)
        }
        composable("login_screen") {
            val authService: AuthService = AuthRepositoryImpl()
            LogInScreen(authService, navController = navController, 0.75f)
        }
        composable("sign_up_screen") {
            SignUpScreen(navController = navController, 0.75f)
        }
        composable("recover_screen") {
            RecoverScreen(navController = navController, 0.75f)
        }
        composable("edit_profile_screen") {
            HomePageScreen(navController = navController, "edit_profile")
        }
        composable("change_password_screen") {
            HomePageScreen(navController = navController, "change_password")
        }
//        composable("menu_pages") {
//            MenuPages(navController = navController)
//        }
    }
}