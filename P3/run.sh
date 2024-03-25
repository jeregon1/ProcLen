#!/bin/bash

if [ $(whoami) == "jesus" ]
then
    dir="/mnt/c/Users/jesus/OneDrive/Documentos/3ºCarrera/ProLen/Practicas/P3"
else
    dir="~/PL/P1"
fi

# Si hay un argumento, se ejecuta el programa con el argumento, si no, con el fichero ../other/tests/cambio_base.al
if [ -z "$1" ]
then
    java -jar "$dir/dist/alike.jar" "../other/tests/cambio_base.al"
else
    java -jar "$dir/dist/alike.jar" "../other/tests/$1"
fi
