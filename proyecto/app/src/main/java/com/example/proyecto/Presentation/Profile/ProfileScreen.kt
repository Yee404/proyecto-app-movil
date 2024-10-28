package com.example.proyecto.Presentation.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.proyecto.R

@Composable
fun ProfileScreen(
    teacherName: String = "Nombre del catedrático",
    profileImageUrl: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            model = profileImageUrl,
            contentDescription = "Foto de perfil del catedrático",
            modifier = Modifier
                .size(120.dp)
                .background(Color.Gray, shape = CircleShape),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.default_profile) // Imagen de respaldo en caso de error
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre del catedrático
        Text(
            text = teacherName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botones
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /* Acción para calificar catedrático */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text(text = "Calificar catedrático")
            }

            Button(
                onClick = { /* Acción para ver calificaciones */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text(text = "Ver Calificaciones")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        teacherName = "Nombre del catedrático",
        profileImageUrl = "" // URL de ejemplo para la imagen de perfil
    )
}


