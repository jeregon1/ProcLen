
package lib.attributes;

import lib.symbolTable.*;
import traductor.*;
import java.util.Map;
import java.util.LinkedHashMap;


public class FuncProcDecAttrib extends Attributes {
    public Token id;
    public Map <Token,Symbol> params;
    public Symbol.Types returnType; // Utilizado solo en caso de función

    public FuncProcDecAttrib() {
        this.id = null;
        this.params = new LinkedHashMap<Token,Symbol>();
        this.returnType = Symbol.Types.UNDEFINED;
    }
}