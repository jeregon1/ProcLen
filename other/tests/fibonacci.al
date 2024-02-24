------------------------------------------------------------------------
--  factorial.al
------------------------------------------------------------------------
procedure fibonacci is

    i,n,r: integer;

-----------------------------------------------------------
procedure cambiar_de_linea is
-----------------------------------------------------------
begin
    put (int2char (13), int2char (10));
end;

-----------------------------------------------------------
procedure dato (dato: ref integer) is
-----------------------------------------------------------
    correcto: boolean;
begin
    dato := 0;
    correcto := false;
    while not correcto loop
        put ("Escribe un numero positivo: ");
        get (dato);
        correcto := dato > 0;
        if not correcto then
            put_line ("El número debe ser positivo.");
        end if;
    end loop;
end;

-----------------------------------------------------------
procedure fib (n: integer; r: ref integer) is
-----------------------------------------------------------
    r1,r2: integer;
begin
    if n > 1 then
        fib (n - 1, r1);
        fib (n - 2, r2);
        r := r1 + r2;
    else
        r := n;
    end if;
end;

-----------------------------------------------------------
begin
    put_line ("Este programa pide un número positivo n y calcula fib(n) con la fórmula recursiva fib(n) = fib(n-1) + fib(n-2)");
    put_line ("A partir de 30 será muy lento por la recursividad.");
    put_line ("");
    dato (n);
    i := 1;
    while i <= n loop
        fib (i, r);
        put_line ("fib(", i,") = ", r);
        i := i + 1;
    end loop;
    cambiar_de_linea;
end;
