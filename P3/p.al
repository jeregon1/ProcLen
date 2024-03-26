procedure a is
z: character;
a1: array(-1..1) of integer;
a2: array(0..1) of integer;

function func (b, a: character; c, d: array(-1..1) of integer) return integer is
begin
  return 1;
end;

begin
    
  z := func('a', 'b', a1, a2);
  null;
end;