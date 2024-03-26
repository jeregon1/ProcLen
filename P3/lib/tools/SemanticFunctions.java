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

	private Queue<Symbol.Types> functionReturnTypes = new LinkedList<>();

	public SemanticFunctions(SymbolTable st) {
		errSem = new ErrorSemantico();
		this.st = st;
	}

	// -------------------------- FUNCIONES --------------------------------
	public void enterFunction(Symbol.Types returnType) {
		inFunction = true;
		functionReturnTypes.add(returnType);
	}

	public boolean inFunction() {
		return inFunction;
	}

	public void exitFunction() {
		inFunction = false;
		functionReturnTypes.poll();
	}

	public Symbol.Types getCurrentFunctionReturnType() {
		return functionReturnTypes.peek();
	}

	// -------------------------- ERRORES SEMÁNTICOS --------------------------------

	public void error(Token token, String msg) {
		errSem.print(token, msg);
	}

	public boolean hayErrores() {
		return errSem.hayError();
	}

	// -------------------------- TABLA DE SÍMBOLOS --------------------------------

	public void insertSymbol(Symbol s) {
		try {
			st.insertSymbol(s);
		}
		catch (AlreadyDefinedSymbolException e) {
			System.err.println("ERROR: El símbolo " + s.name + " ya está definido.");
		}
	}

	public Symbol getSymbol(String name) {
		try {
			return st.getSymbol(name);
		}
		catch (SymbolNotFoundException e) {
			System.err.println("ERROR: El símbolo " + name + " no está definido.");
			return null;
		}
	}

	public Symbol.Types getSymbolType(String name) {
		try {
			return st.getSymbol(name).type;
		}
		catch (SymbolNotFoundException e) {
			System.err.println("ERROR: El símbolo " + name + " no está definido.");
			return Symbol.Types.UNDEFINED;
		}
	}

	public Symbol.Types getArrayBaseType(String name) {
		try {
			Symbol array = st.getSymbol(name);
			if (array instanceof SymbolArray) {
				return ((SymbolArray) array).baseType;
			}
			else {
				System.err.println("ERROR: El símbolo " + name + " no es un array.");
				return Symbol.Types.UNDEFINED;
			}
		}
		catch (SymbolNotFoundException e) {
			System.err.println("ERROR: El símbolo " + name + " no está definido.");
			return Symbol.Types.UNDEFINED;
		}
	}
}
