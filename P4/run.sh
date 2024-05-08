#!/bin/bash

if [ $(whoami) == "jesus" ]
then
    dir=~/proclen/P4
else
    dir=~/PL/P4
fi

COMP_TEACHERS="$dir/../other/alike/alike.jar"
COMP_SINANSON="$dir/dist/alike_4.jar"

# Comprobar que hay dos parámetros: el fichero alike.jar y el fichero de prueba
if [ $# -lt 2 ] || [ "$1" != "bobi" ] && [ "$1" != "corni" ]
then
    echo "Uso: ./run.sh <bobi|corni> <fichero.al> [-v]"
    exit 1
fi

if [ $1 = "bobi" ]
then
    if ! java -jar $COMP_TEACHERS "$2"; then
        echo "error: alike.jar failed"
        exit 1
    fi
else # corni
    if ! ant ; then
		echo "error: ant failed"
		exit 1
	fi

    java -jar $COMP_SINANSON "$2" "$3"
fi
