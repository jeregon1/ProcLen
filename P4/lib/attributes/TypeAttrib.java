package lib.attributes;

import lib.symbolTable.*;

public class TypeAttrib implements Attributes {
    SymbolArray paramArray; // creado y utilizado en la producción "parametro_formal" para rellenar los datos de un parámetro ARRAY
    Symbol.ParameterClass paramClass; // valor != de NONE en caso de ser un parámetro

    public TypeAttrib() {
        this.paramArray = null;
        this.paramClass = Symbol.ParameterClass.NONE;
    }
    
}