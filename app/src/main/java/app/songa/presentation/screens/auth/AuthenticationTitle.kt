package app.songa.presentation.screens.auth

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.songa.R
import app.songa.presentation.components.inter

@Composable
fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode
){
    Text(
        text = stringResource(
            if (authenticationMode == AuthenticationMode.SIGN_IN) {
                R.string.label_sign_in_to_account
            }
            else if(authenticationMode == AuthenticationMode.CHANGE_PASSWORD || authenticationMode == AuthenticationMode.ACCOUNT_SETTINGS) {
                R.string.label_edit_account
            }
            else {
                R.string.label_sign_up_for_account
            }
        ),
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    )
}