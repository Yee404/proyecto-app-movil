package com.example.proyecto.Data.Source

import com.example.proyecto.Data.Model.Calificaciones

class CalificacionDb {
    private val CalificacionList: List<Calificaciones> = listOf(
        Calificaciones(calificacionid = 1, estudianteId = 20210001, catedraticoId = 1, qualification1 = 4.5, qualification2 = 3.8, qualification3 = 4.2, qualification4 = 3.5, qualification5 = 4.0),
        Calificaciones(calificacionid = 2, estudianteId = 20210002, catedraticoId = 11, qualification1 = 3.0, qualification2 = 3.5, qualification3 = 4.0, qualification4 = 3.8, qualification5 = 3.6),
        Calificaciones(calificacionid = 3, estudianteId = 20, catedraticoId = 12, qualification1 = 4.8, qualification2 = 4.9, qualification3 = 5.0, qualification4 = 4.7, qualification5 = 4.5),
        Calificaciones(calificacionid = 4, estudianteId = 20, catedraticoId = 2, qualification1 = 4.0, qualification2 = 3.9, qualification3 = 4.3, qualification4 = 4.1, qualification5 = 4.2),
        Calificaciones(calificacionid = 5, estudianteId = 20210005, catedraticoId = 3, qualification1 = 3.5, qualification2 = 3.2, qualification3 = 3.8, qualification4 = 3.6, qualification5 = 3.9),
        Calificaciones(calificacionid = 6, estudianteId = 20210001, catedraticoId = 3, qualification1 = 4.2, qualification2 = 4.4, qualification3 = 4.1, qualification4 = 4.3, qualification5 = 4.0),
        Calificaciones(calificacionid = 7, estudianteId = 20210001, catedraticoId = 20, qualification1 = 3.7, qualification2 = 3.9, qualification3 = 3.5, qualification4 = 3.6, qualification5 = 3.8),
        Calificaciones(calificacionid = 8, estudianteId = 20, catedraticoId = 4, qualification1 = 4.9, qualification2 = 4.8, qualification3 = 5.0, qualification4 = 4.7, qualification5 = 4.6),
        Calificaciones(calificacionid = 9, estudianteId = 20210009, catedraticoId = 5, qualification1 = 3.6, qualification2 = 3.7, qualification3 = 3.9, qualification4 = 3.5, qualification5 = 3.8),
        Calificaciones(calificacionid = 10, estudianteId = 20, catedraticoId = 5, qualification1 = 4.0, qualification2 = 3.8, qualification3 = 4.2, qualification4 = 4.1, qualification5 = 4.3)
    )



    // Función para verificar si el estudiante ya calificó al catedrático
    fun yaCalificadoPorEstudiante(estudianteId: Int, catedraticoId: Int): Boolean {
        return CalificacionList.any { it.estudianteId == estudianteId && it.catedraticoId == catedraticoId }
    }

}

