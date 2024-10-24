package com.example.proyecto.Presentation.Login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.proyecto.LoginScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data object LoginScreenDestination

fun NavGraphBuilder.loginScreen(
    onLoginClick: (Int) -> Unit,
    oRegistrer: () -> Unit
) {
    composable<LoginScreenDestination> {
        LoginScreenRoute(onLoginClick = onLoginClick, oRegistrer = oRegistrer)
    }
}
