package com.example.proyecto.Presentation.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.sp
import com.example.proyecto.Data.Catedratico
import com.example.proyecto.Data.CatedraticosDb
import com.example.proyecto.R

@Preview
@Composable
fun PreviewCatedraticosScreen() {
    CatedraticosScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatedraticosScreen() {
    var filtroSeleccionado by remember { mutableStateOf("Todos") }
    var searchQuery by remember { mutableStateOf("") } // Estado para la búsqueda
    val catedraticosDb = CatedraticosDb()

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
                          //      fontWeight = FontWeight.Bold  // Texto en negrita
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
                CatedraticosList(catedraticosDb, filtroSeleccionado, searchQuery)
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
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp), // Ajustamos el padding
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filtros) { filtro ->
            FilterChip(
                selected = filtro == filtroSeleccionado,
                onClick = { onFiltroChange(filtro) },
                label = { Text(filtro) },
                modifier = Modifier.padding(horizontal = 4.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFC8E6C9),    // Fondo verde cuando está seleccionado
                    labelColor = Color.Black,                      // Color del texto cuando no está seleccionado
                    selectedLabelColor = Color.Black               // Color del texto cuando está seleccionado
                ),
            )
        }
    }
}

@Composable
fun CatedraticosList(
    catedraticosDb: CatedraticosDb,
    filtroSeleccionado: String,
    searchQuery: String
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
        "Calificación" -> catedraticosFiltradosPorBusqueda.sortedByDescending { it.qualification }
        "Curso" -> catedraticosFiltradosPorBusqueda.sortedBy { it.curses }
        "Alfabéticamente" -> catedraticosFiltradosPorBusqueda.sortedBy { it.name }
        else -> catedraticosFiltradosPorBusqueda
    }

    LazyColumn {
        items(catedraticosFiltrados) { catedratico ->
            CatedraticoItem(catedratico)
        }
    }
}

@Composable
fun CatedraticoItem(catedratico: Catedratico) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del catedrático
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Reemplazar con imagen adecuada
            contentDescription = "Imagen del Catedrático",
            modifier = Modifier
                .size(64.dp)
                .border(2.dp, Color.Red)
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
        RatingBar(catedratico.qualification)

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