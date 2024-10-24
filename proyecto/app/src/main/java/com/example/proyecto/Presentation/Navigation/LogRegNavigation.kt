package com.example.proyecto.Presentation.Navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.example.proyecto.Presentation.Login.LoginScreenDestination
import com.example.proyecto.Presentation.Login.loginScreen
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
            onLoginClick = { /* Acción de prueba */ },
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
    }
}