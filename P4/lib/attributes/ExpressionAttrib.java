
package lib.attributes;

import lib.symbolTable.*;
import traductor.*;

public class ExpressionAttrib extends Attributes {
    public Token param;
    public Boolean esAsignable;
    public Symbol.Types type;

    // boolean moreThanOne;
    // String errorMsg;

    public ExpressionAttrib() {
        this.param = new Token(0);
        this.esAsignable = false;
        this.type = null;
        // this.moreThanOne = false;
        // this.errorMsg = "Las relaciones de una expresión lógica deben ser de tipo " + "boolean"/* tokenImage[tBOOL] */ + ".";
    }

    public void clone(ExpressionAttrib e) {
        this.esAsignable = e.esAsignable;
        this.type = e.type;
    }
}
