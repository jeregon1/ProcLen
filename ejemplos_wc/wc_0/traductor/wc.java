//*****************************************************************
// File:   wc.jj
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   febrero 2022
// Coms:   Compilar mediante "ant". Limpiar lo generado mediante "ant clean"
//         Implementa una versión, sin opciones, del "wc" de Unix
//         Ejemplo de uso de javacc para genera un analizador léxico
//         e integrarlo en un programa externo. Toma datos de la 
//         entrada estándar. Identifica tokens, y opera con algunos de ellos.
//         Hay ficheros de prueba en "doc/ejemplos"
//         Para la ejecución, siendo "<path>" el camino hasta "wc.jar"
//              java -jar <path>/wc.jar
//              java -jar <path>/wc.jar < fichero
//*****************************************************************


class wc {
    public static void main(String[] args) {
    	lexer lex = new lexer(System.in);
    	Token t;
        int nPal = 0,nLin = 0,nChar = 0;

    	t = lex.getNextToken(); //genera primer token

    	while(t.kind != lexerConstants.EOF) {
            if(t.kind == lexerConstants.tPALABRA) {
                nPal++;
                nChar += t.image.length();
            }
            else if(t.kind == lexerConstants.tNL) {
                nChar++;
                nLin++;
            }
            else {
            	nChar++;
            }
    		t = lex.getNextToken();  //siguiente token
    	}

        System.out.println(nLin + "\t" + 
			               nPal + "\t" + 
			               nChar);
    }
}