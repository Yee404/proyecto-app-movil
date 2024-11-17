package com.example.proyecto.Presentation.Profile.calificar

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.proyecto.Presentation.Profile.verCalificaciones.ProfileCalificationRoute
import kotlinx.serialization.Serializable

@Serializable
data class CalificationScreenDestination(
    val profesId: Int
)

fun NavController.navigateToCalificationMandarScreen(
    profesId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = CalificationScreenDestination(profesId = profesId),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.calificationScreen() {
    composable<CalificationScreenDestination> { backStackEntry ->
        val destination: CalificationScreenDestination = backStackEntry.toRoute()
        CalificationRoute(
            profesId = destination.profesId,
        )
    }
}