procedure Programa is
    aux : integer;
    v: array(1..3) of integer;
    v2: array(1..3) of boolean;
    v3: array(1..4) of integer;

    -- PRUEBA--> PROCEDIMIENTOS Y FUNCIONES
    procedure p1 is
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

    function f1(aux2, aux3: integer) return integer is -- Función con return en lugar inalcanzable (funciona bien en alike)
    begin
        if false then
            return aux2;
        end if;
    end;

    function f2(aux2: ref integer) return integer is
    begin
        return aux2;
    end;

    -- Parametros por valor

    -- Prueba de parámetros arrays tanto por valor como por referencia
    function f3( a: array(1..3) of integer) return integer is
    begin
        return a(1);
    end;

    function f4( a: ref array(1..3) of integer) return integer is
    begin
        return a(1);
    end;

    -- Prueba de función sin return
    function f5( a: ref array(1..3) of integer) return integer is
    begin
        a(1) := 1;
    end;

    -- Prueba de función con return de distinto tipo
    function f6( a: array(1..3) of integer) return integer is
    begin
        return true;
    end;

    -- Prueba de declaración de procedimiento con mismo nombre que el programa principal
    -- pero en nivel != de 0 (si que deja), mientras que en nivel 0 no deja (ejemplo siguiente)
    function f7( a: array(1..3) of integer) return integer is
        procedure Programa is
        begin 
            skip_line;
        end;
    begin
        return a(1);
    end;

    procedure Programa is
    begin
        skip_line;
    end;

begin
    -- PRUEBA (cont) --> FUNCIONES Y PROCEDIMIENTOS
    --aux := f1(1, 2, 3); -- error semántico: número incorrecto de argumentos
    --aux := f2(aux + 1); -- error semántico: argumento por referencia no es asignable
    --aux := f2(-v(3)); -- error semántico: argumento por referencia no es asignable
    --aux := f2(1); -- error semántico: argumento por referencia no es asignable
    --aux := f3(v); -- error semántico: argumento por valor no es asignable
    --aux := f4(v); -- error semántico: argumento por referencia no es asignable
    aux := f3(v2); -- error semántico: no coinciden los tipos base
    aux := f3(v3); -- error semántico: no coinciden los tamaños de los arrays

    --aux := 2 + v;
    --aux := f1("hola", 2); -- error semántico: argumento debe coincidir con tipo de parámetro
    -- p1(); error sintáctico: invocación a parámetro/función sin parámetros va sin '()'
    -- Programa -- error sintáctico: programa principal no puede ser invocado
    aux := f1(f1(1,2),2);

end;
