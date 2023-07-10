package app.songa.presentation.screens.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Authentication(navController: NavController, viewModel: AuthenticationViewModel){
    MaterialTheme {
        AuthenticationContent(
            modifier = Modifier
                .fillMaxWidth()
            ,
            authenticationState =
            viewModel.uiState.collectAsState().value,
            navController = navController,
            handleEvent = viewModel::handleEvent,
        )
    }
}