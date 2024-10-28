package com.example.proyecto.Data.Source

import com.example.proyecto.Data.Model.Catedratico

class CatedraticosDb {
    private val CatedraticosList: List<Catedratico> = listOf(
        Catedratico(
            id = 1,
            name = "Dr. Juan Pérez",
            curses = "Cálculo, Álgebra Lineal, Física I",
            biographic = "El Dr. Juan Pérez tiene más de 20 años de experiencia enseñando matemáticas y física en diferentes universidades del país.",
            qualificationProm = 4.0,
            image = "https://randomuser.me/api/portraits/men/1.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 3.5,
            qualification4 = 5.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 2,
            name = "Lic. María López",
            curses = "Pensamiento Crítico, Teoría del Conocimiento",
            biographic = "La Lic. María López se especializa en el desarrollo del pensamiento crítico y la filosofía contemporánea.",
            qualificationProm = 4.5,
            image = "https://randomuser.me/api/portraits/women/2.jpg",
            qualification1 = 4.0,
            qualification2 = 5.0,
            qualification3 = 4.0,
            qualification4 = 3.0,
            qualification5 = 2.0
        ),
        Catedratico(
            id = 3,
            name = "Ing. Carlos Méndez",
            curses = "Programación en C++, Sistemas Operativos",
            biographic = "El Ing. Carlos Méndez tiene una vasta experiencia en el desarrollo de software y la implementación de sistemas operativos.",
            qualificationProm = 3.2,
            image = "https://randomuser.me/api/portraits/men/3.jpg",
            qualification1 = 3.0,
            qualification2 = 3.0,
            qualification3 = 3.0,
            qualification4 = 3.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 4,
            name = "Dr. Sofía Martínez",
            curses = "Química General, Química Orgánica",
            biographic = "La Dra. Sofía Martínez es investigadora en química orgánica y ha publicado numerosos artículos en revistas internacionales.",
            qualificationProm = 1.8,
            image = "https://randomuser.me/api/portraits/women/4.jpg",
            qualification1 = 1.0,
            qualification2 = 2.0,
            qualification3 = 1.0,
            qualification4 = 1.0,
            qualification5 = 1.0
        ),
        Catedratico(
            id = 5,
            name = "Mtro. José Ramírez",
            curses = "Historia de Guatemala, Historia Universal",
            biographic = "El Mtro. José Ramírez ha dedicado su carrera a la enseñanza de la historia y la preservación del patrimonio cultural.",
            qualificationProm = 4.3,
            image = "https://randomuser.me/api/portraits/men/5.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 6,
            name = "Lic. Ana González",
            curses = "Derecho Constitucional, Derecho Internacional",
            biographic = "La Lic. Ana González es especialista en derecho internacional y ha trabajado en varias organizaciones humanitarias.",
            qualificationProm = 4.6,
            image = "https://randomuser.me/api/portraits/women/6.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 7,
            name = "Dr. Fernando Castro",
            curses = "Economía I, Macroeconomía",
            biographic = "El Dr. Fernando Castro es un economista reconocido que ha colaborado con organismos internacionales en políticas públicas.",
            qualificationProm = 2.4,
            image = "https://randomuser.me/api/portraits/men/7.jpg",
            qualification1 = 2.0,
            qualification2 = 2.0,
            qualification3 = 2.0,
            qualification4 = 2.0,
            qualification5 = 2.0
        ),
        Catedratico(
            id = 8,
            name = "Ing. Laura Hernández",
            curses = "Ingeniería de Software, Bases de Datos",
            biographic = "La Ing. Laura Hernández es una experta en desarrollo de software y ha trabajado en varias empresas tecnológicas líderes.",
            qualificationProm = 4.9,
            image = "https://randomuser.me/api/portraits/women/8.jpg",
            qualification1 = 4.0,
            qualification2 = 5.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 5.0
        ),
        Catedratico(
            id = 9,
            name = "Dr. Miguel Torres",
            curses = "Física II, Mecánica Cuántica",
            biographic = "El Dr. Miguel Torres ha investigado extensamente en el campo de la física cuántica, colaborando con varias instituciones internacionales.",
            qualificationProm = 4.1,
            image = "https://randomuser.me/api/portraits/men/9.jpg",
            qualification1 = 4.0,
            qualification2 = 3.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 10,
            name = "Mtra. Gabriela Díaz",
            curses = "Metodología de la Investigación, Estadística Aplicada",
            biographic = "La Mtra. Gabriela Díaz ha asesorado a numerosos estudiantes en la realización de investigaciones científicas en diversas áreas.",
            qualificationProm = 3.6,
            image = "https://randomuser.me/api/portraits/women/10.jpg",
            qualification1 = 3.0,
            qualification2 = 3.0,
            qualification3 = 3.0,
            qualification4 = 4.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 11,
            name = "Lic. Ricardo Molina",
            curses = "Derecho Penal, Criminología",
            biographic = "El Lic. Ricardo Molina tiene un profundo conocimiento en derecho penal y criminología, trabajando como asesor en casos legales.",
            qualificationProm = 4.5,
            image = "https://randomuser.me/api/portraits/men/11.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 12,
            name = "Dra. Patricia Guzmán",
            curses = "Biología Celular, Genética",
            biographic = "La Dra. Patricia Guzmán es investigadora en biología celular y genética, y ha dirigido importantes estudios sobre el genoma humano.",
            qualificationProm = 3.9,
            image = "https://randomuser.me/api/portraits/women/12.jpg",
            qualification1 = 4.0,
            qualification2 = 3.0,
            qualification3 = 4.0,
            qualification4 = 3.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 13,
            name = "Ing. Roberto Fernández",
            curses = "Estructuras de Datos, Inteligencia Artificial",
            biographic = "El Ing. Roberto Fernández es un especialista en inteligencia artificial, con años de experiencia en el campo de la investigación tecnológica.",
            qualificationProm = 4.7,
            image = "https://randomuser.me/api/portraits/men/13.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 14,
            name = "Mtra. Teresa Morales",
            curses = "Psicología General, Psicología Infantil",
            biographic = "La Mtra. Teresa Morales ha trabajado como psicóloga clínica y docente, enfocada en el desarrollo infantil y juvenil.",
            qualificationProm = 4.4,
            image = "https://randomuser.me/api/portraits/women/14.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 15,
            name = "Dr. Enrique Gómez",
            curses = "Filosofía Contemporánea, Ética",
            biographic = "El Dr. Enrique Gómez tiene un enfoque crítico en la filosofía contemporánea, habiendo publicado libros sobre ética y moralidad.",
            qualificationProm = 5.0,
            image = "https://randomuser.me/api/portraits/men/15.jpg",
            qualification1 = 5.0,
            qualification2 = 4.0,
            qualification3 = 5.0,
            qualification4 = 4.0,
            qualification5 = 5.0
        ),
        Catedratico(
            id = 16,
            name = "Dra. Laura Ruiz",
            curses = "Ingeniería Mecánica, Diseño Asistido por Computadora",
            biographic = "La Dra. Laura Ruiz ha liderado varios proyectos de investigación en el ámbito de la ingeniería mecánica y el diseño avanzado.",
            qualificationProm = 1.6,
            image = "https://randomuser.me/api/portraits/women/16.jpg",
            qualification1 = 1.0,
            qualification2 = 1.0,
            qualification3 = 1.0,
            qualification4 = 1.0,
            qualification5 = 1.0
        ),
        Catedratico(
            id = 17,
            name = "Ing. Andrés Castillo",
            curses = "Sistemas Digitales, Diseño de Circuitos",
            biographic = "El Ing. Andrés Castillo ha trabajado en la industria de semiconductores durante más de 15 años, especializado en circuitos digitales.",
            qualificationProm = 4.2,
            image = "https://randomuser.me/api/portraits/men/17.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 18,
            name = "Lic. Verónica Salazar",
            curses = "Derecho Administrativo, Derecho Ambiental",
            biographic = "La Lic. Verónica Salazar es una experta en derecho ambiental y ha trabajado en diversas organizaciones no gubernamentales.",
            qualificationProm = 4.7,
            image = "https://randomuser.me/api/portraits/women/18.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 19,
            name = "Mtro. Raúl Sánchez",
            curses = "Historia del Arte, Literatura Clásica",
            biographic = "El Mtro. Raúl Sánchez tiene una gran pasión por el arte y la literatura, habiendo escrito varios libros sobre historia del arte.",
            qualificationProm = 4.2,
            image = "https://randomuser.me/api/portraits/men/19.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 20,
            name = "Dra. Silvia Méndez",
            curses = "Microbiología, Biotecnología",
            biographic = "La Dra. Silvia Méndez ha sido galardonada por sus investigaciones en el área de microbiología y biotecnología aplicada.",
            qualificationProm = 4.8,
            image = "https://randomuser.me/api/portraits/women/20.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 5.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 21,
            name = "Dr. Ernesto Rodríguez",
            curses = "Física Nuclear, Termodinámica",
            biographic = "El Dr. Ernesto Rodríguez es un físico especializado en investigación nuclear, con más de 25 años de experiencia en docencia.",
            qualificationProm = 3.7,
            image = "https://randomuser.me/api/portraits/men/21.jpg",
            qualification1 = 3.0,
            qualification2 = 3.0,
            qualification3 = 3.0,
            qualification4 = 3.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 22,
            name = "Lic. Carmen Fernández",
            curses = "Antropología Social, Etnografía",
            biographic = "La Lic. Carmen Fernández es una antropóloga con un enfoque en el estudio de culturas indígenas y etnografía aplicada.",
            qualificationProm = 0.0,
            image = "https://randomuser.me/api/portraits/women/22.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 23,
            name = "Ing. Eduardo García",
            curses = "Inteligencia Artificial, Machine Learning",
            biographic = "El Ing. Eduardo García ha trabajado en proyectos de inteligencia artificial en varias empresas de tecnología de renombre mundial.",
            qualificationProm = 2.9,
            image = "https://randomuser.me/api/portraits/men/23.jpg",
            qualification1 = 2.0,
            qualification2 = 2.0,
            qualification3 = 3.0,
            qualification4 = 2.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 24,
            name = "Dra. Claudia López",
            curses = "Psicología Clínica, Neuropsicología",
            biographic = "La Dra. Claudia López es una psicóloga clínica con un enfoque en neuropsicología, tratando casos de trauma y desarrollo cognitivo.",
            qualificationProm = 4.8,
            image = "https://randomuser.me/api/portraits/women/24.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 25,
            name = "Mtro. Luis Martínez",
            curses = "Historia Contemporánea, Sociología",
            biographic = "El Mtro. Luis Martínez es un apasionado de la historia contemporánea y su influencia en las sociedades modernas.",
            qualificationProm = 4.6,
            image = "https://randomuser.me/api/portraits/men/25.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 26,
            name = "Ing. Natalia Ramírez",
            curses = "Ciencia de Datos, Big Data",
            biographic = "La Ing. Natalia Ramírez se especializa en el análisis de grandes volúmenes de datos, con experiencia en ciencia de datos aplicada.",
            qualificationProm = 4.0,
            image = "https://randomuser.me/api/portraits/women/26.jpg",
            qualification1 = 3.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 3.0
        ),
        Catedratico(
            id = 27,
            name = "Dr. Francisco Pineda",
            curses = "Economía del Desarrollo, Finanzas Internacionales",
            biographic = "El Dr. Francisco Pineda es un economista con un enfoque en el desarrollo y las finanzas internacionales, colaborando con gobiernos y ONGs.",
            qualificationProm = 4.5,
            image = "https://randomuser.me/api/portraits/men/27.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 28,
            name = "Lic. Sandra Gómez",
            curses = "Derecho Laboral, Derechos Humanos",
            biographic = "La Lic. Sandra Gómez es especialista en derecho laboral y derechos humanos, asesorando a diferentes organismos internacionales.",
            qualificationProm = 4.69,
            image = "https://randomuser.me/api/portraits/women/28.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 29,
            name = "Ing. Alejandro Solís",
            curses = "Ingeniería Robótica, Control de Sistemas",
            biographic = "El Ing. Alejandro Solís ha liderado proyectos en robótica y control de sistemas avanzados en la industria automotriz.",
            qualificationProm = 4.6,
            image = "https://randomuser.me/api/portraits/men/29.jpg",
            qualification1 = 4.0,
            qualification2 = 4.0,
            qualification3 = 4.0,
            qualification4 = 4.0,
            qualification5 = 4.0
        ),
        Catedratico(
            id = 30,
            name = "Dra. Andrea Torres",
            curses = "Bioquímica, Biotecnología",
            biographic = "La Dra. Andrea Torres ha sido reconocida por sus avances en biotecnología, desarrollando nuevas tecnologías en el ámbito biomédico.",
            qualificationProm = 1.7,
            image = "https://randomuser.me/api/portraits/women/30.jpg",
            qualification1 = 1.0,
            qualification2 = 1.0,
            qualification3 = 1.0,
            qualification4 = 1.0,
            qualification5 = 1.0
        )




    )

    // Función para obtener la lista completa de catedráticos
    fun obtenerListaCatedraticos(): List<Catedratico> {
        return CatedraticosList
    }

    // Función para obtener un catedrático por su ID
    fun obtenerCatedraticoPorId(id: Int): Catedratico? {
        return CatedraticosList.find { it.id == id }
    }


}