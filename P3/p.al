procedure a is
z: integer;
a1: array(0..0) of boolean;

function func (b: ref array(0..0) of boolean) return integer is
begin
  return 1;
end;

begin
  z := func(a1);
end;