package app.songa.presentation.screens.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.presentation.components.ibmplexsanshebrew
import app.songa.presentation.components.inter
import app.songa.presentation.theme.GreenPrimary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavController, alpha: Float = 0.5f) {
    var firstname by remember { mutableStateOf(TextFieldValue("")) }
    var lastname by remember { mutableStateOf(TextFieldValue("")) }
    var mobile by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        drawerGesturesEnabled = false
    ) {
        Box(
            contentAlignment = Alignment.Center,
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
        ) {}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFFD9D9D9), shape = CircleShape)
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
                        .width(72.75.dp)
                        .height(67.5.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "SIGN UP",
                fontFamily = inter,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Text(
                    "First Name",
                    fontFamily = ibmplexsanshebrew,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                )
                Spacer(modifier = Modifier.width(110.dp))
                Text(
                    "Last Name",
                    fontFamily = ibmplexsanshebrew,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                OutlinedTextField(
                    value = firstname,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = {
                        mobile = it
                    },
                    placeholder = { Text("First Name", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Unspecified,
                        cursorColor = GreenPrimary,
                        placeholderColor = Color(0xFF4D4D4D),
                    ),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontFamily = ibmplexsanshebrew
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .width(170.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                OutlinedTextField(
                    value = lastname,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = {
                        lastname = it
                    },
                    placeholder = { Text("Last Name", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Unspecified,
                        cursorColor = GreenPrimary,
                        placeholderColor = Color(0xFF4D4D4D),
                    ),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontFamily = ibmplexsanshebrew
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .width(170.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Enter Mobile Number",
                fontFamily = ibmplexsanshebrew,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = mobile,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onValueChange = {
                    mobile = it
                },
                placeholder = { Text("+254 XX XXX XXX", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Unspecified,
                    cursorColor = GreenPrimary,
                    placeholderColor = Color(0xFF4D4D4D),
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontFamily = ibmplexsanshebrew
                ),
                modifier = Modifier
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Enter Password",
                fontFamily = ibmplexsanshebrew,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {
                    password = it
                },
                placeholder = { Text("Enter Password", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Unspecified,
                    cursorColor = GreenPrimary,
                    placeholderColor = Color(0xFF4D4D4D),
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontFamily = ibmplexsanshebrew
                ),
                modifier = Modifier
                    .height(50.dp)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            Button(
                onClick = {
                    navController.navigate("home_page_screen")
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    backgroundColor = GreenPrimary
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(190.dp)
            ) {
                Text(
                    "CREATE ACCOUNT",
                    fontFamily = ibmplexsanshebrew,
                    fontSize = 16.sp,
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
            Row() {
                Text(
                    "Already have an account? ",
                    fontSize = 13.sp,
                    fontFamily = ibmplexsanshebrew
                )
                ClickableText(
                    text = AnnotatedString(
                        "Log In.",
                        spanStyles = listOf(
                            AnnotatedString.Range(
                                SpanStyle(
                                    color = Color(0xFF0AFF7E),
                                    textDecoration = TextDecoration.Underline,
                                    fontSize = 13.sp,
                                    fontFamily = ibmplexsanshebrew,
                                ), 0, 7
                            )
                        ),

                        ),
                    onClick = {
                        navController.navigate("login_screen");
                    },
                )

            }
        }

    }

}