procedure Programa is
-- PRUEBA--> TIPOS
i, i:integer;   -- Error: identificador repetido
c, i:character; -- Error: identificador repetido
--s: string; -- Error: tipo no permitido
b: boolean;
--v: array() of integer; -- Error: no se define el rango
ax:  array(1..0) of integer; -- Error: rango vacío
ai:  array(-1..1) of integer;
ai2: array(-1..1) of integer;
ab: array(1..3) of boolean;

-- PRUEBA--> PROCEDIMIENTOS Y FUNCIONES
procedure p is
    i: integer;
    c: character;
    b: boolean;
    ai: array(-1..1) of integer;
    ab: array(1..3) of boolean;
begin
    i := 1;
    c := 'c';
    b := true;
    ai(1) := 1;
    ab(1) := true;
end;

begin 
-- PRUEBA--> OPERADORES


-- PRUEBA--> GET. 
-- La instruccion de lectura get admite como argumentos una lista no vacia de asignables. 
-- Cada asignable ha de ser de uno de los tipos integer, character.
-- GET; --error sintactico: se esperaba un argumento
GET(i);
GET(c,i);
get(i,b,ai); -- Error: un array requiere selector de componente
--get(-i); -- Error sintactico: se esperaba un identificador simple

-- PRUEBA--> PUT/PUT_LINE
--La instruccion de escritura put requiere una lista no vacia de expresiones.
--Cada expresion ha ser de uno de los tipos integer, boolean, character, string
put(i);
put(i,c,b, -1, 'c', i = 1, "hola "" mundo");
--put; -- Error sintáctico: se esperaba un argumento
put_line;

-- PRUEBA--> SKIP_LINE
--La instruccion de escritura skip_line no requiere argumentos
--skip_line(i); -- Error sintactico: no se esperaba un argumento


-- PRUEBA--> ASIGNACIÓN

i := c; -- Error: se esperaba un entero
c := i; -- Error: se esperaba un caracter
b := i; -- Error: se esperaba un booleano

-- PRUEBA--> IF WHILE
--La guarda de las instrucciones de selecci´on y de iteraci´on s´olo puede ser de
--tipo boolean. Lo mismo se exige para las cla´usulas elsif.
if -i then null; end if; -- Error: se esperaba un booleano
    -- CORREGIR ERROR--> if i = 1 or b and c /= 'c' and not (ai(3) = -2) then null; 
if true then null;
elsif i + 3 then null; -- Error: se esperaba un booleano
elsif ab(5) then null; 
end if;

WHILE c loop null; end loop; -- Error: se esperaba un booleano



end;
