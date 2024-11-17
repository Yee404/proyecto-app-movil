package com.example.proyecto.Data.Source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyecto.Data.Model.Catedratico

@Dao
interface CatedraticoDao {

    // Obtener la lista completa de catedráticos
    @Query("SELECT * FROM catedraticos")
    fun obtenerListaCatedraticos(): List<Catedratico>

    // Obtener un catedrático por su ID
    @Query("SELECT * FROM catedraticos WHERE id = :id")
    fun obtenerCatedraticoPorId(id: Int): Catedratico?

    // Insertar un nuevo catedrático
    @Insert
    fun insertarCatedratico(catedratico: Catedratico)
}