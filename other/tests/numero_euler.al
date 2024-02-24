procedure numero_euler is
-- e aproximado con una serie infinita
--  https://en.wikipedia.org/wiki/List_of_representations_of_e#As_an_infinite_series

--------------------------------------------------------------------
    e, sumando, resultado: array(0..100) of integer;
    n, ndigitos: integer;
--------------------------------------------------------------------
procedure iniciar (s: ref array(0..100) of integer) is
--------------------------------------------------------------------
    i: integer;
begin
   i := 0;
   while i <= ndigitos loop
      s(i) := 0;
      i := i + 1;
   end loop;
end;
--------------------------------------------------------------------
procedure mostrar_numero (s: ref array(0..100) of integer) is
--------------------------------------------------------------------
    i: integer;
begin
   put (s(0),'.');
   i := 1;
   while i <= ndigitos loop
      if (((i-1) mod 5) = 0) then
         put (" ");
      end if;
      put (s(i));
      i := i + 1;
   end loop;
   put_line;
end;
--------------------------------------------------------------------
procedure sumar (s,r: ref array(0..100) of integer) is
--------------------------------------------------------------------
    i, n: integer;
begin
   i := ndigitos;
   while i > 0 loop
	  n := s(i) + r(i);
	  if n > 9
		 then
	        s(i) := n mod 10;
	        s(i-1) := s(i-1) + (n / 10);
		 else
	        s(i) := n;
      end if;
      i := i - 1;
   end loop;
end;
--------------------------------------------------------------------
procedure dividir (s,r: ref array(0..100) of integer; n: integer) is
--------------------------------------------------------------------
    i: integer;
begin
   i := 0;
   while i < ndigitos loop
      if (s(i) / n) > 0 then
         r(i) := s(i) / n;
         s(i+1) := (((s(i) mod n) * 10)) + s(i+1);
	   else
         r(i) := 0;
         s(i+1) := (s(i) * 10) + s(i+1);
	   end if;
      i := i + 1;
   end loop;
end;
--------------------------------------------------------------------
procedure asignar (s,r: ref array(0..100) of integer) is
--------------------------------------------------------------------
    i: integer;
begin
   i := 0;
   while i <= ndigitos loop
      s(i) := r(i);
      i := i + 1;
   end loop;
end;
--------------------------------------------------------------------
begin
   ndigitos := 20;
   
   put_line("Aproximación del número de Euler e utilizando la serie infinita e = 1/0! + 1/1! + 1/2! + 1/3! ...");
   put_line("");
   
   iniciar (sumando);
   iniciar (e);
   sumando(0) := 1;
   e(0) := 2;
   n := 1;
   while n < ndigitos loop
         dividir (sumando, resultado, n);
         sumar (e, resultado);
         n := n + 1;
         put ("e con ", n, " componentes de la serie: ");
         mostrar_numero (e);
         asignar (sumando, resultado);
   end loop;
   put_line;
   put_line("La convergencia es rápida porque los términos de la suma son 1/k!");
end;
