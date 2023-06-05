package app.songa.presentation.screens.auth.login

import app.songa.presentation.components.PasswordTextField
import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import app.songa.data.models.login.LoginRequest
import app.songa.data.models.login.UserRepositoryImpl
import app.songa.domain.LoginUseCase
import app.songa.domain.LoginUseCaseImpl
import app.songa.presentation.components.ibmplexsanshebrew
import app.songa.presentation.components.inter
import app.songa.presentation.theme.GreenPrimary
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.request.post
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LogInScreen(navController: NavController, alpha: Float = 0.5f){
    val coroutineScope = rememberCoroutineScope()
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

//    @Composable
//    fun showToast(message: Context, s: String) {
//        Toast.makeText(
//            context.applicationContext,
//            message,
//            Toast.LENGTH_LONG
//        ).show()
//    }

    val loginUser: () -> Unit = {
        coroutineScope.launch {
            try {
                val client = HttpClient {
                    install(Auth) {
                        basic {
                            username = phone.text
                            password = password
                        }
                    }
                }

                // Make a POST request to the login endpoint
//                val response = client.post<String> {
//                    url("https://songa-api.onrender.com/api/users/auth/login-user")
//                    contentType(ContentType.Application.Json)
//                    body = LoginRequest(phone.text, password.text)
//                }

                // On success navigate to homescreen
                navController.navigate("home_page_screen")
            } catch (e: Exception) {
                // Error message
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        loginUser.invoke()
    }

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
                    "LOG IN",
                    fontFamily = inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Enter Mobile Number",
                    fontFamily = ibmplexsanshebrew,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = phone,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        onValueChange = {
                            phone = it
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

                    PasswordTextField(
                        password = password,
                        onPasswordChange = { password = it },
                        modifier = Modifier.height(50.dp)
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )

                Button(
                    onClick = loginUser,
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        backgroundColor = GreenPrimary
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(170.dp)
                ) {
                    Text(
                        "LOG IN",
                        fontFamily = ibmplexsanshebrew,
//                    fontWeight = FontWeight.Bold,
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
                        "Do you have an account? ",
                        fontSize = 13.sp,
                        fontFamily = ibmplexsanshebrew
                    )
                    ClickableText(
                        text = AnnotatedString(
                            "Create Account.",
                            spanStyles = listOf(
                                AnnotatedString.Range(
                                    SpanStyle(
                                        color = Color(0xFF0AFF7E),
                                        textDecoration = TextDecoration.Underline,
                                        fontSize = 13.sp,
                                        fontFamily = ibmplexsanshebrew
                                    ), 0, 15
                                )
                            ),

                            ),
                        onClick = {
                            navController.navigate("sign_up_screen");
                        },
                    )

                }
            }
        }
    }
