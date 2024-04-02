procedure Programa is
b: boolean;
i: integer;
c: character;

ai: array (1..10) of integer;
ab: array (1..10) of boolean;
ac: array (1..10) of character;

procedure pi(i: ref integer) is
begin  null; end;

procedure pb(b: ref boolean) is
begin  null; end;

function fi(a,b,c,d: integer) return integer is
begin  return 0; end;

begin 
  pi (ai(3 + i));
  pb (b and b);

  ai(fi(1,2,3,4)) := 1;
end;
