--Ejemplo de cambio de bases numéricas
procedure cambio_base is
	num, base: integer;
	enb: integer;
------------------------------------------------------
function b_dec(n,b: integer) return integer is
	uc: integer;
	valRec: integer;
begin
	if n = 0 then
		return 0;
	else
		uc := n mod 10;
		valRec := b_dec (n / 10, b);
		return valRec*b + uc;
	end if;
end;
------------------------------------------------------
function dec_b(n: integer;b: integer) return integer is
	resto,valRec: integer;
begin
	if (n < b) then
		return n;
	else
		resto := n mod b;

		valRec := dec_b (n / b, b);
		return valRec*10 + resto;
	end if;
end;
------------------------------------------------------
begin
	num := 4;
	Base := 2;

	put("Este programa convierte n=",num," a base b=", base);
	put_line(", y luego efectúa la conversión inversa.");
	put_line;
	put_line("n: ",num);
	put_line("b: ",base);
	enB := dec_b(num,base);
	put_line("dec_b(",num,",",base,"): ",enB);
	put_line("b_dec(",enB,",",base,"): ",b_dec(enB,base));
end;
