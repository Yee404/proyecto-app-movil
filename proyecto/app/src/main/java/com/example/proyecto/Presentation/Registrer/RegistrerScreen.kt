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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*

@Composable
fun RegistrerScreenRoute(
    onRegistrerClick: () -> Unit,
) {
    RegisterScreen(
        onRegistrerClick = onRegistrerClick
    )
}

@Composable
private fun RegisterScreen(
    onRegistrerClick: () -> Unit,
) {
    var carnet by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Registrarse",
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


        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar contraseña") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "¿Por qué me tengo que registrar?",
            modifier = Modifier.clickable { showDialog = true },
            color = Color.Blue,
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = onRegistrerClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Registrarse", color = Color.White, fontSize = 16.sp)
        }
    }

    
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "¿Por qué me tengo que registrar?") },
            text = { Text("El registro es únicamente para llevar la contabilización de los votos de cada persona. Tus datos no se podrán ver al momento de realizar alguna calificación.") },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "Aceptar", color = Color.Blue)
                }
            }
        )
    }
}



//@Preview(showBackground = true)
//@Composable
//fun RegisterScreenPreview() {
//    RegisterScreen()
//}