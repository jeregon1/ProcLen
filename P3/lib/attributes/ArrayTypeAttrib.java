
package lib.attributes;

import lib.symbolTable.*;

// Utilizar en lugar del vector con 1 única componente
public class ArrayTypeAttrib implements Attributes { 
	private Token tMin, tMax;
	private int min, max, minus1 = 1, minus2 = 1;
	private Symbol.Types baseType;
	private SymbolArray baseArray = null;

    public ArrayTypeAttrib() {
        minus1 = 1;
        minus2 = 1;
        baseArray = null;
    }

    public boolean isParameter() {
        return paramClass != Symbol.ParameterClass.NONE;
    }

    public boolean isDeclaration() {
        return !isParameter();
    }
}
