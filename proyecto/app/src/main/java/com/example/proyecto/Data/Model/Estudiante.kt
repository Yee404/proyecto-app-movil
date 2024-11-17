package com.example.proyecto.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiantes")
data class Estudiante(
    @PrimaryKey val carnet: Int,
    val password: String
)