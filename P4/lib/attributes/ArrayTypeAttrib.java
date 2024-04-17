
package lib.attributes;

import lib.symbolTable.*;
import traductor.*;

// Utilizar en lugar del vector con 1 única componente
public class ArrayTypeAttrib extends Attributes { 
	public Token tMin, tMax;
	public int min, max, minus1 = 1, minus2 = 1;
	public Symbol.Types baseType;
	public SymbolArray baseArray = null;

    public ArrayTypeAttrib() {
        minus1 = 1; minus2 = 1;
        baseArray = null;
    }

    // public boolean isParameter() {
    //     return paramClass != Symbol.ParameterClass.NONE;
    // }

    // public boolean isDeclaration() {
    //     return !isParameter();
    // }
}
