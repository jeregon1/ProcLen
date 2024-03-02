procedure test_2 is

function s return boolean is 
    -- integer: integer; -- ERROR porque ningún símbolo puede llamarse como las palabras reservadas.
    aux1: boolean;
begin
    -- null; -- ERROR si no hay ninguna instrucción
    if 2>1 then
        -- aux2: integer; --ERROR al ser una declaración de variable local dentro de if
        put_line("Lo de encima mío es un error");
        -- aux1 := s(); --ERROR al tener paréntesis sin parámetros en la función
    end if;
    return true;
end;
--------------------------------------------------------------------------
begin
    null;
end;