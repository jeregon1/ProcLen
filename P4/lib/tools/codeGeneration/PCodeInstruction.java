//*****************************************************************
// File:   PCodeInstruction.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   abril 2022
// Coms:   Elemento de código que representa una instrucción. 
//			Hereda de CodeElement
//*****************************************************************

package lib.tools.codeGeneration;

public class PCodeInstruction extends CodeElement{
	
	public enum OpCode {
	// Operadores aritméticos
		PLUS (24), 	// plus --> push (pop2() + pop1())
		SBT (27), 	// subtract --> push (pop2() - pop1())
		TMS (31), 	// times --> push (pop2() * pop1())
		MOD (17), 	// mod --> push (pop2() mod pop1())
		DIV (4), 	// div --> push (pop2() div pop1())
		NGI (20), 	// negative --> push (-pop())

	// Operadores lógicos
		AND (0), 	// and --> push (pop2() and pop1())
		OR (22), 	// or --> push (pop2() or pop1())
		EQ (8), 	// equal --> push (pop2() = pop1())
		NEQ (18), 	// not equal --> push (pop2() != pop1())
		LT (14), 	// lower than --> push (pop2() < pop1())
		LTE (15), 	// lower than or equal --> push (pop2() <= pop1())
		GT (9), 	// greater than --> push (pop2() > pop1())
		GTE (10), 	// greater than or equal --> push (pop2() >= pop1())
		NGB (19), 	// not --> push (not pop())

	// Entrada/salida
		RD (26), 	// read (n) --> if n = 0 read char and store at frames[pop()] else as int
		WRT (32),  	// write (n) --> if n = 0 write pop() as char else as int

	// Miscelánea
		NOP (21), 	// nop 
		SWP (30), 	// swap --> push (pop1(); pop2())
		DUP (6), 	// duplicate --> push (pop1(); pop1())
		POP (25), 	// pop --> pop()

	// Referencia a datos
		STC (29), 	// store constant (n) --> push (n)
		SRF (28), 	// set reference (f o) --> push (display[DP - f] + o)
		DRF (5), 	// dereference --> push (frames[pop()])
		ASG (1), 	// assign --> frames[pop2()] = pop1()
		ASGI (2), 	// assign inverse --> frames[pop1()] = pop2()

	// Control de flujo
		ENP (7), 	// enter program (at n)
		LVP (16), 	// leave program 
		JMP (12), 	// jump (n) --> PC = n
		JMT (13), 	// jump if true (n) --> pop()=1? PC = n else PC = PC+1
		JMF (11), 	// jump if false (n) --> pop()=0? PC = n else PC = PC+1
		OSF (23), 	// open stack frame (crear BA)
		CSF (3); 	// close stack frame (destruir BA)

		int code; 
		private OpCode(int code) {
			this.code = code; 
		}
	}
	
	OpCode code; 
	int args[] = null; 
	String argetiq = ""; 
	
	public PCodeInstruction (OpCode code, int... args) {
		this.code = code; 
		this.args = new int[args.length]; 
		for (int i=0; i<args.length; i++) {
			this.args[i] = args[i]; 
		}
	}
	
	public PCodeInstruction (OpCode code, int size, int level, String label) {
		// only for OSF s l label
		this.code = code; 
		this.args = new int[2]; 
		this.args[0] = size; 
		this.args[1] = level; 
		this.argetiq = label; 
	}
	
	public PCodeInstruction (OpCode code, String label) {
		this.code = code; 
		this.argetiq = label; 
	}
	
	public String toString () {
		StringBuilder strBldr = new StringBuilder();
		strBldr.append("  "); 
		strBldr.append(code);
		if (code != OpCode.OSF) {
			if (args != null) {
				for (int i=0; i<args.length; i++) {
					strBldr.append (String.format(" %2d", args[i])); 
				}
			}
			else if (!"".equals(argetiq)) {
				strBldr.append(" "); 
				strBldr.append(argetiq); 
			}
		}
		else {
			for (int i=0; i<args.length; i++) {
				strBldr.append (String.format(" %2d", args[i])); 
			}
			if (!"".equals(argetiq)) {
				strBldr.append(" "); 
				strBldr.append(argetiq); 
			}
		}
		return strBldr.toString(); 
	}
	
}

