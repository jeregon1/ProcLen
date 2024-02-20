------------------------------------------------------------------------
--  expresiones_integer.al
--  Todas son correctas
------------------------------------------------------------------------
procedure exps is
	i1, i2, i3, i4, i5: integer;
	arr: array(1..10) of integer;
	numFormulas, numCorrectas: integer;
------------------------------------------------------------------------	
procedure evalua(found, expected: integer; numFormulas, numTrues: ref integer) is
begin
	if found = expected then
		numTrues := numTrues + 1;
	end if;
	numFormulas := numFormulas + 1;
end;
------------------------------------------------------------------------
begin
	put_line("-----------------------------------------------------");

	numFormulas := 0;
	numCorrectas := 0;
	i1 := 1; i2 := 2; i3 := 3; i4 := 4; i5 := 5;
    arr(1) := 1; arr(2) := 2; arr(3) := 3; arr(4) := 4;

	-- Constantes
    evalua(-1, -1, numFormulas, numCorrectas);
	evalua(2 + 2, 4, numFormulas, numCorrectas);
	evalua(9 mod 5, 4, numFormulas, numCorrectas);
	--evalua(-9 mod -5, -4, numFormulas, numCorrectas);
	evalua(2 * 2 * 2 * 2, 16, numFormulas, numCorrectas);
	evalua(10 * 10 + 2, 102, numFormulas, numCorrectas);
	evalua(2 + 10 * 10, 102, numFormulas, numCorrectas);
	evalua(-2 + 5 / 5 * 2, 0, numFormulas, numCorrectas);
	evalua(6 / 2 * 4 / 2, 6, numFormulas, numCorrectas);
	evalua((2 + 2) / 3, 1, numFormulas, numCorrectas);
	evalua(-5 + (1 * (4 / 2)), -3, numFormulas, numCorrectas);
	evalua(10 / 4 / 2, 1, numFormulas, numCorrectas);
	
	-- Variables
	evalua(-i1, -1, numFormulas, numCorrectas);
    evalua(i1 + i2, 3, numFormulas, numCorrectas);
    evalua(i1 * i2 + i3, 5, numFormulas, numCorrectas);
    evalua((i3 + i4 + 5) / i5 + 2, 4, numFormulas, numCorrectas);
    evalua((i3 + i4 + 5) / (i5 + 2), 1, numFormulas, numCorrectas);
    evalua((i1 + i2) mod 5, 3, numFormulas, numCorrectas);
    evalua((i3 + 102) mod 5, 0, numFormulas, numCorrectas);
    --evalua(-i2 + (12 / -(i3 + 2)), -4, numFormulas, numCorrectas);

	-- Vectores
	evalua(arr(1) + arr(2), 3, numFormulas, numCorrectas);
    evalua(arr(i4) + arr(i3), 7, numFormulas, numCorrectas);
    evalua(arr(i2 + i1) + arr(i4 / 2), 5, numFormulas, numCorrectas);
    evalua(arr(arr(2)) + arr(arr(2) + 5), 2, numFormulas, numCorrectas);
	evalua(arr(arr(2)) * arr(arr(2)) / arr(arr(2)), 2, numFormulas, numCorrectas);
	------------------------------------------------------------------------
	put_line("Debería haber llegado aquí sin problemas léxicos o sintácticos.");
	put_line("De las ", numFormulas, " fórmulas, ", numCorrectas,
			" han dado el resultado correcto.");
end;