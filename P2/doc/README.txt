Compilador alike.jar (V1.0)
------------------------------
Análisis léxico y sintáctico

--> Autores:
Javier Sin Pelayo, 843442
Jesús López Ansón, 839922

--> Fecha de entrega: 6-3-2024

--> Compilar mediante: "ant"

--> Invocar como: "java -jar alike.jar <fichero_fuente_alike>"

- El fichero alike.jar se encuentra en el directorio "dist". De este modo, se debe de 
aportar una ruta hasta el mismo, o estar en el propio directorio al lanzar el programa.

- El fichero fuente debe de contener el nombre completo, 
incluido el ".al" relativo a la extensión del lenguaje alike

- Si se invoca sin parámetros, lee desde la entrada estándar.


--> Características generales:
Consiste en un compilador que realiza el análisis léxico y sintáctico de la entrada recibida 
para el lenguaje de programación "alike". Si existe algún error léxico muestra en qué
punto de la entrada se ha encontrado con dicho error, y muestra tanto el token erróneo,
como los tokens que se esperaba recibir.