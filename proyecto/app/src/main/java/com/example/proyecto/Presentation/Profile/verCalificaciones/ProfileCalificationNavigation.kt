package com.example.proyecto.Presentation.Profile.verCalificaciones

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.proyecto.Presentation.Profile.ProfileRoute
import com.example.proyecto.Presentation.Profile.ProfileScreenDestination
import kotlinx.serialization.Serializable


@Serializable
data class ProfileCalificationScreenDestination(
    val profeId: Int
)

fun NavController.navigateToCalificationScreen(
    profeId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = ProfileCalificationScreenDestination(profeId = profeId),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.profileVerCalificationScreen() {
    composable<ProfileCalificationScreenDestination> { backStackEntry ->
        val destination: ProfileCalificationScreenDestination = backStackEntry.toRoute()
        ProfileCalificationRoute(
            profeId = destination.profeId,
        )
    }
}