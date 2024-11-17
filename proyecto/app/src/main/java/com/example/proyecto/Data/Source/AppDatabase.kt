package com.example.proyecto.Data.Source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto.Data.Model.Catedratico
import com.example.proyecto.Data.Model.Calificaciones
import com.example.proyecto.Data.Model.Estudiante

@Database(
    entities = [Catedratico::class, Calificaciones::class, Estudiante::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catedraticoDao(): CatedraticoDao
    abstract fun calificacionDao(): CalificacionDao
    abstract fun estudianteDao(): EstudianteDao
}