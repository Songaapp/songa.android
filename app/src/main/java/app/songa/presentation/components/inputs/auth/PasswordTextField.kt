package app.songa.presentation.components.inputs.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.songa.presentation.theme.GreenPrimary
import app.songa.presentation.theme.ibmplexsanshebrew

@Composable
fun PasswordTextField(
    password: TextFieldValue,
    onPasswordChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.height(20.dp))
    Text(
        "Enter Password",
        fontFamily = ibmplexsanshebrew,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        textAlign = TextAlign.End,
    )
    Box(
        modifier = modifier
            .padding(horizontal = 32.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color.White)
    ) {
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Unspecified,
                cursorColor = GreenPrimary,
                placeholderColor = Color(0xFF4D4D4D)
            ),
            textStyle = TextStyle(fontSize = 14.sp, fontFamily = ibmplexsanshebrew),
            modifier = Modifier.fillMaxWidth(),
            label = { Text("") }
        )
        IconButton(
            onClick = { passwordVisible = !passwordVisible },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = if (passwordVisible) Icons.Default.Lock else Icons.Default.Lock,
                contentDescription = if (passwordVisible) "Hide Password" else "Show Password",
                tint = if (passwordVisible) Color.Red else Color.Gray
            )
        }
    }
}
