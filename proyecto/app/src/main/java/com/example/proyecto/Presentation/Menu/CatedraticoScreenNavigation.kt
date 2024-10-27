package com.example.proyecto.Presentation.Menu

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class CatedraticoScreenDestination(
    val estudianteId: Int
)

fun NavController.navigateToCatedraticoScreen(
    estudianteId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = CatedraticoScreenDestination(estudianteId = estudianteId),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.catedraticoScreen() {
    composable<CatedraticoScreenDestination> { backStackEntry ->
        val destination: CatedraticoScreenDestination = backStackEntry.toRoute()
        CatedraticoRoute(
            estudianteId = destination.estudianteId
        )
    }
}