package com.example.proyecto.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catedraticos")
data class Catedratico(
    @PrimaryKey val id: Int,
    val name: String,
    val curses: String,
    val biographic: String,
    val qualificationProm: Double,
    val image: String,
    val qualification1: Double,
    val qualification2: Double,
    val qualification3: Double,
    val qualification4: Double,
    val qualification5: Double

)