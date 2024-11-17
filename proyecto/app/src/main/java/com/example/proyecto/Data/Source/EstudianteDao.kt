package com.example.proyecto.Data.Source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyecto.Data.Model.Estudiante

@Dao
interface EstudianteDao {

    // Obtener la lista completa de estudiantes
    @Query("SELECT * FROM estudiantes")
    fun obtenerListaEstudiantes(): List<Estudiante>

    // Obtener un estudiante por su carné
    @Query("SELECT * FROM estudiantes WHERE carnet = :carnet")
    fun getEstudianteById(carnet: Int): Estudiante?

    // Insertar un nuevo estudiante
    @Insert
    fun insertarEstudiante(estudiante: Estudiante)
}