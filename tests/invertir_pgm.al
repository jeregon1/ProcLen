--Formato del fichero

--P5
--fils cols
--max_gris
--pixels por filas (one byte per pixel, binary)

procedure invertir_pgm is
	formato: integer; 
	fils, cols: integer; 
	max_gris: integer; 
	image: array(0..499999) of character; 

	---------------------------------------------------
	function indice (fils, cols: integer; i, j: integer) return integer is 
	begin
		return i*cols + j; 
	end;
	---------------------------------------------------
	function cargar_imagen (formato, fils, cols, prof: ref integer; imagen: ref array(0..499999) of character) return boolean is
		c: character; 
		i, j: integer; 
	begin
		get (c); 
		get (formato); 
		get (fils); 
		get (cols); 
		get (max_gris); 
		skip_line; 
		
        if fils*cols > 500000 then
            put_line ("Imagen de dimensiones (", fils, ", ", cols, ") demasiado grande (max 500000 pixels)!");
            return false;
        else
            i := 0; 
            while i < fils loop
                j := 0; 
                while j < cols loop
                    get (c); 
                    image(indice (fils, cols, i, j)) := c; 
                    j := j + 1; 
                end loop;
                i := i + 1; 
            end loop;
            return true;
        end if;
	end;
	---------------------------------------------------
	procedure guardar_imagen (formato, fils, cols, prof: integer; image: ref array(0..499999) of character) is
		c: character; 
		i, j: integer; 
	begin
		put_line ('P', formato); 
		put_line (fils, ' ', cols); 
		put_line (prof); 
		i := 0; 
		while i < fils loop
			j := 0; 
			while j < cols loop
				put (image(indice (fils, cols, i, j))); 
				j := j + 1; 
			end loop;
			i := i + 1; 
		end loop;
	end;
	---------------------------------------------------
	procedure invertir_imagen (formato, fils, cols, prof: integer; image: ref array(0..499999) of character) is
		c: character; 
		i, j, idx: integer; 
	begin
		i := 0; 
		while i < fils loop
			j := 0; 
			while j < cols loop
                idx := indice(fils, cols, i, j); 
				image(idx) := int2char(max_gris - char2int(image(idx))); 			   
				j := j + 1; 
			end loop;
			i := i + 1; 
		end loop;
	end;
---------------------------------------------------
begin
	if cargar_imagen (formato, fils, cols, max_gris, image) then
        invertir_imagen(formato, fils, cols, max_gris, image); 
        guardar_imagen(formato, fils, cols, max_gris, image);
    end if;
end;