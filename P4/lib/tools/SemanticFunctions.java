//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    SemanticFunctions.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2023-2024
//*****************************************************************

package lib.tools.SemanticFunctions;

import java.util.*;
import traductor.Token;
import traductor.alike_4Constants;
import lib.symbolTable.*;
import lib.symbolTable.exceptions.*;
import lib.errores.*;

import lib.tools.codeGeneration.*;
import lib.attributes.Attributes;
import lib.attributes.ExpressionAttrib;

import java.util.Map;

public class SemanticFunctions {

	private SymbolTable st; //tabla de símbolos
	private ErrorSemantico errSem; //clase común de errores semánticos

	public SemanticFunctions() {
		st     = new SymbolTable();
		errSem = new ErrorSemantico();
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

	public void insertBlock() {
		st.insertBlock();
		CGUtils.usedMemorySpaces[st.level] = 3;
	}

	public void removeBlock() {
		// Liberar espacio de memoria
		CGUtils.usedMemorySpaces[st.level] = 0;
		st.removeBlock();
	}

	public void printSymbolTable(String id_image) {
		System.err.println(st.toString(id_image));
	}

	public int getLastSymbolAddress() {
		return CGUtils.usedMemorySpaces[st.level];
	}

	public String getLabelFromSymbol(Token id) {
		Symbol s = getSymbol(id);
		if (s == null) return null;
		if (s instanceof SymbolFunction) {
			return ((SymbolFunction) s).label;
		} else if (s instanceof SymbolProcedure) {
			return ((SymbolProcedure) s).label;
		} else {
			return null;
		}
	}

	public int getCurrentLevel() {
		return st.level;
	}

	public void insertSymbol(Token id, Symbol s) {
		try {
			// Función o procedimiento, donde se asigna el label como dirección de memoria
			switch (s.type) {
				case FUNCTION: 
				case PROCEDURE: break;
				case ARRAY: 
					if (s.parClass != Symbol.ParameterClass.REF) {

						s.dir = CGUtils.usedMemorySpaces[st.level];
						CGUtils.usedMemorySpaces[st.level] += ((SymbolArray) s).getNumComp();
						break;
					}
				default:
 					s.dir = CGUtils.usedMemorySpaces[st.level];
					CGUtils.usedMemorySpaces[st.level]++; 
			}

			st.insertSymbol(s);
		}
		catch (AlreadyDefinedSymbolException e) {
			error(id, "El símbolo '" + id.image + "' ya está definido.");
		}
	}

	public void insertFuncProc(Token id, Symbol s, Map<Token, Symbol> params) {
		if (s instanceof SymbolFunction) {
			s = (SymbolFunction) s;
		} else if (s instanceof SymbolProcedure) {
			s = (SymbolProcedure) s;

		} else {
			System.err.println("Error: No se puede insertar un símbolo que no sea una función o procedimiento.");
		}

		this.insertSymbol(id, s);
		this.insertBlock();

		// Se insertan params con los tokens en la tabla de símbolos DESPUÉS de crear un nuevo bloque
		for (Map.Entry<Token, Symbol> entry : params.entrySet()) {
			this.insertSymbol(entry.getKey() ,entry.getValue());
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

	// -------------------- GENERACIÓN CÓDIGO --------------------------

	public PCodeInstruction.OpCode operatorOpCode(Token op) {
		switch (op.kind) {
			case alike_4Constants.tEQ:   return PCodeInstruction.OpCode.EQ;
			case alike_4Constants.tLT:   return PCodeInstruction.OpCode.LT;
			case alike_4Constants.tGT:   return PCodeInstruction.OpCode.GT;
			case alike_4Constants.tLE:   return PCodeInstruction.OpCode.LTE;
			case alike_4Constants.tGE:   return PCodeInstruction.OpCode.GTE;
			case alike_4Constants.tNEQ:  return PCodeInstruction.OpCode.NEQ;
			case alike_4Constants.tAND:  return PCodeInstruction.OpCode.AND;
			case alike_4Constants.tOR:   return PCodeInstruction.OpCode.OR;
			case alike_4Constants.tPLUS: return PCodeInstruction.OpCode.PLUS;
			case alike_4Constants.tMINUS:return PCodeInstruction.OpCode.SBT;
			case alike_4Constants.tMULT: return PCodeInstruction.OpCode.TMS;
			case alike_4Constants.tDIV:  return PCodeInstruction.OpCode.DIV;
			case alike_4Constants.tMOD:  return PCodeInstruction.OpCode.MOD;
			default: return null;
		}
	}

	public CodeBlock readParamsCode(List<Symbol> params) {
		CodeBlock code = new CodeBlock();

		// Calcular el espacio necesario para los parámetros
		int space = 0;
		for (Symbol s : params) {
			if (s instanceof SymbolArray && s.parClass == Symbol.ParameterClass.VAL) {
				space += ((SymbolArray) s).getNumComp();
			} else {
				space++;
			}
		}

		// Desapilado de parámetros en orden inverso
		for (int i = space; i >= 1; i--) {
			// Como los parámetros están en el mismo bloque, tienes que bajar 0 (level) bloques para obtener su valor
			code.addInst(PCodeInstruction.OpCode.SRF, 0, i+2); 
			code.addInst(PCodeInstruction.OpCode.ASGI);
		}

		return code;
	}

	public CodeBlock arrayAccessCode (Attributes expAt, Symbol symbol) {
		CodeBlock code = new CodeBlock();

		// código para acceder al array
		// dir a calcular: @base + (indice_acceso - lim_inf) * tam_elemento (1, así que no hace falta multiplicar)
		code.addBlock(expAt.code); // código de la expresión del índice de acceso
		
		int lim_inf = ((SymbolArray) symbol).minInd;
		code.addInst(PCodeInstruction.OpCode.STC, lim_inf);
		if (lim_inf < 0) // si es negativo, añadir instrucción de negación
			code.addInst(PCodeInstruction.OpCode.NGI);
		code.addInst(PCodeInstruction.OpCode.SBT); // indice_acceso - lim_inf

		// SRF @base
		code.addInst(PCodeInstruction.OpCode.SRF, this.getCurrentLevel() - symbol.nivel, (int) symbol.dir);
		// Si es un parámetro por referencia, se desreferencia
		if (symbol.parClass == Symbol.ParameterClass.REF)
			code.addInst(PCodeInstruction.OpCode.DRF);

		code.addInst(PCodeInstruction.OpCode.PLUS); // @base + (indice_acceso - lim_inf)
		
		return code;
	}

	public CodeBlock pushParametersCode (List<ExpressionAttrib> expAt_list, List<Symbol> parList) {
		CodeBlock code = new CodeBlock();
		
		// iterar sobre los bloques de código de los argumentos y la lista de params y añadirlos al bloque de código de la invocación
		for (int i = 0; i < expAt_list.size(); i++) {
			ExpressionAttrib expAt = expAt_list.get(i);
			Symbol par = parList.get(i);
			
			if (par.type == Symbol.Types.ARRAY) {
				Symbol arg = this.getSymbol(expAt.param);

				if (par.parClass == Symbol.ParameterClass.REF) {

					// Si es un parámetro de array por referencia, se añade código para empujar la dirección del array
					code.addInst(PCodeInstruction.OpCode.SRF, this.getCurrentLevel() - arg.nivel, (int) arg.dir);
					code.addInst(PCodeInstruction.OpCode.DRF); // Esta instrucción se quita después
					if (arg.parClass == Symbol.ParameterClass.REF) 
						code.addInst(PCodeInstruction.OpCode.DRF); // Si el argumento que estamos pasando como parámetro es por referencia, se desreferencia

				} else { // par.class == VAL o UNDEF
					if (arg.parClass == Symbol.ParameterClass.REF) {

						// acceder a todos los componentes y pasarlos por valor
						for (int j = 0; j < ((SymbolArray) par).getNumComp(); j++) {
							code.addInst(PCodeInstruction.OpCode.SRF, this.getCurrentLevel() - arg.nivel, (int) arg.dir); // @@base
							code.addInst(PCodeInstruction.OpCode.DRF); // @base
							code.addInst(PCodeInstruction.OpCode.STC, j); 
							code.addInst(PCodeInstruction.OpCode.PLUS); // @base + j
							code.addInst(PCodeInstruction.OpCode.DRF); // array[j]
						}
					} else { // arg.class == VAL o UNDEF
						// Si es un parámetro de array por valor, se añade código para empujar todos los elementos del array
						for (int j = 0; j < ((SymbolArray) par).getNumComp(); j++) {
							code.addInst(PCodeInstruction.OpCode.SRF, this.getCurrentLevel() - arg.nivel, (int) arg.dir + j);
							code.addInst(PCodeInstruction.OpCode.DRF);
						}
					}
				}
			}

			// Si es para un parámetro por referencia, se quita una instrucción DRF para quedarse con la dirección
			if (par.parClass == Symbol.ParameterClass.REF)
				code.removeLastInst();
		}

		return code;
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
		/* Comprobaciones relacionadas con arrays:
		- Si es array: 
			- comprobar que se ha accedido a un elemento y no al array entero
			- comprobar que el tipo del array es INT o CHAR
		- Si no: que no se acceda a una variable simple, procedimiento o función como a un array
		*/
		if (s instanceof SymbolArray) {
			// si es array, comprobar que se ha accedido a un elemento y no al array entero
			if (!access) {
				error(t, "Se debe acceder a un elemento del array '" + t.image + "'.");
			}

			// si es array, comprobar que el tipo del array es INT o CHAR
			SymbolArray array = (SymbolArray) s;
			if (array.baseType != Symbol.Types.INT && array.baseType != Symbol.Types.CHAR) {
				error(t, "El tipo base del array '" + t.image + "' debe ser de tipo integer o character, pero es " + array.baseType + ".");
			}
		} else if (access) { // que no se acceda a una variable simple, procedimiento o función como a un array 
			error(t, "No se puede acceder a un elemento del símbolo '" + t.image + "' por ser de tipo " + s.type + " y no array.");
		}		
	}

	public void isBooleanBeingRead(Token t, Symbol s){
		if (s.type == Symbol.Types.BOOL) { // Comprobar que no se esté leyendo un booleano
			error(t, "No se puede leer una variable de tipo " + "boolean" + ".");
		}
	}

	public void indexIsInteger(Token t, Symbol.Types type){
		if (type != Symbol.Types.INT) { // Comprobar que el índice es de tipo INT
			error(t, "El índice de un array debe ser de tipo " + "integer" + ".");
		}
	}

	public void assigningArrayChecks(Token t, Symbol s, Symbol.Types type, boolean access) {
		/* Comprobaciones relacionadas con arrays:
		- Si es array:
			- se debe acceder a un elemento (el array no es asignable pero sus elementos sí lo son)
			- comprobar que el tipo de la expresión coincide con el tipo base del array
		- Si no: no puede accederse a una variable no array
		*/
		if (s instanceof SymbolArray) {
			if (!access) { // Si id es array, se debe acceder a un elemento (el array no es asignable pero sus elementos sí lo son) 
				error(t, "Los arrays no son asignables, se debe acceder a un elemento de '" + t.image + "'.");
			}
			Symbol.Types baseType = ((SymbolArray) s).baseType;
			if (baseType != type) { // Comprobar que el tipo de la expresión coincide con el tipo base del array
				error(t, "El tipo '" + type + "' de la expresión no coincide con el tipo '" + baseType + "' base del array '" + t.image + "'.");
			}
		} else if (access) { // no puede accederse a una variable no array
			error(t, "No se puede acceder a un elemento del símbolo '" + t.image + "' por ser de tipo " + s.type + " y no array.");
		}
	}

	public void assignableTypeChecks(Token t, Symbol s, Symbol.Types type) {
		/* Comprobaciones sobre los tipos de los asignables:
		- Si es un procedimiento o función, error
		- Asignable y expresión deben ser del mismo tipo
		*/
		if (s.type == Symbol.Types.PROCEDURE || s.type == Symbol.Types.FUNCTION) {
			error(t, "Los procedimientos y funciones no son asignables.");
		} 
		else if (s.type != Symbol.Types.ARRAY && s.type != type) { // Asignable y expresión deben ser del mismo tipo
			error(t, "El tipo " + type + " de la expresión no coincide con el tipo " + s.type + " de '" + t.image + "'.");
		}
	}

	public void procedureChecks(Token t, Symbol s) {
		if (s.type != Symbol.Types.PROCEDURE) { // Comprobar que el símbolo es un procedimiento
			error(t, "Solo se pueden invocar procedimientos como instrucciones.");
		} else if (s.name.toLowerCase().equals(getMainProcedureName()) && st.getNumberOfProcedures(s.name) == 1) {
			// Checkear que no sea el procedimiento principal del programa
			// Lo que sí se permite es un procedimiento con el mismo nombre que el principal pero definido en otro nivel
			// Si hay más de un símbolo visible con el mismo nombre, es que hay otro procedimiento con el mismo nombre en otro nivel
			error(t, "No se puede invocar el procedimiento principal del programa.");
		}
	}

	public void ifChecks(Token t, Symbol.Types type) {
		if (type != Symbol.Types.BOOL) { // Comprobar que la guarda es de tipo BOOL
			error(t, "La guarda de una sentencia 'if' o 'elsif' debe ser de tipo 'boolean'.");
		}
	}

	public void whileChecks(Token t, Symbol.Types type) {
		if (type != Symbol.Types.BOOL) { // Comprobar que la guarda es de tipo BOOL
			error(t, "La guarda de un bucle 'while'" + "' debe ser de tipo " + "boolean" + ".");
		}
	}

	public void signInExpressionCheck(Token t, Symbol.Types type, boolean sign) {
		if (sign && (type != Symbol.Types.INT)) { // Si hay signo, la expresión debe ser de tipo INT
			error(t, "Los signos + y - solo se puede usar con expresiones de tipo " + "integer" + ", se encontró " + type + ".");
		}
	}

	public void moreThanOneExpressionCheck(Token t, Symbol.Types type) {
		if (type != Symbol.Types.INT) {
			error(t, "Los términos de una suma o resta deben ser de tipo " + "'integer'" + ", se encontró '" + type + "'.");
		}
	}

	public void multiplicativeFactorCheck(Token t, Symbol.Types type) {
		if (type != Symbol.Types.INT) {
				error(t, "Los factores de una multiplicación, división y módulo deben ser de tipo " + "integer" + ", se encontró " + type + ".");
		}
	}

	public void notOperatorCheck(Token t, Symbol.Types type) {
		if (type != Symbol.Types.BOOL) {
				error(t, "El operador " + "not" + 
						" solo se puede usar con variables de tipo " + "boolean" + ".");
		}
	}

	public void int2charCheck(Token t, Symbol.Types type) {
		if (type != Symbol.Types.INT) error(t, "La expresión debe ser de tipo " + "integer" + ".");
	}

	public void char2intCheck(Token t, Symbol.Types type) {
		if (type != Symbol.Types.CHAR) error(t, "La expresión debe ser de tipo " + "character" + ".");
	}

	public void procedureInPrimaryError(Token t, String wrongType) {
		error(t, "No se puede invocar un procedimiento en una expresión como a una " + wrongType + ".");
	}

	public void funcProcNoParametersCheck(Token t, Symbol func_proc) {
		if (func_proc instanceof SymbolFunction) {

			int paramsListSize = ((SymbolFunction) func_proc).parList.size();

			if (paramsListSize > 0) {
				error(t, "La función '" + t.image + "' debe invocarse con " + paramsListSize + " argumentos.");
			}
		} else if (func_proc instanceof SymbolProcedure) {

			int paramsListSize = ((SymbolProcedure) func_proc).parList.size();

			if (paramsListSize > 0) {
				error(t, "El procedimiento '" + t.image + "' debe invocarse con " + paramsListSize + " argumentos.");
			}
		}
		else {
			error(t, "El símbolo '" + t.image + "' no es una función o procedimiento.");
		}
	}
	
	public void arrayAccessCheck(Token t, Token param) {
		if (param == null) error(t, "En una expresión debe accederse a un elemento del array '" + t.image + "'.");
	}

	public boolean checkNumberOfArguments(Token id, Integer paramSize, Integer argsSize, Symbol symbol) {
		if (argsSize != paramSize) {

			String msg = (symbol.type == Symbol.Types.FUNCTION) ? "de la función" : "del procedimiento";
			error(id, "El número de argumentos no coincide con el número de parámetros " + msg + " '" + id.image + "'");
			return true;
		}
		return false;
	}

	public void arrayInListOfExpressionCheck(Token id, List<Symbol.Types> types) {
		/* Comprobaciones sobre el array
		- El acceso a un array debe tener un único índice
		- El índice de un array debe ser de tipo integer
		*/ 
		if (types.size() != 1) {
			error(id, "El acceso a un array debe tener un único índice.");
		}
		if (types.get(0) != Symbol.Types.INT) {
			error(id, "El índice de un array debe ser de tipo " + "integer" + ".");
		}
	}

	public void checkArgumentTypes(Token id, List<Symbol.Types> types, List<Symbol> parList, Map<Token, Boolean> args, Symbol symbol) {
		List<Token> tokenArgs = new ArrayList<>(args.keySet());
		List<Boolean> assignables = new ArrayList<>(args.values());
		String msg = (symbol.type == Symbol.Types.FUNCTION) ? "de la función" : "del procedimiento";
		msg += " '" + id.image + "'";

		for (int i = 0; i < types.size(); i++) {
			if (types.get(i) == Symbol.Types.UNDEFINED) {
				error(id, "Error en la expresión del argumento nº " + (i + 1) + " " + msg);
				continue; // Si hay un error en la expresión, no comprobar más
			}
			if (types.get(i) != parList.get(i).type) {
				error(id, "El tipo " + types.get(i) + " del argumento nº " + (i + 1) + " no coincide con el tipo " + parList.get(i).type + " del parámetro " + msg);
				continue;
			}

			Token arg = tokenArgs.get(i);

			if (parList.get(i) instanceof SymbolArray) {
				// Si el parámetro debe ser un array, da igual si es por valor o referencia ya que el argumento debe ser un array entero
				SymbolArray paramArray = (SymbolArray) parList.get(i);

				// Si el argumento es un array, comprobar que el tipo base y el rango de índices coinciden (del parámetro y argumento)
				SymbolArray argArray = (SymbolArray) getSymbol(arg);
				
				if (argArray.baseType != paramArray.baseType) {
					error(id, "El tipo base del vector '" + arg + "' no coincide con el tipo base del parámetro " + (i + 1) + " " + msg);
				}
				if (argArray.minInd != paramArray.minInd || argArray.maxInd != paramArray.maxInd) {
					error(id, "El rango de índices del vector '" + arg  + "' no coincide con el rango de índices del parámetro " + (i + 1) + " " + msg);
				}
			} else {
				// Si el parámetro es simple y por valor, no hay que comprobar nada más
				// Si el parámetro es simple por referencia, además el argumento debe ser un asignable (id o componente de array del mismo tipo)
				if (parList.get(i).parClass == Symbol.ParameterClass.REF) {
					if (!assignables.get(i)) {
						error(id, "El argumento nº " + (i + 1) + " no es una variable asignable para el parámetro por referencia " + msg);
					}
				}
			}
		}
	}
}
