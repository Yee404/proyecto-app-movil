# proyecto-app-movil

## Autores

-   [Eliazar José Pablo Canastuj Matías - 23384]
-   [Diego Alejandro Ramírez Velásquez - 23601]
-   [María José Yee Vidal - 231193]

## Descripción
En el entorno universitario elegir a un catedrático adecuado puede marcar una gran diferencia en la experiencia y el éxito académico de un estudiante. Sin embargo, la mayoría de los estudiantes nuevos carecen de información suficiente sobre los catedráticos antes de inscribirse en sus clases, lo que puede resultar en asignaciones menos ideales e incluso en una experiencia educativa subóptima. Nuestra aplicación móvil surge como una solución innovadora a esta problemática ya que con ella los estudiantes pueden realizar y consultar reseña mediante el rating basado en estrellas sobre los catedráticos de la universidad, proporcionando una plataforma transparente y accesible para compartir y obtener información valiosa. Esta herramienta no sólo empodera a los estudiantes para tomar decisiones informadas, sino que también fomenta un ambiente de retroalimentación
constructiva que puede beneficiar tanto a los catedráticos como a la institución educativa en su conjunto.


### Servicios
- Firebase Authentication: Firebase Authentication es un servicio de Google que proporciona una forma sencilla de autenticar a los usuarios en la aplicación usando métodos como Google, Facebook, correo electrónico y contraseña, entre otros.
Este servicio se utilizaría para manejar la autenticación de usuarios. Los estudiantes deberán iniciar sesión para acceder a la funcionalidad de calificación de catedráticos. Una vez autenticados, cada usuario tendrá un identificador único que permitirá relacionar sus calificaciones y datos específicos en la aplicación.

- Base de datos local (Room): Para una base de datos local, se puede almacenar toda la información de catedráticos y sus calificaciones en Room. Se sincronizaría solo cuando haya conexión a internet o cuando el usuario lo requiera.

- ### Librerías
- Firebase Authentication:  Es una herramienta de autenticación de Google que permite integrar múltiples métodos de inicio de sesión en aplicaciones móviles, como correo electrónico, Google y Facebook. En la app, esta librería permitirá que los estudiantes se autentiquen antes de acceder a funciones como la calificación de catedráticos y el guardado de preferencias en su perfil.

- Room Database: Room es una librería de persistencia de datos local que facilita el manejo de bases de datos en Android, proporcionando una capa de abstracción sobre SQLite. En la app, Room será utilizado para almacenar la información de catedráticos y sus calificaciones localmente, permitiendo que los datos estén disponibles offline y se sincronicen con Firebase Firestore cuando el dispositivo tenga conexión a internet.

- Coil: Sirve para la carga de imágenes especialmente diseñada para Jetpack Compose que facilita la carga y el manejo eficiente de imágenes desde URLs. En esta app, Coil será utilizada para mostrar las imágenes de perfil de los catedráticos, mejorando la experiencia visual al cargar las fotos desde internet sin complicaciones adicionales.
