package app.songa.presentation.screens.app.payments

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
import app.songa.R
import app.songa.presentation.theme.GreenPrimary
import app.songa.presentation.theme.ibmplexsanshebrew

@Composable
fun MyWalletScreen() {
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
                painter = painterResource(id = R.drawable.walletgreen),
                contentDescription = "Support",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(305.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "My Wallet",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "Manage your Songa Points",
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
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.balanceiconwhite),
                            contentDescription = "Current Balance Icon",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "Current Balance",
                            fontFamily = ibmplexsanshebrew,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.End,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "6,892 S.Points",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        fontSize = 30.sp,
                        textAlign = TextAlign.End,
                    )
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
                                .clickable { }
                        ){
                            Text(
                                "About Songa Points",
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
                                .clickable { }
                        ){
                            Text(
                                "Buy Songa Points",
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
                                .clickable { }
                        ){
                            Text(
                                "Transfer Songa Points",
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
                                .clickable { }
                        ){
                            Text(
                                "Earn Songa Points",
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