
package lib.attributes;

import lib.symbolTable.*;
import traductor.*;

public class ExpressionAttrib extends Attributes {
    public Token param;
    public Boolean esAsignable;

    // Symbol.Types type;
    // boolean moreThanOne;
    // String errorMsg;

    public ExpressionAttrib() {
        this.param = null;
        this.esAsignable = null;
        // this.type = Symbol.Types.NONE;
        // this.moreThanOne = false;
        // this.errorMsg = "Las relaciones de una expresión lógica deben ser de tipo " + "boolean"/* tokenImage[tBOOL] */ + ".";
    }
}
