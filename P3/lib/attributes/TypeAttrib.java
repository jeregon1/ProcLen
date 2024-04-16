package lib.attributes;

import lib.symbolTable.*;

public class TypeAttrib implements Attributes {
    List<Token> t; // lista de identificadores del tipo de variable
    Symbol.Types type; // tipo de dato
    SymbolArray paramArray; // creado y utilizado en la producción "parametro_formal" para rellenar los datos de un parámetro ARRAY
    Symbol.ParameterClass paramClass; // valor != de NONE en caso de ser un parámetro

    public TypeAttrib() {
        this.t = new ArrayList<Token>();
        this.paramArray = null;
        this.paramClass = Symbol.ParameterClass.NONE;
    }
    
    public clone(TypeAttrib t) {
        this.t = t.t;
        this.type = t.type;
        this.paramArray = t.paramArray;
        this.paramClass = t.paramClass;
    }
}