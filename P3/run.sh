#!/bin/bash

if [ $(whoami) == "jesus" ]
then
    dir=~/proclen/P3
else
    dir=~/PL/P3
fi

# Comprobar que hay dos parámetros: el fichero alike.jar y el fichero de prueba
if [ $# -ne 2 ] || [ "$1" != "bobi" ] && [ "$1" != "corni" ]
then
    echo "Uso: ./run.sh <bobi|corni> <fichero.al>"
    exit 1
fi

# Si el primer parámetro es "bobi", se ejecuta el compilador $dir/../other/alike/alike.jar
if [ $1 = "bobi" ]
then
    java -jar $dir/../other/alike/alike.jar "$2"
else
    # Si el primer parámetro es "corni", se ejecuta el compilador $dir/dist/alike.jar
    java -jar $dir/dist/alike.jar "$2"
fi

# Su compilador--> java -jar ../other/alike/alike.jar p