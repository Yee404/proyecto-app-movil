package com.example.proyecto.Presentation.Navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.navigation.navigation
import com.example.proyecto.Presentation.Login.LoginScreenDestination
import com.example.proyecto.Presentation.Login.loginScreen
import com.example.proyecto.Presentation.Menu.CatedraticoScreenDestination
import com.example.proyecto.Presentation.Menu.catedraticoScreen
import com.example.proyecto.Presentation.Menu.navigateToCatedraticoScreen
import com.example.proyecto.Presentation.Profile.ProfileScreenDestination
import com.example.proyecto.Presentation.Profile.calificar.calificationScreen
import com.example.proyecto.Presentation.Profile.calificar.navigateToCalificationMandarScreen
import com.example.proyecto.Presentation.Profile.navigateToProfileScreen
import com.example.proyecto.Presentation.Profile.profileScreen
import com.example.proyecto.Presentation.Profile.verCalificaciones.navigateToCalificationScreen
import com.example.proyecto.Presentation.Profile.verCalificaciones.profileVerCalificationScreen
import com.example.proyecto.Presentation.Registrer.RegistrerScreenDestination
import com.example.proyecto.Presentation.Registrer.registrerScreen
import kotlinx.serialization.Serializable

@Serializable
data object LogRegNavGraph

fun NavController.navigateToLogRegGraph(navOptions: NavOptions? = null) {
    this.navigate(LogRegNavGraph, navOptions)
}

fun NavGraphBuilder.logRegGraph(
    navController: NavController
) {
    navigation<LogRegNavGraph>(
        startDestination = LoginScreenDestination
    ) {
        loginScreen(
            onLoginClick = { carnet ->
                navController.navigateToCatedraticoScreen(
                    estudianteId = carnet,
                    navOptions = navOptions {
                        popUpTo(LoginScreenDestination) { inclusive = true }
                    }
                )
            },
            oRegistrer =  {
                navController.navigate(RegistrerScreenDestination)
            }
        )

        registrerScreen(
            onRegistrerClick = {
                navController.navigate(LoginScreenDestination) {
                    popUpTo(0)
                }
            }
        )

        catedraticoScreen(
            onCharClick = { id ->
                navController.navigateToProfileScreen(
                    estudiantId = id
                )
            }
        )

        profileScreen(
            verCal = { profeId ->
                navController.navigateToCalificationScreen(profeId)
            },
            Cal = { profeId ->
                navController.navigateToCalificationMandarScreen(profeId)
            }
        )

        profileVerCalificationScreen()

        calificationScreen()
    }
}