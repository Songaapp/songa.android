package app.songa.presentation.screens.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.presentation.components.ibmplexsanshebrew
import app.songa.presentation.components.inter
import app.songa.presentation.screens.auth.AuthenticationEvent
import app.songa.presentation.screens.auth.AuthenticationMode
import app.songa.presentation.screens.auth.AuthenticationState
import app.songa.presentation.screens.auth.PasswordRequirement
import app.songa.presentation.theme.GreenPrimary

@Composable
fun ChangePasswordScreen(
    navController: NavController,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,
) {
    var oldpassword by remember { mutableStateOf(TextFieldValue("")) }
    var newpassword by remember { mutableStateOf(TextFieldValue("")) }

    var isPasswordHidden by remember { mutableStateOf(false) }
    var isConfirmPasswordHidden by remember { mutableStateOf(false) }

    val confirmPasswordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current

    val authenticationState = AuthenticationState()
    val completedPasswordRequirements = authenticationState.passwordRequirements

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .verticalScroll(rememberScrollState()),
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
                painter = painterResource(id = R.drawable.usersample),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "ACCOUNT",
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            "Change Password",
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.End)
        )
        Row(){
            Column(
                modifier = Modifier
                    .width(115.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    "Old Password: ",
                    fontFamily = ibmplexsanshebrew,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Column() {
                Divider(
                    thickness = 1.dp,
                    color = Color.White,
                )
                TextField(
                    value = oldpassword,
                    visualTransformation = if (isPasswordHidden) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Password,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            confirmPasswordFocusRequester.requestFocus()
                        }
                    ),
                    onValueChange = {
                        oldpassword = it
                    },
                    placeholder = { Text("Enter Old Password", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = GreenPrimary,
                        cursorColor = GreenPrimary,
                        placeholderColor = Color(0xFF4D4D4D),
                    ),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontFamily = ibmplexsanshebrew
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(0.dp),
                    singleLine = true,
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable(
                                onClickLabel = if (isPasswordHidden) {
                                    stringResource(id =
                                    R.string.cd_show_password)
                                } else stringResource(id =
                                R.string.cd_hide_password)
                            ) {
                                isPasswordHidden = !isPasswordHidden
                            },
                            imageVector = if (!isPasswordHidden) {
                                Icons.Default.Visibility
                            } else Icons.Default.VisibilityOff,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    },
                )
            }
        }
        Row(){
            Column(
                modifier = Modifier
                    .width(115.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    "New Password: ",
                    fontFamily = ibmplexsanshebrew,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Column() {
                Divider(
                    thickness = 1.dp,
                    color = Color.White,
                )
                TextField(
                    value = newpassword,
                    visualTransformation = if (isConfirmPasswordHidden) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }
                    ),
                    onValueChange = {
                        newpassword = it
                    },
                    placeholder = { Text("Enter New Password", fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = GreenPrimary,
                        cursorColor = GreenPrimary,
                        placeholderColor = Color(0xFF4D4D4D),
                    ),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontFamily = ibmplexsanshebrew
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(0.dp)
                        .focusRequester(confirmPasswordFocusRequester),
                    singleLine = true,
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable(
                                onClickLabel = if (isConfirmPasswordHidden) {
                                    stringResource(id =
                                    R.string.cd_show_password)
                                } else stringResource(id =
                                R.string.cd_hide_password)
                            ) {
                                isConfirmPasswordHidden = !isConfirmPasswordHidden
                            },
                            imageVector = if (!isConfirmPasswordHidden) {
                                Icons.Default.Visibility
                            } else Icons.Default.VisibilityOff,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    },
                )
                Divider(
                    thickness = 1.dp,
                    color = Color.White,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        PasswordRequirement(satisfiedRequirements = completedPasswordRequirements)

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                // SAVE DATA
            },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
                backgroundColor = Color(0xFFF3EFEF)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                "SUBMIT",
                fontFamily = ibmplexsanshebrew,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }
}