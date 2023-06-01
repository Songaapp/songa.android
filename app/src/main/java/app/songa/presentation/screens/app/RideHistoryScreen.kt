package app.songa.presentation.screens.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.presentation.components.ibmplexsanshebrew
import app.songa.presentation.theme.GreenPrimary

@Composable
fun RideHistoryScreen(navController: NavController, alfa: Float = 0.5f) {
    var notificaions by remember {
        mutableStateOf(true)
    }
    var appnotificaions by remember {
        mutableStateOf(true)
    }
    var emailnotificaions by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ridehistory),
                contentDescription = "Ride History",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(305.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Ride History",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "A Songa receipt for all trips made for the past 60 days",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.End,
        )
        Text(
            "Earn 5 Songa points for every invite you send.",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    color = GreenPrimary,
                    shape = RoundedCornerShape(
                        30.dp,
                        30.dp,
                        0.dp,
                        0.dp,
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp),
            ) {
                Column(Modifier
                    .verticalScroll(rememberScrollState())){
                    Row() {
                        Column() {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "Star Icon",
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Column() {
                            Text(
                                "Thika",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                "Thika Road",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                "Mount Kenya University",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Text(
                                    "Arrive time: 08:32 Am",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End,
                                )
                                Text(
                                    "Trip cost:900 Points",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End,
                                    color = Color(0xFF05FF7B)
                                )
                            }
                            Divider(
                                thickness = 1.dp,
                                color = Color.White,
                            )

                        }
                    }
                    Row() {
                        Column() {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "Star Icon",
                                tint = Color(0xFFF7E017)
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Column() {
                            Text(
                                "Thika",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                "Thika Road",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                "Mount Kenya University",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Text(
                                    "Arrive time: 08:32 Am",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End,
                                )
                                Text(
                                    "Trip cost:900 Points",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End,
                                    color = Color(0xFF05FF7B)
                                )
                            }
                            Divider(
                                thickness = 1.dp,
                                color = Color.White,
                            )

                        }
                    }
                    Row() {
                        Column() {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "Star Icon",
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Column() {
                            Text(
                                "Thika",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                "Thika Road",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                            )
                            Text(
                                "Mount Kenya University",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Text(
                                    "Arrive time: 08:32 Am",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End,
                                )
                                Text(
                                    "Trip cost:900 Points",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End,
                                    color = Color(0xFF05FF7B)
                                )
                            }
                            Divider(
                                thickness = 1.dp,
                                color = Color.White,
                            )

                        }
                    }
                }

            }
        }
    }
}