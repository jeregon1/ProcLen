------------------------------------------------------------------------
--  numero_pi_leibnitz.al
------------------------------------------------------------------------
procedure numero_pi_leibnitz is

    n, limite_n, digitos: integer;
    pi, sumanloop, resultaloop: array(0..100) of integer;
    sumo: boolean;
--------------------------------------------------------------------
procedure iniciar (s: ref array(0..100) of integer) is
--------------------------------------------------------------------
    i: integer;
begin
   i := 0;
   while i <= digitos loop
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
   while i <= digitos loop
      if (((i-1) mod 5) = 0) then
         put (" ");
      end if;
      put (s(i));
      i := i + 1;
   end loop;
   put_line;
end;
--------------------------------------------------------------------
procedure sumar (s: ref array(0..100) of integer; r: array(0..100) of integer) is
--------------------------------------------------------------------
    i, n: integer;
begin
   i := digitos;
   while i >= 0 loop
	  n := s(i) + r(i);
	  if n > 9 then
	        s(i) := n mod 10;
	        if i > 0 then
               s(i-1) := s(i-1) + (n / 10);
            end if;
	  else
	        s(i) := n;
      end if;
      i := i - 1;
   end loop;
end;
--------------------------------------------------------------------
procedure restar (s: ref array(0..100) of integer; r: array(0..100) of integer) is
-- s = s - r
--------------------------------------------------------------------
    i, n: integer;
    llevo_uno: boolean;
begin
   i := digitos;
   llevo_uno := false;

   while i >= 0 loop
	  if llevo_uno then
         n := (s(i) - 1) - r(i);
     else
         n := s(i) - r(i);
     end if;
	  if n < 0 then
	        s(i) := n + 10;
	        llevo_uno := true;
		 else
	        s(i) := n;
           llevo_uno := false;
      end if;
      i := i - 1;
   end loop;
end;
--------------------------------------------------------------------
procedure dividir (s: array(0..100) of integer; r: ref array(0..100) of integer; n: integer) is
--------------------------------------------------------------------
    i: integer;
begin
   i := 0;
   while i < digitos loop
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
begin
   put_line ("Aproximación del número Pi utilizanloop la serie infinita e = 4 - 4/3 + 4/5 - 4/7 + 4/9 ...");
   put_line ("");
   iniciar (sumanloop);
   iniciar (pi);
   sumanloop(0) := 4;
   pi(0) := 4;
   n := 3;
   digitos := 50;
   limite_n := 100;
   sumo := false;
   while n < limite_n loop
         dividir (sumanloop, resultaloop, n);
         if sumo then
            sumar (pi, resultaloop);
         else
            restar (pi, resultaloop);
         end if;
         sumo := not sumo;
         put ("Pi con ", (n - 1) / 2, " componentes de la serie: ");
         mostrar_numero (pi);
         n := n + 2;
   end loop;
   put_line ("");
   put_line ("La convergencia es lenta porque los términos de la suma son proprcionales a 1/k");
end;
