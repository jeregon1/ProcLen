#!/bin/bash

if [ $(whoami) == "jesus" ]
then
    dir=~/proclen/P4
else
    dir=~/PL/P4
fi

COMP_TEACHERS="$dir/../other/alike/alike.jar"
COMP_SINANSON="$dir/dist/alike_4.jar"
PTOOLS="$dir/../other/alike/pcode_tools/linux"

if [ $# -lt 2 ] || [ "$1" != "-t" ] && [ "$1" != "-o" ]
then
    echo "Uso: ./run.sh < -t | -o > <fichero> [-v] [-s]"
    echo "   -t: usar compilador de los profesores"
    echo "   -o: usar compilador propio"
    echo "   -v: verbose, mostrar bloques de symbol table"
    echo "   -s: saltar ant"
    exit 1
fi

if [ $1 = "-t" ]; then
    rm "$2".pcode "$2".x 2> /dev/null
    if ! java -jar $COMP_TEACHERS "$2"; then
        echo "error: alike.jar failed"
        exit 1
    fi
else # own

    if [ "$3" != "-s" ] && [ "$4" != "-s" ]; then
        if ! ant ; then
            echo "error: ant failed"
            exit 1
        fi
    fi
    
    rm "$2".pcode "$2".x 2> /dev/null

    java -jar $COMP_SINANSON "$2" "$3"
fi

shift

if ! "$PTOOLS"/ensamblador "$1"; then
    echo "error: ensamblador failed"
    exit 1
fi

"$PTOOLS"/maquinap "$1"