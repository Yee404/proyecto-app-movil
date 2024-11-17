package com.example.proyecto.Presentation.Profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.proyecto.Presentation.Menu.CatedraticoRoute
import com.example.proyecto.Presentation.Profile.verCalificaciones.ProfileCalificationRoute
import com.example.proyecto.Presentation.Profile.verCalificaciones.ProfileCalificationScreenDestination
import kotlinx.serialization.Serializable

@Serializable
data class ProfileScreenDestination(
    val estudiantId: Int
)

fun NavController.navigateToProfileScreen(
    estudiantId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = ProfileScreenDestination(estudiantId = estudiantId),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.profileScreen(
    verCal: (Int) -> Unit,
    Cal: (Int) -> Unit,
) {
    composable<ProfileScreenDestination> { backStackEntry ->
        val destination: ProfileScreenDestination = backStackEntry.toRoute()
        ProfileRoute(
            estudiantId = destination.estudiantId,
            verCal = { verCal(destination.estudiantId) },
            Cal = { Cal(destination.estudiantId) },
        )
    }
}

