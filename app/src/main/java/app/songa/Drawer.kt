package app.songa

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import app.songa.ui.theme.GreenPrimary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.History,
        NavigationItems.Support,
        NavigationItems.Settings,
        NavigationItems.Wallet,
        NavigationItems.Logout,
    )

    Column(
        modifier = Modifier
            .background(color = Color.Black)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.Start,
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
//                    .background(color = Color.Red)
                    .padding(start = 30.dp,),
                ){

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(shape = CircleShape)
//                        .padding(top=.dp)
//                        .clip(RoundedCornerShape(50.dp))
                        .background(Color(0xFF7DCEA0), shape = CircleShape)
                        .border(
                            BorderStroke(
                                0.dp,
                                SolidColor(Color.Black,)
                            ),
                            shape = CircleShape
                        ),
                ){
//                    Spacer(modifier = Modifier.height(60.dp))
                    Image(painter = painterResource(id = R.drawable.usersample), contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                    )
                    Text("Boda Waweru",
                        fontSize = 24.sp,
                        fontFamily = inter,
                        color = Color.White,
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(color = Color.Blue)
                    ){
                        Text("Boda Waweru",
                            fontSize = 24.sp,
                            fontFamily = inter,
                            color = Color.White,
                        )
                    }

                }
            }
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item= items, selected = currentRoute == items.route, onItemClick = {
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
        Spacer(modifier = Modifier
            .weight(1f)
        )
    }
}

@Composable
fun DrawerItem(item: NavigationItems, selected: Boolean, onItemClick: (NavigationItems) -> Unit){
    val textcol = if(selected) GreenPrimary else R.color.white
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
                .size(width = 25.dp, height = 23.dp,)
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