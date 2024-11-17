package com.example.proyecto.Presentation.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyecto.Data.Model.Catedratico
import com.example.proyecto.Data.Model.Estudiante
import com.example.proyecto.Data.Source.CalificacionDb
import com.example.proyecto.Data.Source.CatedraticosDb
import com.example.proyecto.Data.Source.EstudiantesDb
import com.example.proyecto.R



@Composable
fun CatedraticoRoute(
    estudianteId: Int,
    onCharClick: (Int) -> Unit
) {
    val estudianteDb = EstudiantesDb()
    val estudiante = estudianteDb.getEstudianteById(estudianteId)

    CatedraticosScreen(
        estudiante = estudiante,
        onCharClick = onCharClick
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CatedraticosScreen(
    estudiante: Estudiante,
    onCharClick: (Int) -> Unit

) {
    var filtroSeleccionado by remember { mutableStateOf("Todos") }
    var searchQuery by remember { mutableStateOf("") } // Estado para la búsqueda
    val catedraticosDb = CatedraticosDb()
    val calificaionesDb = CalificacionDb()


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Barra de búsqueda
                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = {
                            Text(
                                "Buscar Catedrático",
                                color = Color.Black,
                            )
                                      },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,   // Fondo transparente
                            focusedTextColor = Color.Black,       // Texto en blanco cuando está enfocado
                            unfocusedTextColor = Color.White,     // Texto en blanco cuando no está enfocado
                            focusedIndicatorColor = Color.Transparent, // Sin línea de enfoque
                            unfocusedIndicatorColor = Color.Transparent, // Sin línea desenfocada
                            cursorColor = Color.White             // Cursor en blanco
                        ),
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp) // Ajuste del tamaño del ícono
                            )
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4CAF50)
                ),
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Text(
                    text = "Filtrar Catedráticos",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 4.dp)
                )
                // Barra de filtros
                FiltroBar(filtroSeleccionado) { nuevoFiltro ->
                    filtroSeleccionado = nuevoFiltro
                }

                // Lista de catedráticos con filtro aplicado y búsqueda
                CatedraticosList(catedraticosDb, filtroSeleccionado, searchQuery, estudiante.carnet, calificaionesDb, onCharClick = onCharClick)
            }
        }
    )
}

@Composable
fun FiltroBar(filtroSeleccionado: String, onFiltroChange: (String) -> Unit) {
    val filtros = listOf("Todos", "Calificación", "Curso", "Alfabéticamente")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filtros) { filtro ->
            FilterChip(
                selected = filtro == filtroSeleccionado,
                onClick = { onFiltroChange(filtro) },
                label = { Text(filtro) },
                modifier = Modifier.padding(horizontal = 4.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFC8E6C9),
                    labelColor = Color.Black,
                    selectedLabelColor = Color.Black
                ),
            )
        }
    }
}

@Composable
fun CatedraticosList(
    catedraticosDb: CatedraticosDb,
    filtroSeleccionado: String,
    searchQuery: String,
    estudianteId: Int,
    calificacionDb: CalificacionDb,
    onCharClick: (Int) -> Unit
) {
    // Obtén la lista de catedráticos desde la base de datos
    val catedraticos = catedraticosDb.obtenerListaCatedraticos()

    // Filtrar por búsqueda
    val catedraticosFiltradosPorBusqueda = if (searchQuery.isNotEmpty()) {
        catedraticos.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }
    } else {
        catedraticos
    }

    // Aplica el filtro seleccionado
    val catedraticosFiltrados = when (filtroSeleccionado) {
        "Calificación" -> catedraticosFiltradosPorBusqueda.sortedByDescending { it.qualificationProm }
        "Curso" -> catedraticosFiltradosPorBusqueda.sortedBy { it.curses }
        "Alfabéticamente" -> catedraticosFiltradosPorBusqueda.sortedBy { it.name }
        else -> catedraticosFiltradosPorBusqueda
    }

    LazyColumn {
        items(catedraticosFiltrados) { catedratico ->
            val yaCalificado = calificacionDb.yaCalificadoPorEstudiante(estudianteId, catedratico.id)
            CatedraticoItem(catedratico, yaCalificado, onCharClick = onCharClick)
        }
    }
}

@Composable
fun CatedraticoItem(
    catedratico: Catedratico,
    yaCalificado: Boolean,
    onCharClick: (Int) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onCharClick(catedratico.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del catedrático con borde dinámico
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Reemplazar con imagen adecuada
            contentDescription = "Imagen del Catedrático",
            modifier = Modifier
                .size(64.dp)
                .border(2.dp, if (yaCalificado) Color(0xFF4CAF50) else Color.Red) // Borde verde si ya fue calificado
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = catedratico.name,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Cursos que imparte: ${catedratico.curses}",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Calificación en estrellas (rating)
        RatingBar(catedratico.qualificationProm)

        Spacer(modifier = Modifier.width(16.dp))
    }
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun RatingBar(rating: Double) {
    val filledStars = rating.toInt()
    val unfilledStars = 5 - filledStars
    val halfStar = if (rating - filledStars >= 0.5) 1 else 0

    Row {
        repeat(filledStars) {
            Icon(Icons.Default.Star, contentDescription = "Estrella llena", tint = Color(0xFF4CAF50))
        }
        if (halfStar == 1) {
            Icon(Icons.Default.StarHalf, contentDescription = "Media estrella", tint = Color(0xFF4CAF50))
        }
        repeat(unfilledStars - halfStar) {
            Icon(Icons.Default.StarBorder, contentDescription = "Estrella vacía", tint = Color(0xFF4CAF50))
        }
    }
}


@Preview
@Composable
fun PreviewCatedraticosScreen() {
    CatedraticosScreen(Estudiante(carnet =20210001, password = "hola"), onCharClick = { /* Acción de prueba */ })
}