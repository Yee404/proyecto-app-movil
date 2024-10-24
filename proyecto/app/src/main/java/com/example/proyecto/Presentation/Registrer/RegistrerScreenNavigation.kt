package com.example.proyecto.Presentation.Registrer

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.proyecto.RegistrerScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data object RegistrerScreenDestination

fun NavGraphBuilder.registrerScreen(
    onRegistrerClick: () -> Unit
) {
    composable<RegistrerScreenDestination> {
        RegistrerScreenRoute(
            onRegistrerClick = onRegistrerClick,
        )
    }
}