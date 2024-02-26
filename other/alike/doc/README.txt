Traductor de "alike" a "pcode". Invocar como 

$ java -jar <path_to_alike/>alike.jar [-v] [-r] [-o] [-x] [-c] fuente_sin_extension
    where: 
        -v: verbose pcode (including line numbers)
        -r: run time checks (including indexed array access)
        -o: optimize for pcode execution speed (not for code size)
        -x: generate xml
        -c: write comments

La invocación sin parámetros mostrará el anterior mensaje informativo. Compilará el fichero fuente "fuente_sin_extension.al", traduciéndolo a p-código, en el fichero "fuente_sin_extension.pcode". Para su posterior ejecución, deberemos ejecutar

$ pcode_tools/mi_sistema_operativo/ensamblador fuente_sin_extension

que generará el binario para la máquina virtal de p-código "fuente_sin_extension.x", que se podrá ejecutar mediante la invocación 

$ pcode_tools/mi_sistema_operativo/fuente_sin_extension

NOTA: es importante que, una vez descargado en el directorio local, se les haya dado permiso de ejecución a las herramientas en el directorio "tu_sistema_operativo/pcode_tools"

