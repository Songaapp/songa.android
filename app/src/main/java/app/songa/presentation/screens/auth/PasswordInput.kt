package app.songa.presentation.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.songa.R
import app.songa.presentation.components.ibmplexsanshebrew
import app.songa.presentation.theme.GreenPrimary

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChanged: (phone: String) -> Unit,
    onDoneClicked: () -> Unit,
//    hanleEvent: (AuthenticationEvent) -> Unit
) {
    var isPasswordHidden by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current


    Text(
        text = stringResource(
            id = R.string.label_password),
        fontFamily = ibmplexsanshebrew,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        textAlign = TextAlign.End,
    )
    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = password ?:"",
        visualTransformation = if (isPasswordHidden) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneClicked()
                focusManager.clearFocus()
//                hanleEvent(AuthenticationEvent.Authenticate)
            }
        ),
//        onValueChange = {password ->
//            onPasswordChanged(password)
//        },
        onValueChange = {
            onPasswordChanged(it)
        },
        placeholder = { Text(stringResource(
            id = R.string.label_password), fontSize = 14.sp, fontFamily = ibmplexsanshebrew) },
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Unspecified,
            cursorColor = GreenPrimary,
            placeholderColor = Color(0xFF4D4D4D),
        ),
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontFamily = ibmplexsanshebrew
        ),
        modifier = modifier,
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