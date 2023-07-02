@file:Suppress("NAME_SHADOWING")

package app.songa.presentation.components.inputs.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.songa.R
import app.songa.presentation.theme.ibmplexsanshebrew
import app.songa.presentation.theme.GreenPrimary

@Composable
fun PhoneInput(
    modifier: Modifier = Modifier,
    phone: String?,
    onPhoneChanged:(phone: String) -> Unit,
    onNextClicked: () -> Unit
) {
    Text(
        text = stringResource(
        id = R.string.label_phone),
        fontFamily = ibmplexsanshebrew,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        textAlign = TextAlign.End,
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = phone ?:"",
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNextClicked()
            }
        ),
        onValueChange = {phone ->
            onPhoneChanged(phone)
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
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontFamily = ibmplexsanshebrew
        ),
        modifier = modifier,
        singleLine = true,
    )

}