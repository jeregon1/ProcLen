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

	public SemanticFunctions(SymbolTable st) {
		errSem = new ErrorSemantico();
		this.st = st;
	}

	// -------------------------- PROCEDIMIENTO PRINCIPAL --------------------------------

	private String mainProcedureName = "";

	public void setMainProcedureName(String name) {
		if (mainProcedureName.equals("")) {
			mainProcedureName = name.toLowerCase(); // case insensitive
		}
		else {
			System.err.println("Error: El nombre de la función principal ya ha sido definido.");
		}
	}

	public String getMainProcedureName() {
		if (mainProcedureName.equals("")) {
			System.err.println("Error: No se ha definido el nombre de la función principal todavía.");
		}
		return mainProcedureName;
	}
	
	// -------------------------- FUNCIONES --------------------------------

	private boolean currentFunctionHasReturn = false; // indica si la función actual tiene return
	private SymbolFunction currentFunctionSymbol; // tipo de la función actual
	private static final List<Symbol.Types> FUNCTION_TYPES = Arrays.asList(
		Symbol.Types.INT,
		Symbol.Types.BOOL,
		Symbol.Types.CHAR
	);
	
	public void enterFunction(SymbolFunction functionSymbol) {
		if (inFunction()) {
			System.err.println("Error: No se puede llamar a este método dentro de una función.");
		} else if (!FUNCTION_TYPES.contains(functionSymbol.returnType)) {
			System.err.println("Error: Tipo de función no válido.");
		} else {
			currentFunctionSymbol = functionSymbol;
		}
	}

	public boolean inFunction() {
		return currentFunctionSymbol != null;
	}

	public Symbol.Types getCurrentFunctionType() {
		if (currentFunctionSymbol != null)
			return currentFunctionSymbol.returnType;
		else {
			System.err.println("Error: No se puede llamar a este método sin estar en una función.");
			return Symbol.Types.UNDEFINED;
		}
	}

	public void inst_return(Token t, Symbol.Types returnType) {
		if (!inFunction()) {
			error(t, "Error: No puede haber instrucciones return en un procedimiento.");
		} else {
			currentFunctionHasReturn = true;
			if (returnType != currentFunctionSymbol.returnType) {
				error(t, "El tipo de retorno " + returnType + " no coincide con el tipo " + currentFunctionSymbol.returnType + " de la función '" + currentFunctionSymbol.name + "'.");
			}
		}
	}

	public void exitFunction(Token t) {
		if (!inFunction()) {
			System.err.println("Error: No se puede llamar a este método sin estar en una función.");
			return;
		}

		if (!currentFunctionHasReturn) {
			error(t, "La función '" + currentFunctionSymbol.name + "' no tiene instrucción return.");
		}

		currentFunctionHasReturn = false;
		currentFunctionSymbol = null;
	}

	// -------------------------- ERRORES SEMÁNTICOS --------------------------------

	private ErrorSemantico errSem; //clase común de errores semánticos

	public void error(Token token, String msg) {
		errSem.print(token, msg);
	}

	public boolean hayErrores() {
		return errSem.hayError();
	}

	public int getNumErrores() {
		return errSem.getNumErrores();
	}

	// -------------------------- TABLA DE SÍMBOLOS --------------------------------

	private SymbolTable st; //tabla de símbolos

	public void insertSymbol(Token id, Symbol s) {
		try {
			st.insertSymbol(s);
		}
		catch (AlreadyDefinedSymbolException e) {
			error(id, "El símbolo '" + id.image + "' ya está definido.");
		}
	}

	public boolean isSymbolDefined(Token id) {
		try {
			st.getSymbol(id.image);
			return true;
		}
		catch (SymbolNotFoundException e) {
			error(id, "El símbolo '" + id.image + "' no está definido.");
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

	public SymbolProcedure getMainProcedureSymbol() {
		return st.getMainProcedureSymbol();
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
			error(id, "El símbolo '" + id.image + "' no es un array.");
			return Symbol.Types.UNDEFINED;
		}
	}
}
