--------------------------------------------------------------------------
procedure hanoi_towers is
-- algoritmo recurso para resolver las torres de hanoi
-- https://en.wikipedia.org/wiki/Tower_of_Hanoi#Recursive_solution
--------------------------------------------------------------------------
steps, n: integer;

--------------------------------------------------------------------------
procedure hanoi (n: integer; source, target, spare: character) is

--------------------------------------------------------------------------
 begin
  if n = 1 then
    put_line ("Move disk from tower ", source, " to tower ", target, ". ");
    steps := steps + 1;
  else
    hanoi (n - 1, source, spare, target);
    hanoi (1, source, target, spare);
    hanoi (n - 1, spare, target, source);
  end if;
 end;
--------------------------------------------------------------------------

begin
 put_line;
 put_line ("Recursive algorithm to solve the Hanoi Towers problem.");
 put_line ("https://en.wikipedia.org/wiki/Tower_of_Hanoi#Recursive_solution");
 put_line;

 steps := 0;
 n := 3;

 put_line ("Solving for ", n, " disks.");
 put_line;

 hanoi (n, 'A', 'C', 'B');

 put_line;
 put_line ("Finished in ", steps, " steps.");
end;
