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
import traductor.alikeConstants;
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

	// -------------------------- TIPOS --------------------------------

	public void emptyArrayRange(Token t, int min, int max) {
		if (min > max) {
			error(t, "Los vectores deben tener un rango no vacío de enteros, se ha encontrado (" + min + ".." + max + ")");
		}
	}

	public void isProcedureOrFunction(Token t, Symbol s){
		if (s.type == Symbol.Types.PROCEDURE || s.type == Symbol.Types.FUNCTION) {
			error(t, "No se puede leer un procedimiento o función.");
		}
	}

	public void readingArrayChecks(Token t, Symbol s, boolean access){
		if (s.type == Symbol.Types.ARRAY) {
			// si es array, comprobar que se ha accedido a un elemento y no al array entero
			if (!access) {
				error(t, "Se debe acceder a un elemento del array '" + t.image + "'.");
			}

			// si es array, comprobar que el tipo del array es INT o CHAR
			SymbolArray array = (SymbolArray) s;
			if (array.baseType != Symbol.Types.INT && array.baseType != Symbol.Types.CHAR) {
				error(t, "El array '" + t.image + "' debe ser de tipo " + "integer"/* tokenImage[tINT] */ + " o " + "character"/* tokenImage[tCHAR] */ + ".");
			}
		} else if (access) { // que no se acceda a una variable simple, procedimiento o función como a un array 
			error(t, "No se puede acceder a un elemento del símbolo '" + t.image + "' por no ser de tipo " + "array"/* tokenImage[tARRAY] */ + " sino " + s.type + ".");
		}		
	}

	public void isBooleanBeingRead(Token t, Symbol s){
		if (s.type == Symbol.Types.BOOL) { // Comprobar que no se esté leyendo un booleano
			error(t, "No se puede leer una variable de tipo " + "boolean"/* tokenImage[tBOOL] */ + ".");
		}
	}

	public void indexIsInteger(Token t, Symbol.Types type){
		if (type != Symbol.Types.INT) { // Comprobar que el índice es de tipo INT
			error(t, "El índice de un array debe ser de tipo " + "integer"/* tokenImage[tINT] */ + ".");
		}
	}

	public void assigningArrayChecks(Token t, Symbol s, Symbol.Types type, boolean access) {
		if (s.type == Symbol.Types.ARRAY) {
			if (!access) { // Si id es array, se debe acceder a un elemento (el array no es asignable pero sus elementos sí lo son) 
				error(t, "Los arrays no son asignables, se debe acceder a un elemento de '" + t.image + "'.");
			}
			Symbol.Types baseType = ((SymbolArray) s).baseType;
			if (baseType != type) { // Comprobar que el tipo de la expresión coincide con el tipo base del array
				error(t, "El tipo " + type + " de la expresión no coincide con el tipo " + baseType + " base del array '" + t.image + "'.");
			}
		} else if (access) { // no puede accederse a una variable no array
			error(t, "No se puede acceder a un elemento del símbolo '" + t.image + "' por ser de tipo " + "array"/* tokenImage[tARRAY] */ + " y no " + s.type + ".");
		}
	}

	public void assignableTypeChecks(Token t, Symbol s, Symbol.Types type) {
		if (s.type == Symbol.Types.PROCEDURE || s.type == Symbol.Types.FUNCTION) {
			error(t, "Los procedimientos y funciones no son asignables.");
		} 
		else if (s.type != Symbol.Types.ARRAY && s.type != type) { // Asignable y expresión deben ser del mismo tipo
			error(t, "El tipo " + type + " de la expresión no coincide con el tipo " + s.type + " de '" + t.image + "'.");
		}
	}

	public void procedureChecks(Token t, Symbol s) {
		if (s.type != Symbol.Types.PROCEDURE) { // Comprobar que el símbolo es un procedimiento
			error(t, "Solo se pueden invocar procedimientos.");
		} else if (s.name.toLowerCase().equals(getMainProcedureName())) { // Checkear que no sea el procedimiento principal del programa
			error(t, "No se puede invocar el procedimiento principal del programa.");
		}
	}

	public void ifChecks(Token t, Symbol.Types type, String errorMsg) {
		if (type != Symbol.Types.BOOL) { // Comprobar que la guarda es de tipo BOOL
			error(t, errorMsg);
		}
	}

	public void whileChecks(Token t, Symbol.Types type) {
		if (type != Symbol.Types.BOOL) { // Comprobar que la guarda es de tipo BOOL
			error(t, "La guarda de un bucle " + "while"/* tokenImage[tWHILE] */ + " debe ser de tipo " + "boolean"/* tokenImage[tBOOL] */ + ".");
		}
	}
}

