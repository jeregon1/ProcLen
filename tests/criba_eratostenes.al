------------------------------------------------------------------------
--  criba_eratostenes.al
------------------------------------------------------------------------
procedure eratostenes is
    n: integer;
    criba: array(0..100) of boolean;
------------------------------------------------------------------------
function pedir_entero return integer is
------------------------------------------------------------------------
    n: integer;
begin
        n := 0;
        while (n < 1) or (n > 100) loop
                put("Dame un numero entre 1 y 100: ");
                get (n);
        end loop;
        return n;
end;
------------------------------------------------------------------------
procedure escrib_vect (v: array(0..100) of boolean) is
------------------------------------------------------------------------
    m,i: integer;
    salir:boolean;
begin
    i := 2;
    m := 0;
    salir := false;
    put_line;
    put_line ("Numeros primos hasta ", n, ": ");
    put_line;
    while not salir loop
        if i > n then
            salir := true;
        else
            if v(i) then
                put_line (i, " es primo.");
                m := m + 1;
            end if;
            i := i + 1;
        end if;
    end loop;
    put_line;
    put_line("Hasta ", n, " hay ", m, " números primos.");
end;
----------------------------------------------------------------
procedure inicializar (v: ref array(0..100) of boolean) is
----------------------------------------------------------------
    i: integer;
begin
    i := 1;
    while i <= n loop
            v(i) := true;
            i := i + 1;
    end loop;
end;
----------------------------------------------------------------
procedure eliminar_no_primos (v: ref array(0..100) of boolean) is
----------------------------------------------------------------
    i,j: integer;
begin
    i := 2;
    while i <= n / 2 loop
        if v(i) then
            j := 2 * i;
            while j <= n loop
                    v(j) := false;
                    j := j + i;
            end loop;
        end if;
        i := i + 1;
    end loop;
end;
------------------------------------------------------------------------
procedure procesar (v: ref array(0..100) of boolean) is
------------------------------------------------------------------------
begin
    inicializar (v);
    eliminar_no_primos (v);
    escrib_vect (v);
end;

------------------------------------------------------------------------
begin
    put_line ("Criba de Eratóstenes: primos hasta un n dado");
    put_line ("https://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes");
    put_line;

    n := pedir_entero;
    procesar (criba);
end;