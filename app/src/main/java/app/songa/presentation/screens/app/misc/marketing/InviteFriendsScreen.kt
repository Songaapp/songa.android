package app.songa.presentation.screens.app.misc.marketing

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.presentation.theme.ibmplexsanshebrew
import app.songa.presentation.theme.GreenPrimary

@Composable
fun InvitedFriendsScreen(navController: NavController, alfa: Float = 0.5f) {
    var search by remember { mutableStateOf(TextFieldValue("")) }
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
                painter = painterResource(id = R.drawable.friends),
                contentDescription = "Friends",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(305.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Friends",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "Invite friends to Earn Songa Points",
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
                    .padding(horizontal = 70.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(72.dp)
                        .height(72.dp)
                        .clickable {  }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.instagramiconwhite),
                        contentDescription = "Instagram",
                        modifier = Modifier
                            .width(54.dp)
                            .height(48.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Connect",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(72.dp)
                        .height(72.dp)
                        .clickable {  }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebookiconwhite),
                        contentDescription = "Facebook",
                        modifier = Modifier
                            .width(54.dp)
                            .height(48.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Connect",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(72.dp)
                        .height(72.dp)
                        .clickable {  }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twittericonwhite),
                        contentDescription = "Twitter",
                        modifier = Modifier
                            .width(54.dp)
                            .height(48.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Connect",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(horizontal = 70.dp, vertical = 30.dp),
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
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = search,
                        trailingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                                      },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        onValueChange = {
                            search = it
                        },
                        placeholder = { Text("Invite friend", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color(0xFF05FF7B),
                            unfocusedIndicatorColor = GreenPrimary,
                            cursorColor = GreenPrimary,
                            placeholderColor = Color(0xFF4D4D4D),
                            trailingIconColor = GreenPrimary
                        ),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            fontSize = 14.sp,
                            fontFamily = ibmplexsanshebrew
                        ),
                        modifier = Modifier
                            .height(48.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Column( Modifier
                        .verticalScroll(rememberScrollState())) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 40.dp)


                        ){
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(35.dp)
                                    .height(40.dp)
                                    .clip(shape = CircleShape)
                                    .background(Color(0xFF7DCEA0), shape = CircleShape)
                            ){
                                Image(painter = painterResource(id = R.drawable.usersample), contentDescription = "Profile Picture",
                                    contentScale = ContentScale.Crop,
                                )
                            }
                            Text(
                                "Albert Mwangi",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                                color = Color.Black,
                            )
                            Button(
                                onClick = {
                                    navController.navigate("home_page_screen")
                                },
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color(0xFFFF0000)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.width(66.dp).height(28.dp)
                            ) {
                                Text(
                                    "Invite",
                                    fontFamily = ibmplexsanshebrew,
//                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 40.dp)


                        ){
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(35.dp)
                                    .height(40.dp)
                                    .clip(shape = CircleShape)
                                    .background(Color(0xFF7DCEA0), shape = CircleShape)
                            ){
                                Image(painter = painterResource(id = R.drawable.usersample), contentDescription = "Profile Picture",
                                    contentScale = ContentScale.Crop,
                                )
                            }
                            Text(
                                "Albert Mwangi",
                                fontFamily = ibmplexsanshebrew,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                textAlign = TextAlign.End,
                                color = Color.Black,
                            )
                            Button(
                                onClick = {
                                    navController.navigate("home_page_screen")
                                },
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color(0xFFFF0000)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.width(66.dp).height(28.dp)
                            ) {
                                Text(
                                    "Invite",
                                    fontFamily = ibmplexsanshebrew,
//                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}