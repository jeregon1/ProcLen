------------------------------------------------------------------------
--  expresiones_bool.al
--  Todas son correctas
------------------------------------------------------------------------
procedure exps is
	i1,i2,i3,i4,i5: integer;
	b,b1,b2,b3,b4,b5,b6: boolean;
	numFormulas,numTrues: integer;
------------------------------------------------------------------------	
procedure evalua(b: boolean; numFormulas,numTrues: ref integer) is
begin
	if b then
		numTrues := numTrues + 1;
	end if;
	numFormulas := numFormulas + 1;
end;
------------------------------------------------------------------------
begin
	put_line("-----------------------------------------------------");
	numFormulas := 0;
	numTrues := 0;
	b1 := true; b2 := true; b3 := true; b4 := true; b5 := true; b6 := true;
	i1 := 1; i2 := 2; i3 := 3; i4 := 4; i5 := 5;
	put_line("Este programa evalúa un conjunto de expresiones booleanas correctas");
	evalua(true and true and not true and 3>5 and 6>5,numFormulas,numTrues);
	evalua(b1 and (b2 or b3),numFormulas,numTrues);
	evalua(((not b1) or b2) and (b3 or b4) and (b5 and b6),numFormulas,numTrues);
	evalua((b1 and b2) or ((b3 or b4) and (not b5)),numFormulas,numTrues);
	evalua((b1 and not b2) or (b3 or b4),numFormulas,numTrues);
	evalua((not b1) and (not b2) and (not b3),numFormulas,numTrues);
	evalua((b1 and b2) or (b3 and b4),numFormulas,numTrues);
	evalua((b1 and b2) or (not b3) or (b4 and b5),numFormulas,numTrues);
	evalua(not (b1 and b2) or (b3 and not b4),numFormulas,numTrues);
	evalua((b1 and b2) = (b3 or b4),numFormulas,numTrues);
	evalua((b1 or b2) or (not b3),numFormulas,numTrues);
	evalua((b1 or b2) and (b3 or b4) and (b5 or b6),numFormulas,numTrues);
	evalua(not ((b1 and b2) = (b3 or b4)),numFormulas,numTrues);
	evalua((b1 or b2) or (b3 or b4) or (b5 or b6),numFormulas,numTrues);
	evalua((b1 and b2) and not (b3 and b4),numFormulas,numTrues);
	evalua(not (b1 or b2) or (b3 and b4),numFormulas,numTrues);
	evalua((b1 and b2) = (b3 and b4),numFormulas,numTrues);
	evalua((b1 or b2) and (b3 or b4) and (b5 or b6),numFormulas,numTrues);
	evalua(not (b1 or b2 or b3),numFormulas,numTrues);

	evalua(i1 > 10 and i2 <= 5,numFormulas,numTrues);
	evalua((i1 + i2) * 2 >= i3 - i4,numFormulas,numTrues);
	evalua((i1 > 0 and i2 < 100) or i3 = 42,numFormulas,numTrues);
	evalua((i1 * i2) = (i3 + i4),numFormulas,numTrues);
	evalua((i1 >= 20 and (i2 < 5 or i3 >= 10)),numFormulas,numTrues);
	evalua(i1 mod 3 = 0 or i2 mod 2 = 1,numFormulas,numTrues);
	evalua((i1 / 2) > 10 and i3 = 7,numFormulas,numTrues);
	evalua((i1 - i2) >= 5 or (i3 + i4) < 100,numFormulas,numTrues);
	evalua((i1 / 5) = (i2 / 2) and i3 > 10,numFormulas,numTrues);
	evalua((i1 + i2 * 3) >= (i3 / 2) or i4 = 7,numFormulas,numTrues);
	evalua((i1 / 10) = (i2 mod 4) and i3 > 20,numFormulas,numTrues);
	evalua((10 <= i1) and (i2 < 5 or i3 >= 15),numFormulas,numTrues);
	evalua((i1 * i2) > (i3 + i4),numFormulas,numTrues);
	evalua(not (i1 >= 0) and (i2 < 100),numFormulas,numTrues);
	evalua((i1 = i2) or (i3 = i4),numFormulas,numTrues);
	evalua((i1 / 2) /= i2 and i3 > 5,numFormulas,numTrues);
	evalua((i1 + i2) mod 7 = (i3 * i4) mod 10 or i5 >= 3,numFormulas,numTrues);
	evalua((i1 + i2) > 50 or (i3 + i4) < 100,numFormulas,numTrues);
	evalua((i1 = i2) and (i3 > i4),numFormulas,numTrues);
	------------------------------------------------------------------------
	put_line("Debería haber llegado aquí sin problemas léxicos o sintácticos");
	put_line("y dar 38 fórmulas y 19 TRUES.");
	put_line(int2char(9),"numFormulas: ",numFormulas);
	put_line(int2char(9),"num TRUES:   ",numTrues);
end;