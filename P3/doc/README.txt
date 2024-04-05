Compilador alike.jar (V1.0)
------------------------------
Análisis semántico

--> Autores:
Javier Sin Pelayo, 843442
Jesús López Ansón, 839922

--> Fecha de entrega: 17-4-2024

--> Compilar mediante: "ant"

--> Invocar como: "java -jar alike_4.jar <fichero_fuente_alike>"

- El fichero alike_4.jar se encuentra en el directorio "dist". De este modo, se debe de 
aportar una ruta hasta el mismo, o estar en el propio directorio al lanzar el programa.

- El fichero fuente debe de contener el nombre completo, 
incluido el ".al" relativo a la extensión del lenguaje alike

- Si se invoca sin parámetros, lee desde la entrada estándar.


--> Características generales:
Consiste en un compilador que realiza el análisis léxico, sintáctico y semántico de la entrada recibida 
para el lenguaje de programación "alike". Consiste en la versión de nivel 4 del compilador, que admite
las siguentes características:
"Uso de parámetros escalares y de vectores, tanto por valor como por referencia en procedimientos y funciones".

--> En caso de detección de errores:
- Si se detecta algún error sintáctico, se muestra el lugar donde se ha producido y se interrumpe el
proceso de compilación. A su vez se muestra qué símbolo ha producido el error, y los tokens esperados.

- Si se produce un error semántico, al igual que en el caso anterior, se muestra el lugar donde se ha
producido el error, pero en este caso se continúa con el proceso de compilación. Se muestra a su vez,
información detallada respecto al comportamiento erróneo que ha causado el error semántico. (Si no se 
produce ningún error sintáctico, se muestra también la cantidad de errores semánticos detectados.)


--> Organización del proyecto:
El proyecto gira en torno a la clase "alike_4.jj", donde se realizan los distintos análisis.
Para ello, se apoya de las clases: 
- "Token" 
- Todas las clases que hacen alusión a los "Símbolos" y "Tabla de Símbolos"
- "ErrorSemantico" útil para la impresión de errores con el mismo formato, y para recopilar 
   información sobre el número de errores semánticos detectados.
- "SemanticFunctions" donde se definen métodos para encapsular ciertas funciones relativas 
   a la lógica semántica del compilador. A su vez, el uso de la Tabla de Símbolos está realmente
   encapsulado en esta clase, al igual que otros detalles varios como flags necesarios para el 
   correcto funcionamiento del compilador.
