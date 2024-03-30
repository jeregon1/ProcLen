package lib.errores;

import traductor.Token;

public class ErrorSemantico  {
	private int num_errores;

    public ErrorSemantico() {
        num_errores = 0;
    };

    public int getNumErrores() {
        return num_errores;
    }

	// Ejemplo:
    // ----------------------------------------
	// Semantic error (5,21): Current symbol: '+'. Ambos operandos han de ser 'integer'
    public void print(Token t, String msg) {
        num_errores++;
        System.err.println("----------------------------------------");
        System.err.println("Semantic error (" + t.beginLine + "," + t.beginColumn + "): Current symbol: '" + t.image + "'. " + msg);
    }

    public boolean hayError() {
        return num_errores > 0;
    }
}
