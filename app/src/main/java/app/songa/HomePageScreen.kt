package app.songa

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController

@Composable
fun HomePageScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer(scope = coroutineScope, scaffoldState = scaffoldState, navController = navController)
        },
        drawerGesturesEnabled = true,
        content = {
            TopBarMenu(scope = coroutineScope, scaffoldState = scaffoldState, navController= navController)
        }
    )
}