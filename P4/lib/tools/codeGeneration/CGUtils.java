//*****************************************************************
// File:   CGUtils.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   abril 2022
// Coms:   Librería con el método para crear etiquetas frescas y 
// 			una variable estática para llevar la traza de las 
// 			direcciones de memoria 
//*****************************************************************

package lib.tools.codeGeneration;

import lib.tools.codeGeneration.PCodeInstruction.OpCode;

public class CGUtils {
	
	private static int l=0; 
	
	public static String newLabel () {
		return "L"+(l++); 
	}
	
	/*  campo requerido para la generación de código
	 Cada componente de este array simboliza los espacios de memoria usados 
	 en la última función definida de cada nivel de profundidad de definición de funciones
	 */
	public static int usedMemorySpaces[] = new int[100];
	
}
