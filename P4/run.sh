#!/bin/bash

if [ $(whoami) == "jesus" ]
then
    dir=~/proclen/P4
else
    dir=~/PL/P4
fi

# Comprobar que hay dos parámetros: el fichero alike.jar y el fichero de prueba
if [ $# -lt 2 ] || [ "$1" != "bobi" ] && [ "$1" != "corni" ]
then
    echo "Uso: ./run.sh <bobi|corni> <fichero.al> [-v]"
    exit 1
fi

# Si el primer parámetro es "bobi", se ejecuta el compilador $dir/../other/alike/alike.jar
if [ $1 = "bobi" ]
then
    java -jar $dir/../other/alike/alike.jar "$2" "$3"
else
    # Si el primer parámetro es "corni", se ejecuta el compilador $dir/dist/alike.jar
    java -jar $dir/dist/alike_4.jar "$2" "$3"
fi

# Su compilador--> java -jar ../other/alike/alike.jar p
# (Borrar posteriormente) 🎃 Ejemplo de ejecución en terminal--> java -jar ~/PL/P4/dist/alike_4.jar ./test/test_func