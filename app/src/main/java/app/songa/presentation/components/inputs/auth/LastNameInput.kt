package app.songa.presentation.components.inputs.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun LastNameInput(
    modifier: Modifier = Modifier,
    lastname: String?,
    onLastNameChanged:(firstname: String) -> Unit,
    onNextClicked: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 3.dp)
    ) {
        Text(
            stringResource(
                id = R.string.label_lastname),
            fontFamily = ibmplexsanshebrew,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.width(20.dp))
        OutlinedTextField(
            value = lastname ?: "",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onNextClicked()
                }
            ),
            onValueChange = {lastname ->
                onLastNameChanged(lastname)
            },
            placeholder = { Text(stringResource(
                id = R.string.label_lastname), fontSize = 14.sp, fontFamily = ibmplexsanshebrew
            ) },
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
}