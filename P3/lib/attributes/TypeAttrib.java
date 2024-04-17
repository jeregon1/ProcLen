package lib.attributes;

import lib.symbolTable.*;
import traductor.*;
import java.util.List;
import java.util.ArrayList;

public class TypeAttrib extends Attributes {
    public List<Token> t; // lista de identificadores del tipo de variable
    public SymbolArray paramArray; // creado y utilizado en la producción "parametro_formal" para rellenar los datos de un parámetro ARRAY
    public Symbol.ParameterClass paramClass; // valor != de NONE en caso de ser un parámetro
    public Symbol.Types type; // tipo de dato

    public TypeAttrib() {
        this.t = new ArrayList<Token>();
        this.paramArray = null;
        this.paramClass = Symbol.ParameterClass.NONE;
    }
    
    public void clone(TypeAttrib t) {
        this.t = t.t;
        this.type = t.type;
        this.paramArray = t.paramArray;
        this.paramClass = t.paramClass;
    }
}