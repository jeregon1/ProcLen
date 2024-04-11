//*****************************************************************
// File:   Attributes.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   enero 2022
//         Clase única para almacenar los atributos que pueden aparecer en el traductor de adac
//         Se hace como clase plana, por simplicidad. Los atributos que se pueden almacenar
//         se autoexplican con el nombre
//*****************************************************************

package lib.attributes;
import lib.symbolTable.*;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import lib.tools.codeGeneration.CodeBlock;

public class Attributes implements Cloneable {

    public Symbol.Types type;
    public Symbol.Types baseType;
    public Symbol.ParameterClass parClass;

    public int valInt;
    public boolean valBool;
    public char valChar;
    public String valString;

    public CodeBlock code;
    public String name;
    public ArrayList<Symbol> parList;
    public ArrayList<Attributes> lExps;
    public boolean isVar;
    public boolean isCompVector;
    public boolean isConst;
    public int arraySize;
    public int nivel;
    public int dir;

    public int beginLine;
    public int beginColumn;
    
    public Attributes() {
        this.code = new CodeBlock();
        this.lExps = new ArrayList<>();
    }

    public Attributes clone() {
    	try {
    		return (Attributes) super.clone();
    	}
    	catch (CloneNotSupportedException e) {
    		return null; 
    	}
    }

    public String toString() {
        return
            "type = " + type + "\n" +
            "parClass = " + parClass + "\n";
            //COMPLETAR
    }
    
}
