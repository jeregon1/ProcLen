/**
 * File:    Attributes.java
 * Author:  Jesús López Ansón
 *          Javier Sin Pelayo
 *
 *  Clase de atributos abstracta para implementarse y redefinirse en otras hijas
 *  para almacenar la información necesaria para el análisis semántico.
*/

package lib.attributes;

public abstract class Attributes implements Cloneable {

    public Attributes() {}

    public Attributes clone() {
        try {
            return (Attributes) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
