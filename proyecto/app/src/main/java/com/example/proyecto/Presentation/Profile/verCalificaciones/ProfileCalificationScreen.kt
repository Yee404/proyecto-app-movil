package com.example.proyecto.Presentation.Profile.verCalificaciones

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import com.example.proyecto.Data.Source.CatedraticosDb
import com.example.proyecto.Presentation.Profile.ProfileScreen
import com.example.proyecto.R



@Composable
fun ProfileCalificationRoute(
    profeId: Int
) {

    ProfileCalificationScreen(
        profeId = profeId,
    )
}


@Composable
private fun ProfileCalificationScreen(
    profeId: Int,

) {
    val catedraticosDb = CatedraticosDb()
    val catedratico = catedraticosDb.obtenerCatedraticoPorId(profeId)

    // Verifica si el catedrático existe
    if (catedratico != null) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            item {


                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Foto de perfil del catedrático",
                    modifier = Modifier
                        .size(120.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = catedratico.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Cursos que imparte: ${catedratico.curses}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Biografía",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    text = catedratico.biographic,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Sección de calificaciones
            val ratings = mapOf(
                "Claridad en la Enseñanza" to catedratico.qualification1.toInt(),
                "Dominio del Tema" to catedratico.qualification2.toInt(),
                "Accesibilidad y Disponibilidad" to catedratico.qualification3.toInt(),
                "Uso de Recursos y Tecnología" to catedratico.qualification4.toInt()
            )

            ratings.forEach { (category, score) ->
                item {
                    RatingRow(category = category, score = score)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    } else {
        // Mensaje si el catedrático no existe
        Text(
            text = "Catedrático no encontrado",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
fun RatingRow(category: String, score: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = category,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 1..5) {
                Icon(
                    imageVector = if (i <= score) Icons.Filled.Star else Icons.Filled.StarBorder,
                    contentDescription = null,
                    tint = if (i <= score) Color(0xFF4CAF50) else Color.Gray,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCalificationScreenPreview() {
    ProfileCalificationScreen(
        profeId = 1
    )
}
