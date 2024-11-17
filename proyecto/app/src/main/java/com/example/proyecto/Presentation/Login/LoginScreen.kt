package com.example.proyecto

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.Data.Source.EstudiantesDb

@Composable
fun LoginScreenRoute(
    onLoginClick: (Int) -> Unit,
    oRegistrer: () -> Unit
) {
    val estudiantesDb = EstudiantesDb()
    LoginScreen(
        onLoginClick = onLoginClick,
        oRegistrer = oRegistrer,
        estudiantesDb = estudiantesDb
    )
}

@Composable
private fun LoginScreen(
    onLoginClick: (Int) -> Unit,
    oRegistrer: () -> Unit,
    estudiantesDb: EstudiantesDb
) {
    var carnet by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var error by remember { mutableStateOf(false) } // Estado para manejar el error

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Iniciar Sesión",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = carnet,
            onValueChange = { carnet = it },
            label = { Text("No. Carnet") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Mostrar mensaje de error si existe
        if (error) {
            Text(
                text = "Error: Usuario y/o contraseña incorrectos.",
                color = Color.Red,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Text(
            text = "¿Eres nuevo? Regístrate aquí!",
            modifier = Modifier.clickable { oRegistrer() },
            color = Color.Blue,
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val carnetInt = carnet.text.trim().toIntOrNull()
                val passwordInput = password.text.trim()

                if (carnetInt != null) {
                    val estudiante = estudiantesDb.obtenerListaEstudiantes()
                        .find { it.carnet == carnetInt && it.password == passwordInput }

                    if (estudiante != null) {
                        // Usuario y contraseña correctos
                        error = false
                        onLoginClick(carnetInt)
                    } else {
                        // Usuario o contraseña incorrectos
                        error = true
                    }
                } else {
                    // Usuario o contraseña incorrectos
                    error = true
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Iniciar sesión", color = Color.White, fontSize = 16.sp)
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val estudiantesDb = EstudiantesDb()

    LoginScreen(
        onLoginClick = { carnet ->
            println("Inicio de sesión exitoso con el carnet: $carnet")
        },
        oRegistrer = {
            println("Navegar a la pantalla de registro.")
        },
        estudiantesDb = estudiantesDb
    )
}
