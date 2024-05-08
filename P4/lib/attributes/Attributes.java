/**
 * File:    Attributes.java
 * Author:  Jesús López Ansón
 *          Javier Sin Pelayo
 *
 *  Clase de atributos abstracta para implementarse y redefinirse en otras hijas
 *  para almacenar la información necesaria para el análisis semántico.
*/

package lib.attributes;
import lib.tools.codeGeneration.*;
import lib.tools.codeGeneration.CodeBlock;

public class Attributes implements Cloneable {
    public CodeBlock code; //para traducción a p-code

    public Attributes() {
        code = new CodeBlock();
    }

    public Attributes clone() {
        try {
            return (Attributes) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
