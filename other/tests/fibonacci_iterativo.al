procedure fibonacci is

    i, n, fn, fnm1, fnm2: integer;

-----------------------------------------------------------
procedure pedir_dato (dato: ref integer) is 
-----------------------------------------------------------
begin
    dato := 0;
    
    while dato <= 0 loop
      put ("Escribe un numero positivo: ");
      get (dato);
    end loop;
end;
-----------------------------------------------------------
procedure dato (dato: ref integer) is
-----------------------------------------------------------
    correcto: boolean;
begin
  dato := 0;
  correcto := false;
  while not correcto loop
     pedir_dato (dato);
     correcto := dato > 0;
     if not correcto then
        put ("El numero debe ser postivo.");
     end if;
  end loop;
end;
-----------------------------------------------------------
begin
  put_line ("");
  put_line ("Este programa pide un número positivo n y calcula fib(n) con la fórmula recursiva fib(n) = fib(n-1) + fib(n-2)");
  put_line ("Es muy rápido porque la implementación es iterativa.");
  put_line ("Habrá MATH overflow en fib(47) porque los enteros en la máquina p son de 4 bytes).");
  put_line ("");
  dato (n);
  put_line ("");

  put_line ("fib(1) = 1");
  put_line ("fib(2) = 1");

  i := 3;
  fnm1 := 1;
  fnm2 := 1;
  while i <= n loop
    fn := fnm1 + fnm2;
    put_line ("fib(", i,") = ", fn);
    fnm2 := fnm1;
    fnm1 := fn;
    i := i + 1;
  end loop;
  put_line;
end;