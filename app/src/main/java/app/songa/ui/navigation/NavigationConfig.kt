package app.songa.ui.navigation

import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.songa.LogOutScreen
import app.songa.ui.screens.Faqs
import app.songa.ui.screens.HomePageScreen
import app.songa.ui.screens.HomeScreen
import app.songa.ui.screens.InvitedFriendsScreen
import app.songa.ui.screens.MyWalletScreen
import app.songa.ui.screens.OnlineSupportScreen
import app.songa.ui.screens.RideHistoryScreen
import app.songa.ui.screens.SettingsScreen
import app.songa.ui.screens.SplashScreen
import app.songa.ui.screens.WebOpen

@Composable
fun Navigation() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen") {
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
            HomePageScreen(navController = navController)
        }
        composable("ride_history_screen") {
            RideHistoryScreen(navController = navController)
        }
        composable("invite_friends_screen") {
            InvitedFriendsScreen(navController = navController)
        }
        composable("online_support_screen") {
            OnlineSupportScreen(navController = navController)
        }
        composable("settings_screen") {
            SettingsScreen(navController = navController)
        }
        composable("my_wallet_screen") {
            MyWalletScreen(navController = navController)
        }
        composable("logout_screen") {
            LogOutScreen(navController = navController)
        }
    }
}
