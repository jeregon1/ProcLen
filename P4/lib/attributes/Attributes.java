/**
 * File:    Attributes.java
 * Author:  Jesús López Ansón
 *          Javier Sin Pelayo
 *
 *  Clase de atributos abstracta para implementarse y redefinirse en otras hijas
 *  para almacenar la información necesaria para el análisis semántico, y 
 *  generación de código.
*/

package lib.attributes;
import lib.tools.codeGeneration.*;
import lib.tools.codeGeneration.CodeBlock;

public abstract class Attributes implements Cloneable {
    public CodeBlock code; //para traducción a p-code
    public String hl_code; //hig_level, para traducción a otros lenguajes intermedios (adac, C++,...)

    public Attributes() {
        code = new CodeBlock();
        hl_code = "";
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
