//*****************************************************************
// File:   SymbolTable.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   julio 2021
// Coms:   Atributos públicos para ahorrarnos el uso de getters y setters
//*****************************************************************

//la tabla de símbolos será un ArrayList de diccionarios (HashMap<String, Symbol>), manejada como
//una pila: se inserta y accede por la derecha
//Cada nuevo bloque se apilará, guardando los símbolos en el diccionario correspondiente
//El constructor ya genera el primer bloque, vacío inicialmente.

//https://quick-adviser.com/can-a-hashmap-have-multiple-values-for-same-key/
//HashMap doesn’t allow duplicate keys but allows duplicate values. That means A 
//single key can’t contain more than 1 value but more than 1 key can contain a single value.
//HashMap allows null key also but only once and multiple null values.
//https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

package lib.symbolTable;

import java.util.*;
import lib.symbolTable.exceptions.SymbolNotFoundException;
import lib.symbolTable.exceptions.AlreadyDefinedSymbolException;

public class SymbolTable {
	private final int ST_SIZE = 16; //hasta 16 niveles
    private final int HASH_SIZE = 1023; //buckets
    private ArrayList<HashMap<String, Symbol>> st;

    public int level; //nivel actual

    public SymbolTable() {
        st = new ArrayList<HashMap<String, Symbol>>(ST_SIZE);
        level = -1; //aún no hay ningún bloque introducido
        insertBlock();
    }
    
    //apila un nuevo bloque
    public void insertBlock() {
        st.add(new HashMap<String, Symbol>(HASH_SIZE));
        level++;
    }

    //elimina un bloque
    public void removeBlock() {
        st.remove(st.size()-1);
        level--;
    }

    //Si un símbolo con el mismo nombre está, excepción. 
    //Si no, se inserta
    public void insertSymbol(Symbol s) throws AlreadyDefinedSymbolException {
        // TODO: 🎃 Checkear que no sea una palabra reservada (clike lo hace)
        HashMap<String, Symbol> currentBlock = st.get(st.size()-1);
        String key = s.name.toLowerCase(); // case insensitive, pero se almacena el nombre original del símbolo
        if (currentBlock.containsKey(key)) { // ya está
            throw new AlreadyDefinedSymbolException();
        } else {
            s.nivel = level;
            currentBlock.put(key, s);
        }
    }

    //Si no está, excepción. Si está, devuelve su referencia
    public Symbol getSymbol (String name) throws SymbolNotFoundException {
    	Symbol result = findSymbol(name); 
        if (result == null) {
        	throw new SymbolNotFoundException();
        }
        return result; 
    }

    public Symbol getPreviousBlockSymbol (String name){
        if (level == 0) {
            return null;
        }
        return st.get(level - 1).get(name.toLowerCase());
    }

    // Devuelve la dirección del último símbolo en el nivel actual
    public long getLastSymbolAddress() {
        HashMap<String, Symbol> currentBlock = st.get(st.size()-1);
        if (currentBlock.size() == 0) {
            return 0;
        }
        return currentBlock.values().stream().mapToLong(s -> s.dir).max().getAsLong();
    }

    public SymbolProcedure getMainProcedure() {
        if (st.size() == 0) {
            return null;
         } else if (st.get(0).size() == 0) {
            return null;
        }
        // Se asume que ya se ha insertado el símbolo del procedimiento principal
        return (SymbolProcedure) st.get(0).values().toArray()[0];
    }

    // comprueba si está el símbolo 
    public boolean containsSymbol (String name) {
    	return findSymbol(name) != null; 
    }

    //para usar en "getSymbol" y "containsSymbol"
    private Symbol findSymbol (String name) {
        name = name.toLowerCase(); // case insensitive
    	for (int i = st.size()-1; i >= 0; i--) {
            if (st.get(i).containsKey(name)) {
                return st.get(i).get(name);
            }
        }
        return null; 
    }

    //devuelve la tabla como un string
    public String toString(String id) {
    	final String linea = "Cerrando el bloque de \'" + id + "\'\n";
    	final String sep = "------------------------------------------------\n";
    	StringBuilder builder = new StringBuilder(); 
        builder.append(linea); 
        builder.append(sep);
        String tabs = "";
        for (int i=0; i < st.size(); i++) {
            for (Map.Entry entry : st.get(i).entrySet()) {
				//crear secuencia de tabuladores
                tabs = "  ".repeat(i+1);
                builder.append(tabs); 
                builder.append(entry.getKey() + " = " + entry.getValue().toString());
                builder.append("\n"); 
            }
        }
        builder.append(sep);
        return builder.toString();
    }
}
