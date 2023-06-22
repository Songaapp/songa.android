package app.songa.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.songa.R
import app.songa.presentation.components.ibmplexsanshebrew

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    toggleAuthentication: () -> Unit
) {
        TextButton(
            onClick = {
                toggleAuthentication()
            },
        ) {
            Text(
                text = stringResource(
                    if (authenticationMode ==
                        AuthenticationMode.SIGN_IN) {
                        R.string.action_need_account
                    } else {
                        R.string.action_already_have_account
                    })+" ",
                fontSize = 13.sp,
                fontFamily = ibmplexsanshebrew,
                color = Color.White,
            )
            Text(
                text = stringResource(
                    if (authenticationMode ==
                        AuthenticationMode.SIGN_IN) {
                        R.string.action_need_account_more
                    } else {
                        R.string.action_already_have_account_more
                    })+" ",
                fontSize = 13.sp,
                fontFamily = ibmplexsanshebrew,
                color = Color(0xFF0AFF7E),
                textDecoration = TextDecoration.Underline,
            )
        }
}