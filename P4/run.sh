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

# COMPILER SELECTOR:
#   -t --> teachers
#   -o --> own
if [ $# -lt 2 ] || [ "$1" != "-t" ] && [ "$1" != "-o" ]
then
    echo "Uso: ./run.sh < -t | -o > <fichero> [-v]"
    echo "   -t: usar compilador de los profesores"
    echo "   -o: usar compilador propio"
    exit 1
fi

if [ $1 = "-t" ]; then
    rm "$2".pcode "$2".x
    if ! java -jar $COMP_TEACHERS "$2"; then
        echo "error: alike.jar failed"
        exit 1
    fi
else # own
    if ! ant ; then
		echo "error: ant failed"
		exit 1
	fi
    rm "$2".pcode "$2".x

    java -jar $COMP_SINANSON "$2" "$3"
fi

shift

if ! "$PTOOLS"/ensamblador "$1"; then
    echo "error: ensamblador failed"
    exit 1
fi

"$PTOOLS"/maquinap "$1"