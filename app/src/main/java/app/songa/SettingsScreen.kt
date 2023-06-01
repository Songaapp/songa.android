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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.ui.theme.GreenPrimary

@Composable
fun SettingsScreen(navController: NavController, alfa: Float = 0.5f) {
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
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Settings",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(305.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Settings",
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
                    Row() {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .clip(shape = CircleShape)
                                .background(Color.White, shape = CircleShape)
                                .border(
                                    BorderStroke(
                                        1.dp,
                                        SolidColor(
                                            Color(0xFFD9D9D9),
                                        )
                                    ),
                                    shape = CircleShape
                                ),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.usergreen),
                                contentDescription = "User Placeholder",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "Account",
                            fontFamily = ibmplexsanshebrew,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            textAlign = TextAlign.End,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(
                        thickness = 1.dp,
                        color = Color.White,
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .clickable { }
                    ){
                        Text(
                            "Edit Profile",
                            fontFamily = ibmplexsanshebrew,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            color = Color(0xFFFEFEFE),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                    }
                    Divider(
                        thickness = 1.dp,
                        color = Color.White,
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .clickable { }
                    ){
                        Text(
                            "Change Password",
                            fontFamily = ibmplexsanshebrew,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            color = Color(0xFFFEFEFE),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
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
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification Icon",
                            tint = Color(0xFF070707)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "Notifications",
                            fontFamily = ibmplexsanshebrew,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            color = Color(0xFF070707),
                        )
                    }

                    Spacer(modifier = Modifier.height(1.dp))
                    Column( Modifier
                        .verticalScroll(rememberScrollState())) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                        ){
                            Text(
                                "Notification",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Switch(
                                modifier = Modifier.scale(scale = 0.75f),
                                checked = notificaions,
                                onCheckedChange = { switchOn_ ->
                                    notificaions = switchOn_
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = GreenPrimary,
                                    uncheckedThumbColor = GreenPrimary,
                                    uncheckedTrackColor = Color.Unspecified,
                                )

                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                        ){
                            Text(
                                "App Notification",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Switch(
                                modifier = Modifier.scale(scale = 0.75f),
                                checked = appnotificaions,
                                onCheckedChange = { switchOn_ ->
                                    appnotificaions = switchOn_
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = GreenPrimary,
                                    uncheckedThumbColor = GreenPrimary,
                                    uncheckedTrackColor = Color.Unspecified,
                                )

                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                        ){
                            Text(
                                "Email Notification",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                            Switch(
                                modifier = Modifier.scale(scale = 0.75f),
                                checked = emailnotificaions,
                                onCheckedChange = { switchOn_ ->
                                    emailnotificaions = switchOn_
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = GreenPrimary,
                                    uncheckedThumbColor = GreenPrimary,
                                    uncheckedTrackColor = Color.Unspecified,
                                )

                            )
                        }
                    }
                }
            }
        }
    }
}