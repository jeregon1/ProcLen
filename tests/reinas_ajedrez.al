------------------------------------------------------------------------
-- reinas_ajedrez.al
------------------------------------------------------------------------

procedure ajedrez is

	tamano_tablero, nreinas, fila, columna, f, c: integer;
	tablero, reinas: array(0..999) of integer;

------------------------------------------------------------------------
function min (x, y: integer) return integer is
------------------------------------------------------------------------
begin
	if x > y then return (y); else return (x); end if;
end;

------------------------------------------------------------------------
function max (x, y: integer) return integer is
------------------------------------------------------------------------
begin
	if x > y then return (x); else return (y); end if;
end;

------------------------------------------------------------------------
procedure linea is
------------------------------------------------------------------------
begin
	put (int2char (13), int2char (10));
end;

------------------------------------------------------------------------
function sitio (fila, columna: integer) return integer is
------------------------------------------------------------------------
begin
	return (((fila - 1) * tamano_tablero) + columna - 1);
end;

------------------------------------------------------------------------
function componente (tablero: ref array(0..999) of integer;
	               	fila, columna: integer) return integer is
------------------------------------------------------------------------
begin
	return (tablero(sitio (fila, columna)));
end;

------------------------------------------------------------------------
function ocupada (tablero: ref array(0..999) of integer;
	              fila, columna: integer) return boolean is
------------------------------------------------------------------------
begin
	return (tablero(sitio (fila, columna)) > 0);
end;

------------------------------------------------------------------------
procedure asignar_componente (tablero: ref array(0..999) of integer;
	                        	fila, columna, valor: integer) is
------------------------------------------------------------------------
begin
	tablero(sitio (fila, columna)) := valor;
end;

------------------------------------------------------------------------
procedure marcar_componente (tablero: ref array(0..999) of integer;
	                       	fila, columna: integer) is
------------------------------------------------------------------------
begin
	tablero(sitio (fila, columna)) := tablero(sitio (fila, columna)) + 1;
end;

------------------------------------------------------------------------
procedure desmarcar_componente (tablero: ref array(0..999) of integer;
	                          	fila, columna: integer) is
------------------------------------------------------------------------
begin
	tablero(sitio (fila, columna)) := tablero(sitio (fila, columna)) - 1;
end;

------------------------------------------------------------------------
procedure colocar_reina (fila, columna: integer) is
------------------------------------------------------------------------
	f, c: integer;
begin
	marcar_componente (reinas, fila, columna);

	f := 1;
	while f <= tamano_tablero loop
		marcar_componente (tablero, f, columna);
   		f := f + 1;
	end loop;

	c := 1;
	while c <= tamano_tablero	loop
		marcar_componente (tablero, fila, c);
   		c := c + 1;
	end loop;

	f := fila;
	c := columna;
	while (f > 1) and (c > 1) loop
   		f := f - 1;
   		c := c - 1;
	end loop;

	while (f <= tamano_tablero) and (c <= tamano_tablero)	loop
		marcar_componente (tablero, f, c);
   		f := f + 1;
   		c := c + 1;
	end loop;

	f := fila;
	c := columna;
	while (f > 1) and (c < tamano_tablero) loop
   		f := f - 1;
   		c := c + 1;
	end loop;

	while (f <= tamano_tablero) and (c >= 1) loop
		marcar_componente (tablero, f, c);
   		f := f + 1;
   		c := c - 1;
	end loop;
end;

------------------------------------------------------------------------
procedure iniciar_tablero is
------------------------------------------------------------------------
	f,c: integer;
begin
	f := 1;
	while f <= tamano_tablero loop
	  	c := 1;
	  	while c <= tamano_tablero loop
	    	asignar_componente (tablero, f, c, 0);
	    	asignar_componente (reinas, f, c, 0);
	  		c := c + 1;
		end loop;
		f := f + 1;
	end loop;
end;

------------------------------------------------------------------------
procedure mostrar_tablero (tablero: ref array(0..999) of integer) is
------------------------------------------------------------------------
	f,c: integer;
begin
	linea;
	put_line ("Esta es una solución para n: ",tamano_tablero);
	linea;
	f := 1;
	while f <= tamano_tablero loop
	  	c := 1;
	  	while c <= tamano_tablero loop
	    	if componente (tablero, f,c) > 0 then
	    		put (" o");
	    	else
	    		put (" .");
	    	end if;
	    	c := c + 1;
	  	end loop;
	  	linea;
	  	f := f + 1;
	end loop;
end;

------------------------------------------------------------------------
function libre (fila, columna: ref integer) return boolean is
------------------------------------------------------------------------
	endal: boolean;
begin
    fila := 1;
    columna := 1;
    endal := false;
    while not endal loop
        if fila > tamano_tablero then
        	endal := true;
        elsif columna > tamano_tablero then 
			columna := 1; fila := fila + 1;
		elsif ocupada (tablero, fila, columna) then
			columna := columna + 1;
		else 
			endal := true;
		end if;
    end loop;
    return (fila <= tamano_tablero);
end;
------------------------------------------------------------------------
begin
  	tamano_tablero := 4;
  	
  	put_line ("Este programa intenta colocar ", tamano_tablero, 
  		      " reinas en un tablero de ajedrez de ", tamano_tablero, '*', 
  		      tamano_tablero, " sin que se ataquen.");

	while tamano_tablero <=10 loop
		fila := 1;
		nreinas := 0;
		put_line("Probando con n: ",tamano_tablero);
		while (fila <= tamano_tablero) and (nreinas < tamano_tablero) loop
			columna := 1;
			while (columna <= tamano_tablero) and (nreinas < tamano_tablero) loop
				nreinas := 1;
				iniciar_tablero;
				colocar_reina (fila, columna);
				while (nreinas < tamano_tablero) and libre (f, c) loop
					colocar_reina (f, c);
					nreinas := nreinas + 1;
				end loop;
				if nreinas = tamano_tablero then
					mostrar_tablero (reinas);
					put_line;
				end if;
				columna := columna + 1;
			end loop;
			fila := fila + 1;
		end loop;

		tamano_tablero := tamano_tablero + 1;
	end loop;
  	put_line;
end;