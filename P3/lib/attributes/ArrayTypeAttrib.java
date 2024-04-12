
package lib.attributes;

import lib.symbolTable.*;

// Utilizar en lugar del vector con 1 única componente
public class ArrayTypeAttrib implements Attributes { 
	Token tMin, tMax;
	int min, max, minus1 = 1, minus2 = 1;
	Symbol.Types baseType;
	SymbolArray baseArray = null;
	boolean isParameter = (paramClass != Symbol.ParameterClass.NONE);
	boolean isDeclaration = !isParameter;

    ArrayTypeAttrib() {
        minus1 = 1;
        minus2 = 1;
        baseArray = null;
    }

    boolean isParameter() {
        return param
    }
}
