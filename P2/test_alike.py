#!/usr/bin/python3
# -*- coding: utf-8 -*-
"""
--------------------------------------------------------------------
File:   test_alike.py
Author: Procesadores de lenguajes. Univ. de Zaragoza
Date:   febrero 2023
Coms:   Ejecutar como
            python3 test_alike.py <path_alike.jar> <path_fuentes_alike>
        Alternativamente, si se le han dado permisos de ejecución
            ./test_alike.py <path_alike.jar> <path_fuentes_alike>
--------------------------------------------------------------------
"""
import os
import sys
import shutil

#----------------------------------------------------------------
#Comprueba que se invoque con dos parámetros
if len(sys.argv) != 3:
    print('------------------------------------------')
    sys.exit('Invocar como: ' + sys.argv[0] + ' <path_alike.jar> <path_fuentes_alike>') 
else:
    traductor = sys.argv[1]
    path_fuentes = sys.argv[2]

fuentes = os.listdir(path_fuentes)
# solo nos interesan los que tengan extensión '.al'
fuentes_alike = [f for f in fuentes if os.path.splitext(f)[1] == '.al']

for f in fuentes_alike:
    try:
        print('\n====================================')
        res = os.system('java -jar ' + traductor + ' ' + os.path.join(path_fuentes,f))
        print('\n========== ' + f + ' ==========')
        res = input('\nReturn para continuar')
    except Exception as e:
        print(e)
    