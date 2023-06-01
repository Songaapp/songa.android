package app.songa.presentation.screens.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
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
fun OnlineSupportScreen(navController: NavController, alfa: Float = 0.5f) {
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
                painter = painterResource(id = R.drawable.support),
                contentDescription = "Support",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(305.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Online Support",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "How can we help you?",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
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
                    .padding(start = 30.dp, bottom = 10.dp, top = 20.dp, end = 30.dp),
            ) {
                Column {
                    Row(
                        modifier = Modifier
                        .fillMaxWidth()
                            .clickable {  },
                        horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                        Column() {
                            Row() {
                                Image(
                                    painter = painterResource(id = R.drawable.messengericonwhite),
                                    contentDescription = "Messenger",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    "Inbox",
                                    fontFamily = ibmplexsanshebrew,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.End,
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                "View chats with Songa",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                            )
                        }
                        Column() {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Right Arrow",
                            )

                        }
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(
                                30.dp,
                                30.dp,
                                0.dp,
                                0.dp,
                            )
                        )
                        .padding(horizontal = 30.dp, vertical = 20.dp),
                ) {
                    Row {
                        Text(
                            "Get help with something else",
                            fontFamily = ibmplexsanshebrew,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            color = GreenPrimary,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column( Modifier
                        .verticalScroll(rememberScrollState())) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .clickable {  }
                        ){
                            Text(
                                "Payments and Pricing",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Right Arrow",
                                tint = Color.Black,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .clickable {  }
                        ){
                            Text(
                                "About Songa",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Right Arrow",
                                tint = Color.Black,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .clickable {  }
                        ){
                            Text(
                                "App and Features",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Right Arrow",
                                tint = Color.Black,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .clickable {  }
                        ){
                            Text(
                                "Account and Data",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Right Arrow",
                                tint = Color.Black,
                            )
                        }
                    }
                }
            }
        }
    }
}