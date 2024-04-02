procedure Programa is

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

function f(aux2, aux3: integer) return integer is -- Función con return en lugar inalcanzable (funciona bien en alike)
begin
    if false then
        return aux;
    end if;
end;

begin
    -- PRUEBA (cont) --> FUNCIONES Y PROCEDIMIENTOS
    i := f(1, 2, 3); -- error semántico: número incorrecto de argumentos
    -- p(); error sintáctico: invocación a parámetro/función sin parámetros va sin '()'
    -- Programa -- error sintáctico: programa principal no puede ser invocado

end;
