package com.example.proyecto.Presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
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
import coil3.compose.rememberAsyncImagePainter
import com.example.proyecto.R

@Composable
fun ProfileCalificationScreen(
    teacherName: String,
    courses: String,
    biography: String,
    profileImageUrl: String,
    ratings: Map<String, Int> // Calificación por cada categoría
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            // Imagen de perfil y detalles del catedrático
            val painter = rememberAsyncImagePainter(
                model = profileImageUrl,
                error = painterResource(R.drawable.default_profile) // Imagen de respaldo en caso de error
            )

            Image(
                painter = painter,
                contentDescription = "Foto de perfil del catedrático",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = teacherName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Cursos que imparte: $courses",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Biografía",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = biography,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Sección de calificaciones
        ratings.forEach { (category, score) ->
            item {
                RatingRow(category = category, score = score)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun RatingRow(category: String, score: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = category,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            for (i in 1..5) {
                Icon(
                    imageVector = if (i <= score) Icons.Filled.Star else Icons.Filled.StarBorder,
                    contentDescription = null,
                    tint = if (i <= score) Color(0xFF4CAF50) else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCalificationScreenPreview() {
    ProfileCalificationScreen(
        teacherName = "Nombre del catedrático",
        courses = "Calculo/Fisica/Pensamiento cuantitativo",
        biography = "En este párrafo se contará una pequeña Biografía del catedrático...",
        profileImageUrl = "https://www.example.com/profile.jpg", // URL de ejemplo
        ratings = mapOf(
            "Claridad en la Enseñanza" to 4,
            "Dominio del Tema" to 5,
            "Accesibilidad y Disponibilidad" to 3,
            "Uso de Recursos y Tecnología" to 4
        )
    )
}
