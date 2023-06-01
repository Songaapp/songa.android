package app.songa

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MenuPages(navController: NavController){
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
            Text("Test")
        }
    )
}