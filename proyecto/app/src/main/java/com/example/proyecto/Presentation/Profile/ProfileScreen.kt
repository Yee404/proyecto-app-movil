package com.example.proyecto.Presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.proyecto.Data.Source.CatedraticosDb
import com.example.proyecto.Data.Source.EstudiantesDb
import com.example.proyecto.R


@Composable
fun ProfileRoute(
    estudiantId: Int,
    verCal: () -> Unit,
    Cal: () -> Unit
) {

    ProfileScreen(
        catedraticoId = estudiantId,
        verCal = verCal,
        Cal = Cal
    )
}

@Composable
fun ProfileScreen(
    catedraticoId: Int,
    verCal: () -> Unit,
    Cal: () -> Unit
) {
    val catedraticosDb = CatedraticosDb()
    val catedratico = catedraticosDb.obtenerCatedraticoPorId(catedraticoId)

    // Verifica si el catedrático existe
    if (catedratico != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Imagen del perfil
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Reemplazar con imagen adecuada
                contentDescription = "Imagen del Catedrático",
                modifier = Modifier
                    .size(150.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del catedrático
            Text(
                text = catedratico.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = Cal,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "Calificar catedrático")
                }

                Button(
                    onClick = verCal,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "Ver Calificaciones")
                }
            }
        }
    } else {
        // Mostrar un mensaje si el catedrático no existe
        Text(
            text = "Catedrático no encontrado",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun ProfileScreenPreview() {
//    ProfileScreen(
//        catedraticoId = 1, // ID de ejemplo
//    )
//}


