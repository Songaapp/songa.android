package app.songa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.inter
import app.songa.ui.theme.GreenPrimary

@Composable
fun Faqs(navController: NavController, alpha: Float = 0.5f) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        drawerContent = {},
        drawerGesturesEnabled = true,
        content = {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Black, GreenPrimary)
                        )
                    )
            ) {}
            Surface(
                color = Color.Black, modifier = Modifier
                    .fillMaxSize()
                    .alpha(alpha)
            ) {
            }
            TopAppBar(
                title = {},
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    })
                {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                    }
                },
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                actions = {
                    Image(painter = painterResource(id = R.drawable.songawhite),
                        contentDescription = "Songa White Logo",
                        modifier = Modifier.size(
                            width = 140.dp,
                            height = 40.dp,
                        )
                            .padding(top= 10.dp)
                    )
                },
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "F.A.Qs",
                            fontFamily = inter,
                            fontWeight = FontWeight.Thin,
                            modifier = Modifier.padding(bottom = 30.dp),
                            fontSize = 40.sp,
                        )

                        Image(
                            painter = painterResource(id = R.drawable.linewhite),
                            contentDescription = "F.A.Qs Divider",
                            modifier = Modifier.size(
                                width = 142.dp,
                                height = 1.dp
                            )
                        )

                        Column(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth(0.9f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Q. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                "A. Conviniency at best with the best BodaBoda services. Introducing digital BodaBada.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                "Q. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(top = 15.dp)
                            )
                            Text(
                                "A. Quisque ullamcorper leo eget ipsum consectetur bibendum. Nunc porttitor blandit vulputate. Duis eleifend vehicula sem, non varius urna tincidunt non. Mauris tristique",
                                fontFamily = inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                "Q. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                "A. Conviniency at best with the best BodaBoda services. Introducing digital BodaBada.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                "Q. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(top = 15.dp)
                            )
                            Text(
                                "A. Quisque ullamcorper leo eget ipsum consectetur bibendum. Nunc porttitor blandit vulputate. Duis eleifend vehicula sem, non varius urna tincidunt non. Mauris tristique",
                                fontFamily = inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                "Q. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                            )
                            Text(
                                "A. Conviniency at best with the best BodaBoda services. Introducing digital BodaBada.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                "Q. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                                fontFamily = inter,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(top = 15.dp)
                            )
                            Text(
                                "A. Quisque ullamcorper leo eget ipsum consectetur bibendum. Nunc porttitor blandit vulputate. Duis eleifend vehicula sem, non varius urna tincidunt non. Mauris tristique",
                                fontFamily = inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }

            }
        }
    )
}