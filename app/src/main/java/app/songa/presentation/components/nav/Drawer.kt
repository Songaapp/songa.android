package app.songa.presentation.components.nav

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import app.songa.R
import app.songa.data.users.StoreUserData
import app.songa.presentation.theme.ibmplexsanshebrew
import app.songa.presentation.theme.inter
import app.songa.presentation.navigation.NavigationItems
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.presentation.theme.GreenPrimary
import kotlinx.coroutines.launch


@Composable
fun Drawer(
    scaffoldState: ScaffoldState,
    navController: NavController,
    authenticationState: AuthenticationState,
    dataStore: StoreUserData
) {
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.History,
        NavigationItems.Invite,
        NavigationItems.Support,
        NavigationItems.Settings,
        NavigationItems.Wallet,
//        NavigationItems.Logout,
    )
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(color = Color.Black)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .padding(
                    top = 30.dp,
                    start = 20.dp
                )
            ,
            horizontalArrangement = Arrangement.Start,
        ){
            Column {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(shape = CircleShape)
                        .background(Color(0xFF7DCEA0), shape = CircleShape)
                        .border(
                            BorderStroke(
                                0.dp,
                                SolidColor(Color.Black)
                            ),
                            shape = CircleShape
                        ),
                ){
                    Image(painter = painterResource(id = R.drawable.usersample), contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                Text(authenticationState.first_name+" "+authenticationState.last_name,
                    fontSize = 24.sp,
                    fontFamily = inter,
                    color = Color.White,
                )
                authenticationState.address?.let {
                    Text(
                        it,
                        fontSize = 12.sp,
                        fontFamily = inter,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier
                    .height(10.dp)
                )
                ChangeButton(navController = navController)
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenPrimary)
                .height(110.dp)
                .padding(
                    top = 10.dp,
                    start = 20.dp
                )
        ) {
            Row {
                Icon(painter = painterResource(id = R.drawable.balanceiconwhite), contentDescription = "Current Balance Icon")
                Spacer(
                    modifier = Modifier.width(10.dp)
                )
                Text("Current Balance",
                    fontSize = 15.sp,
                    fontFamily = inter,
                    color = Color.White,
                )
            }
            Spacer(
                modifier = Modifier.width(15.dp)
            )
            Text("6,892 S.Points",
                fontSize = 30.sp,
                fontFamily = ibmplexsanshebrew,
                color = Color.White,
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text("Due 26th April 2023",
                fontSize = 15.sp,
                fontFamily = inter,
                color = Color.Black,
            )
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item= items, selected = currentRoute == items.route, onItemClick = {
//                navController.navigate(items.route) {
                navController.navigate(items.route) {
                    navController.graph.startDestinationRoute?.let {route ->
                        popUpTo(route){
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    //log user out
                    scope.launch {
                        dataStore.deleteAllPreferences()
                    }
                    navController.navigate("authentication")
                }
                .height(45.dp)
                .padding(start = 40.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.logouticonred),
                contentDescription = "Log Out",
                modifier = Modifier
                    .size(width = 25.dp, height = 23.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                "Log Out",
                fontSize = 15.sp,
                color = Color.White,
                fontFamily = inter,
                fontWeight = FontWeight.Bold

            )
        }
        Spacer(modifier = Modifier
            .weight(1f)
        )
    }
}

@Composable
fun DrawerItem(item: NavigationItems, selected: Boolean, onItemClick: (NavigationItems) -> Unit){
    if(selected) GreenPrimary else R.color.white
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .padding(start = 40.dp)
    ){
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            modifier = Modifier
                .size(width = 25.dp, height = 23.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            item.title,
            fontSize = 15.sp,
            color = if(selected) GreenPrimary else Color.White,
            fontFamily = inter,
            fontWeight = FontWeight.Bold

        )
    }
}

@Composable
fun ChangeButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("edit_profile_screen")
        },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            backgroundColor = Color.White,
        )
    ) {
        Text(
            text = "Change",
            fontSize = 14.sp,
            fontFamily = ibmplexsanshebrew,
        )
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.changeicongreen),
            contentDescription = "Change Icon",
            modifier = Modifier
                .size(20.dp)
        )
    }
}