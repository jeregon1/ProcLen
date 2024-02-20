------------------------------------------------------------------------
--  juego_de_la_vida.al
------------------------------------------------------------------------
procedure juego_de_la_vida is
--------------------------------------------------------------------------
    Colonia: array(1..80) of boolean;
    i, iteraciones, elementos: integer;

--------------------------------------------------------------------------
procedure inicializar (colonia: ref array(1..80) of boolean) is
--------------------------------------------------------------------------
    i: integer;
begin
    i := 1;
    while i <= elementos loop
        colonia(i) := (i mod 20) = 0;
        i := i + 1;
    end loop;
end;

--------------------------------------------------------------------------
procedure inicializar2 (colonia: ref array(1..80) of boolean) is
--------------------------------------------------------------------------
    i: integer;
begin
    i := 1;
    while i <= 80 loop
        colonia(i) := (i >= 37) and (i <= 43);
        i := i + 1;
    end loop;
end;

--------------------------------------------------------------------------
procedure asignar (colonia: ref array(1..80) of boolean;
                   siguiente: array(1..80) of boolean) is
--------------------------------------------------------------------------
    i: integer;
begin
    i := 1;
    while i <= elementos loop
        colonia(i) := siguiente(i);
        i := i + 1;
    end loop;
end;

--------------------------------------------------------------------------
function vivira (colonia: ref array(1..80) of boolean; i: integer) return boolean is
--------------------------------------------------------------------------
begin
    if i = 1 then
        return (false);
    else if i = elementos then
        return (false);
    else
        return (not colonia(i) and ((colonia(i - 1) 
                and not colonia(i + 1)) or (not colonia(i - 1) 
                and colonia(i + 1))));
    end if;
    end if;
end;

--------------------------------------------------------------------------
function vivira2 (colonia: ref array(1..80) of boolean; i: integer) return boolean is
--------------------------------------------------------------------------
    vivos: integer;
begin
    vivos := 0;
    if i > 1 then if colonia(i-1) then vivos := vivos + 1; end if; end  if;
    if i > 2 then if colonia(i-2) then vivos := vivos + 1; end if; end  if;
    if i < 80 then if colonia(i+1) then vivos := vivos + 1; end if; end  if;
    if i < 79 then if colonia(i+2) then vivos := vivos + 1; end if; end  if;

    if not colonia(i) then
        return (vivos = 2) or (vivos = 3);
    else
        return (vivos = 2) or (vivos = 4);
    end if;
end;

--------------------------------------------------------------------------
procedure siguientegeneracion (colonia: ref array(1..80) of boolean) is
--------------------------------------------------------------------------
    i: integer;
    siguiente: array(1..80) of boolean;
begin
    i := 1;
    while i <= elementos loop
        siguiente(i) := vivira (colonia, i);
        i := i + 1;
    end loop;
    asignar (colonia, siguiente);
end;

--------------------------------------------------------------------------
procedure mostrarcolonia (colonia: array(1..80) of boolean) is
--------------------------------------------------------------------------
i: integer;

begin
    i := 1;
    while i <= elementos loop
        if colonia(i) then
            put ('*');
        else
            put (' ');
        end if;
        i := i + 1;
    end loop;
    put (int2char (13), int2char (10));
end;
--------------------------------------------------------------------------
begin
    put_line ("Implementación de la versión 1D del Juego de la Vida de Conway.");
    put_line ("https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life");
    put_line ("");
    elementos := 80;
    inicializar (colonia);
    mostrarcolonia (colonia);
    i := 1;
    iteraciones := 50;
    while i <= iteraciones loop
        siguientegeneracion (colonia);
        mostrarcolonia (colonia);
        i := i + 1;
    end loop;
end;