procedure a is
z: integer;
a1: array(-1..1) of integer;
a2: array(0..1) of integer;

function func (b, a: ref character) return integer is
begin
  return 1;
end;

begin
  z := func(a1, a2);
  a1(0);
end;