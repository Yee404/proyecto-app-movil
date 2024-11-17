package com.example.proyecto.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calificaciones")
data class Calificaciones(
    @PrimaryKey(autoGenerate = true) val calificacionid: Int = 0,
    val estudianteId: Int,
    val catedraticoId: Int,
    val qualification1: Double,
    val qualification2: Double,
    val qualification3: Double,
    val qualification4: Double,
    val qualification5: Double
)