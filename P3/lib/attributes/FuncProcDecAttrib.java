
package lib.attributes;

import lib.symbolTable.*;
import java.util.Map;
import java.util.LinkedHashMap;


public class FuncProcDecAttrib implements Attributes {
    Token id;
    Map <Token,Symbol> params;
    Symbol.Types returnType; // Utilizado solo en caso de función
    SymbolFunction functionSymbol; // Utilizado solo en caso de función
    // Mirar si se pueden añadir alguno más como "returnType", etc.

    public FuncProcDecAttrib() {
        this.id = null;
        this.params = new LinkedHashMap<Token,Symbol>();
        this.returnType = Symbol.Types.NONE;
        this.functionSymbol = null;
    }
}