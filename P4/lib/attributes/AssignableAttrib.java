
package lib.attributes;

import lib.symbolTable.*;

// Utilizar en lugar del vector con 1 única componente
public class AssignableAttrib extends Attributes { 
    boolean isAssignable;

    public AssignableAttrib() {
        this.isAssignable = false;
    }
}
