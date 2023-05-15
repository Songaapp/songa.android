package app.songa

import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.annotation.ColorRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.DrawerValue
import androidx.compose.material.DropdownMenu
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.songa.ui.theme.GreenPrimary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController, alpha: Float = 0.5f) {
    var topMenuVisible = true
    val scale = remember{
        Animatable(initialValue = 0f)
    }
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.8f, animationSpec = tween(durationMillis = 700,
            easing = { OvershootInterpolator(2f).getInterpolation(it)})
        )
    } )

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
//        scaffoldState = scaffoldState,
//        drawerContent = {
//            Drawer(scope = coroutineScope, scaffoldState = scaffoldState, navController = navController)
//        },
//        drawerGesturesEnabled = true,
        content = {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.safeboda), contentDescription = "Safe Boda", contentScale = ContentScale.Crop, modifier = Modifier
                        .fillMaxSize()
                    )
                }
                Surface(
                    color = Color.Black, modifier = Modifier
                        .fillMaxSize()
                        .alpha(alpha)
                ) {
                }
                TopBar(scope = coroutineScope, scaffoldState = scaffoldState, navController= navController)

            Column(
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Welcome to SONGA family!",
                            fontFamily = inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.songawhite),
                            contentDescription = "Safe Boda",
                            modifier = Modifier.scale(scale.value)
                        )
                        Text(
                            "Conviniency at best with the best BodaBoda services.\n"+"Introducing digital BodaBoda.",
                            fontFamily = inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                        )
                        Button(onClick = {
//                            navController.navigate("")
                        },
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White, backgroundColor = GreenPrimary),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.width(170.dp)
                        ) {
                            Text(
                                "GET STARTED",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                            )
                        }
                    }
                }

            }
        }
    )
}