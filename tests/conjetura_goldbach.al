------------------------------------------------------------------------
--  conjetura_goldbach.al
------------------------------------------------------------------------
procedure goldbach is

    n, i: integer;
------------------------------------------------------------------------
function pedir_entero return integer is
    n: integer;
begin
    n := 0;
    while (n <= 2) or (n mod 2 /= 0) loop
        put("Dame un numero PAR mayor que 2: ");
        get(n);
    end loop;
    return n;
end;
------------------------------------------------------------------------
function es_primo (k: integer) return boolean is
    i: integer;
    primo: boolean;
begin
    i := 2;
    primo := true;
    while (i <= (k / 2)) and (primo) loop
        primo := (k mod i) /= 0;
        i := i + 1;
    end loop;
    return primo;
end;
------------------------------------------------------------------------
function hay_un_par (k: integer) return boolean is

    i, n, a, b: integer;
begin
    a := 2;
    b := 2;
    n := 0;
    put (k, " es la suma de: ");
    while (a < k) and (b < k) loop
        if es_primo (a) and es_primo (b) and ((a + b) = k) then
            put(a, "+", b,", ");
            n := n + 1;
        end if;
        a := a + 1;
        if a = k then
            b := b + 1;
            a := b;
        end if;
    end loop;

    put_line(n, " parejas de primos en total.");
    return n > 0;
end;
------------------------------------------------------------------------
begin
    put_line ("Conjetura de Golbach: todo número par mayor que 2 puede escribirse como suma de dos números primos.");
    put_line ("https://es.wikipedia.org/wiki/Conjetura_de_Goldbach");
    put_line;
    put_line ("Este programa comprueba si es cierta hasta el número que le digas.");
    put_line;

    n := pedir_entero;
    i := 4;
    while i <= n loop
        if not hay_un_par (i) then
            put_line ("L conjetura no se cumple para ", i, "! (Seguro que por error del compilador!)");
        end if;
        i := i + 2;
    end loop;
end;