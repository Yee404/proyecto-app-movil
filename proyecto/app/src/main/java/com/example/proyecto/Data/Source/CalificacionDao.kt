package com.example.proyecto.Data.Source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyecto.Data.Model.Calificaciones

@Dao
interface CalificacionDao {

    // Insertar una nueva calificación
    @Insert
    fun agregarCalificacion(calificacion: Calificaciones)

    // Verificar si un estudiante ya calificó a un catedrático
    @Query("SELECT COUNT(*) > 0 FROM calificaciones WHERE estudianteId = :estudianteId AND catedraticoId = :catedraticoId")
    fun yaCalificadoPorEstudiante(estudianteId: Int, catedraticoId: Int): Boolean

    // Obtener todas las calificaciones asociadas a un catedrático
    @Query("SELECT * FROM calificaciones WHERE catedraticoId = :catedraticoId")
    fun obtenerCalificacionesPorCatedratico(catedraticoId: Int): List<Calificaciones>
}