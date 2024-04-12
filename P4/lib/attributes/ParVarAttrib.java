
package lib.attributes;

import lib.symbolTable.*;

public class ParVarAttrib implements Attributes {
    // List<Token> t;
    SymbolArray paramArray;
    Symbol.Types baseType;
    Symbol.ParameterClass paramClass;

    public ParVarAttrib() {
        // this.t = new ArrayList<Token>();
        this.paramArray = new SymbolArray("");
        this.baseType = Symbol.Types.NONE;
        this.paramClass = Symbol.ParameterClass.VAL;
    }
}
