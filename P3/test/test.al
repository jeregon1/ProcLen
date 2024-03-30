procedure Programa is
i, i:integer;   -- Error: identificador repetido
c, i:character; -- Error: identificador repetido
b: boolean;
ax:  array(1..0) of integer; -- Error: rango vacío
ai:  array(-1..1) of integer;
ai2: array(-1..1) of integer;
ab: array(1..3) of boolean;

begin 
-- PRUEBA GET
-- La instrucci´on de lectura get admite como argumentos una lista no vac´ıa de
-- asignables. Cada asignable ha de ser de uno de los tipos integer, character.
--get; -- Error sintáctico: se esperaba un argumento
GET(i);
get(c,i);
get(i,b, ai); -- Error: el segundo argumento es de tipo boolean
--get(-i); -- Error sintáctico: se esperaba un identificador simple

-- PRUEBA PUT
--La instrucci´on de escritura put requiere una lista no vac´ıa de expresiones.
--Cada expresi´on ha ser de uno de los tipos integer, boolean, character,string
put(i);
put(i,c,b, -1, 'c', i = 1, "hola "" mundo");
--put; -- Error sintáctico: se esperaba un argumento
put_line;

-- PRUEBA IF WHILE
--La guarda de las instrucciones de selecci´on y de iteraci´on s´olo puede ser de
--tipo boolean. Lo mismo se exige para las cla´usulas elsif.
if -i then null; end if; -- Error: se esperaba un booleano
if i = 1 or b and c /= 'c' and not (ai(3) = -2) then null; 
elsif i + 3 then null; -- Error: se esperaba un booleano
elsif ab(5) then null; 
end if;

WHILE c loop null; end loop; -- Error: se esperaba un booleano

-- PRUEBA ASIGNACIÓN

i := c; -- Error: se esperaba un entero
c := i; -- Error: se esperaba un caracter
b := i; -- Error: se esperaba un booleano


-- PRUEBA OPERADORES


end;
