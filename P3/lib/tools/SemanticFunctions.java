//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    SemanticFunctions.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2021-2022
//*****************************************************************

package lib.tools.SemanticFunctions;

import java.util.*;
import traductor.Token;
// import lib.attributes.*;
import lib.symbolTable.*;
import lib.symbolTable.exceptions.*;
import lib.errores.*;

public class SemanticFunctions {
	private ErrorSemantico errSem; //clase común de errores semánticos
	private SymbolTable st; //tabla de símbolos
	private boolean inFunction = false; //indica si estamos dentro de una función

	private Queue<String> functions = new LinkedList<>();

	// declaramos la lista de tipos asignables
	private final List<Symbol.Types> assignableTypes = Arrays.asList(
		Symbol.Types.INT,
		Symbol.Types.CHAR,
		Symbol.Types.BOOL
	);

	public SemanticFunctions(SymbolTable st) {
		errSem = new ErrorSemantico();
		this.st = st;
	}

	// public void var_array(){

	// }	

	// -------------------------- FUNCIONES --------------------------------
	
	public void enterFunction(String functionName) {
		inFunction = true;
		functions.add(functionName);
	}

	public boolean inFunction() {
		return inFunction;
	}

	public void exitFunction() {
		inFunction = false;
		functions.poll();
	}

	public SymbolFunction getCurrentFunctionSymbol() {
		try {
			Symbol s = st.getPreviousBlockSymbol(functions.peek()); // .peek() devuelve el elemento en la cima de la pila sin eliminarlo
			// problema: se puede encontrar antes un símbolo de este bloque con el mismo nombre que no sea la función
			if (s instanceof SymbolFunction) {
				return (SymbolFunction) s;
			}
			else {
				System.err.println("Error: El símbolo " + functions.peek() + " no es una función.");
				return null;
			}
		}
		catch (SymbolNotFoundException e) {
			System.err.println("Error: La función " + functions.peek() + " no está definida.");
			return null;
		}
	}

	// -------------------------- ERRORES SEMÁNTICOS --------------------------------

	public void error(Token token, String msg) {
		errSem.print(token, msg);
	}

	public boolean hayErrores() {
		return errSem.hayError();
	}

	// -------------------------- TABLA DE SÍMBOLOS --------------------------------

	public void insertSymbol(Token t, Symbol s) {
		try {
			st.insertSymbol(s);
		}
		catch (AlreadyDefinedSymbolException e) {
			this.error(t, "El símbolo " + s.name + " ya está definido.");
		}
	}

	public boolean isSymbolDefined(Token id) {
		try {
			st.getSymbol(id.image);
			return true;
		}
		catch (SymbolNotFoundException e) {
			this.error(id, "El símbolo " + id.image + " no está definido.");
			return false;
		}
	}

	public Symbol getSymbol(Token id) {
		if (isSymbolDefined(id)) {
			return st.getSymbol(id.image);
		} else {
			return null;
		}
	}

	public Symbol.Types getSymbolType(Token id) {
		Symbol s = this.getSymbol(id);
		if (s == null) {
			return Symbol.Types.UNDEFINED;
		}
		else {
			return s.type;
		}
	}

	public Symbol.Types getArrayBaseType(Token id) {

		Symbol s = this.getSymbol(id);
		if (s == null) {
			return Symbol.Types.UNDEFINED;
		}
		else if (s instanceof SymbolArray) {
			return ((SymbolArray) s).baseType;
		}
		else {
			this.error(id, "El símbolo " + id.image + " no es un array.");
			return Symbol.Types.UNDEFINED;
		}
	}
}
