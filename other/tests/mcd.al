------------------------------------------------------
procedure calcular_mcd is 

    i, j: integer;
------------------------------------------------------
procedure dato (d: ref integer) is
begin
	d:=0;
	while d <= 0 loop
		put ("Escribe un numero (>0): ");
		get (d);
		if d <= 0 then
			put_line("El numero debe ser > 0.");
		end if;
	end loop;
end;
------------------------------------------------------
function mcd(a, b: integer) return integer is
    i, j, k: integer;
begin
	j := a;
	k := b;
	i := a mod b;
	while i /= 0 loop
		j := k;
		k := i;
		i := j mod k;
	end loop;
	return k;
end;
------------------------------------------------------
begin
	put_line ("Este programa pide dos números positivos y calcula su máximo común divisor.");
	dato (i);
	dato (j);
	put_line ("");
	put_line ("mcd(", i, ",", j, ") = ", mcd (i,j));
end;
