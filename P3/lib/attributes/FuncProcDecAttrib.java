
package lib.attributes;

import lib.symbolTable.*;
import java.util.Map;
import java.util.LinkedHashMap;


public class FuncProcDecAttrib implements Attributes {
    public Map <Token,Symbol> params;
    // Mirar si se pueden añadir alguno más como "returnType", etc.

    public FuncProcDecAttrib() {
        this.params = new LinkedHashMap<Token,Symbol>();
    }
}