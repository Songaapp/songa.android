package app.songa

import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "online_support_screen") {
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
            LogInScreen(navController = navController, 0.75f)
        }
        composable("sign_up_screen") {
            SignUpScreen(navController = navController, 0.75f)
        }
        composable("recover_screen") {
            RecoverScreen(navController = navController, 0.75f)
        }
//        composable("menu_pages") {
//            MenuPages(navController = navController)
//        }
    }
}
