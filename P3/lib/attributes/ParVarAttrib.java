
package lib.attributes;

import lib.symbolTable.*;
import traductor.*;
import java.util.List;
import java.util.ArrayList;

public class ParVarAttrib extends Attributes {
    public List<Token> t;
    public SymbolArray paramArray;
    public Symbol.Types baseType;
    public Symbol.ParameterClass paramClass;

    public ParVarAttrib() {
        this.t = new ArrayList<Token>();
        this.paramArray = new SymbolArray("");
        this.baseType = Symbol.Types.UNDEFINED;
        this.paramClass = Symbol.ParameterClass.VAL;
    }
}
