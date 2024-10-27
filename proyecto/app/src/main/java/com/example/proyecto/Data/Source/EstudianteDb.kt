package com.example.proyecto.Data.Source

import com.example.proyecto.Data.Model.Catedratico
import com.example.proyecto.Data.Model.Estudiante

class EstudiantesDb {
    private val EstudiantesList: List<Estudiante> = listOf(
        Estudiante(carnet = 20210001, password = "pass123"),
        Estudiante(carnet = 20210002, password = "secure456"),
        Estudiante(carnet = 20210003, password = "mypassword"),
        Estudiante(carnet = 20210004, password = "12345pass"),
        Estudiante(carnet = 20210005, password = "hello789"),
        Estudiante(carnet = 20210006, password = "testpass"),
        Estudiante(carnet = 20210007, password = "password321"),
        Estudiante(carnet = 20210008, password = "abcdefg"),
        Estudiante(carnet = 20210009, password = "zxcvb123"),
        Estudiante(carnet = 20210010, password = "qwerty456")
    )



    fun getEstudianteById(carnet: Int): Estudiante {
        return EstudiantesList.first { it.carnet == carnet }
    }

}


