
package lib.attributes;

import lib.symbolTable.*;
import java.util.ArrayList;

public class Attributes implements Cloneable {
    // public Token t;

    public CodeBlock code;

    public Attributes() {
        this.code = new CodeBlock();
    }
}
