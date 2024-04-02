
package lib.attributes;


public class Attributes {
    // public Token t;



    public Attributes() {}
}

/* A simple calss is a mutable object. 
Example:

    --> Create a MutableWrapper class
        public class MutableWrapper {
        public Symbol.Types type;
        public Token id;
        public Boolean asignable;

        public MutableWrapper(Symbol.Types type, Token id, Boolean asignable) {
            this.type = type;
            this.id = id;
            this.asignable = asignable;
        }
    }

    --> Modify primario method to accept a MutableWrapper object
    Symbol.Types primario(MutableWrapper wrapper, Token param, Symbol.ParameterClass paramClass) : 
    {
        // Access the fields through the wrapper object
        wrapper.type = Symbol.Types.UNDEFINED;
        wrapper.asignable = false;
    }
    {
        // Rest of your code...
    }


    --> Create and pass the wrapper like this:
    MutableWrapper wrapper = new MutableWrapper(type, id, asignable);
    primario(wrapper, param, paramClass);
    // The changes to wrapper.type and wrapper.asignable inside the method will be reflected here


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

 */