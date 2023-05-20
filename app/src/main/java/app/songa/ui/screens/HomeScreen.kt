package app.songa.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DrawerValue
import androidx.compose.material.DropdownMenu
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.ibmplexsanshebrew
import app.songa.inter
import app.songa.ui.theme.GreenPrimary
import kotlinx.coroutines.CoroutineScope


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
                            navController.navigate("home_page_screen")
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

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {},
        elevation = 0.dp,
//        navigationIcon = {
//            IconButton(onClick = {
//                scope.launch { scaffoldState.drawerState.open() }
//            }) {
//                Image(
//                    painter = painterResource(id = R.drawable.menuiconwhite),
//                    contentDescription = "Green Logo",
//                    modifier = Modifier.size(
//                        width = 35.dp, height = 24.dp,
//                    )
//                )
//            }
//        },
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        actions = {
            IconButton(onClick = {
                expanded = true
            }) {
                Image(
                    painter = painterResource(id = R.drawable.greenlogo),
                    contentDescription = "Green Logo",
                    modifier = Modifier.size(width = 57.dp, height = 61.dp)
                )
            }
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }, modifier = Modifier
                .background(Color.Transparent)
                .width(190.dp)
                .padding(horizontal = 10.dp)
            ) {
                Button(onClick = {
                    navController.navigate("website_screen")
                },
                    border = BorderStroke(2.dp, GreenPrimary),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 20.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 20.dp
                    ),
                    modifier = Modifier.width(170.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.worldicongreen),
                        contentDescription ="Visit website button icon",
                        modifier = Modifier.size(20.dp))

                    Text(
                        "Visit Website",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.dp,),
                        fontSize = 15.sp,
                    )
                }
                Spacer(modifier = Modifier
                    .height(8.dp)
                )
                Button(onClick = {
                    navController.navigate("faqs_screen")
                },
                    border = BorderStroke(2.dp, GreenPrimary),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 20.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 20.dp
                    ),
                    modifier = Modifier
                        .width(170.dp)
                        .padding(end = 50.dp),
                ) {
                    Image(
                        painterResource(id = R.drawable.bookicongreen),
                        contentDescription = "F.A.Qs button icon",
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        "F.A.Qs",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 15.sp,
                    )
                }

            }
        },
    )
}