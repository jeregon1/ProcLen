package lib.errores;

import traductor.Token;

public class ErrorSemantico  {
	private boolean hayError = false; //para controlar si ha habido errores

    public ErrorSemantico() {};

	// Ejemplo:
	// Semantic error (5,21): Current symbol: '+'. Ambos operandos han de ser 'integer'
    public void print(Token t, String msg) {
        System.err.println("----------------------------------------");
        System.err.println("Semantic error (" + t.beginLine + "," + t.beginColumn + "): Current symbol: '" + t.image + "'. " + msg);
        hayError = true;
    }

    public boolean hayError() {
        return hayError;
    }
}

