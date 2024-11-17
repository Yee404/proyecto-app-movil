package com.example.proyecto.Presentation.Profile.calificar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.Data.Source.CatedraticosDb
import com.example.proyecto.R

@Composable
fun CalificationRoute(
    profesId: Int
) {

    CalificationScreen(
        catedraticoId = profesId
    )
}

@Composable
private fun CalificationScreen(
    catedraticoId: Int,
) {
    val catedraticosDb = CatedraticosDb()
    val catedratico = catedraticosDb.obtenerCatedraticoPorId(catedraticoId)


    if (catedratico != null) {
        var ratings by remember {
            mutableStateOf(
                mapOf(
                    "Claridad en la Enseñanza" to 0,
                    "Dominio del Tema" to 0,
                    "Accesibilidad y Disponibilidad" to 0,
                    "Uso de Recursos y Tecnología" to 0
                )
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp), // Aumenta el padding general
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre elementos
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

                // Nombre del catedrático
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

                Spacer(modifier = Modifier.height(12.dp))

                // Biografía
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
            ratings.forEach { (category, score) ->
                item {
                    InteractiveRatingRow(
                        category = category,
                        score = score,
                        onRatingChanged = { newScore ->
                            ratings = ratings.toMutableMap().apply { put(category, newScore) }
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            item {
                Button(
                    onClick = { /*onSubmit(ratings) */},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Text(text = "Enviar Calificación", fontSize = 18.sp, color = Color.White)
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
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun InteractiveRatingRow(
    category: String,
    score: Int,
    onRatingChanged: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Título de la categoría
        Text(
            text = category,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Estrellas de calificación interactivas
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (i in 1..5) {
                Icon(
                    imageVector = if (i <= score) Icons.Filled.Star else Icons.Filled.StarBorder,
                    contentDescription = null,
                    tint = if (i <= score) Color(0xFF4CAF50) else Color.Gray,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { onRatingChanged(i) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalificationScreenPreview() {
    CalificationScreen(
        catedraticoId = 1,

    )
}