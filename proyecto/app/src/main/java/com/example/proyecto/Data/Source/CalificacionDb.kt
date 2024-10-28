package com.example.proyecto.Data.Source

import com.example.proyecto.Data.Model.Calificaciones

class CalificacionDb {
    private val CalificacionList: List<Calificaciones> = listOf(
        Calificaciones(calificacionid = 1, estudianteId = 20210001, catedraticoId = 1, qualification1 = 4.0, qualification2 = 3.0, qualification3 = 4.0, qualification4 = 3.0, qualification5 = 4.0),
        Calificaciones(calificacionid = 2, estudianteId = 20210002, catedraticoId = 11, qualification1 = 3.0, qualification2 = 3.0, qualification3 = 4.0, qualification4 = 3.0, qualification5 = 3.0),
        Calificaciones(calificacionid = 3, estudianteId = 20, catedraticoId = 12, qualification1 = 4.0, qualification2 = 5.0, qualification3 = 5.0, qualification4 = 4.0, qualification5 = 4.0),
        Calificaciones(calificacionid = 4, estudianteId = 20, catedraticoId = 2, qualification1 = 4.0, qualification2 = 3.0, qualification3 = 4.0, qualification4 = 4.0, qualification5 = 4.0),
        Calificaciones(calificacionid = 5, estudianteId = 20210005, catedraticoId = 3, qualification1 = 3.0, qualification2 = 3.0, qualification3 = 4.0, qualification4 = 3.0, qualification5 = 3.0),
        Calificaciones(calificacionid = 6, estudianteId = 20210001, catedraticoId = 3, qualification1 = 4.0, qualification2 = 4.0, qualification3 = 4.0, qualification4 = 4.0, qualification5 = 4.0),
        Calificaciones(calificacionid = 7, estudianteId = 20210001, catedraticoId = 20, qualification1 = 3.0, qualification2 = 3.0, qualification3 = 3.0, qualification4 = 3.0, qualification5 = 3.0),
        Calificaciones(calificacionid = 8, estudianteId = 20, catedraticoId = 4, qualification1 = 5.0, qualification2 = 4.0, qualification3 = 5.0, qualification4 = 4.0, qualification5 = 4.0),
        Calificaciones(calificacionid = 9, estudianteId = 20210009, catedraticoId = 5, qualification1 = 3.0, qualification2 = 3.0, qualification3 = 3.0, qualification4 = 3.0, qualification5 = 3.0),
        Calificaciones(calificacionid = 10, estudianteId = 20, catedraticoId = 5, qualification1 = 4.0, qualification2 = 3.0, qualification3 = 4.0, qualification4 = 4.0, qualification5 = 4.0)
    )



    // Función para verificar si el estudiante ya calificó al catedrático
    fun yaCalificadoPorEstudiante(estudianteId: Int, catedraticoId: Int): Boolean {
        return CalificacionList.any { it.estudianteId == estudianteId && it.catedraticoId == catedraticoId }
    }

}

