--------------------------------------------------------------------
procedure qsort is
-- https://en.wikipedia.org/wiki/Quicksort
--------------------------------------------------------------------
n, iteraciones: integer;
t: array(0..19) of integer;
--------------------------------------------------------------------
procedure inicializar (t: ref array(0..19) of integer) is
--------------------------------------------------------------------
 i: integer;
 begin
  i := 0;
  while i < n loop
    t(i) := n - i;
    i := i + 1;
  end loop;
 end;

--------------------------------------------------------------------
procedure mostrar (t: array(0..19) of integer) is
--------------------------------------------------------------------
  i: integer;
 begin
  i := 0;
  while i < n loop
    put(t(i), " ");
    i := i + 1;
  end loop;
  put(int2char(13),int2char(10));
 end;

--------------------------------------------------------------------
procedure intercambiar (i, j: ref integer) is
--------------------------------------------------------------------
 k: integer;
 begin
  k := i;
  i := j;
  j := k;
 end;

--------------------------------------------------------------------
procedure ordenar (i, j: ref integer) is
--------------------------------------------------------------------
 begin
  if i > j then
    intercambiar(i, j);
  end if;
 end;

--------------------------------------------------------------------
procedure divide (t: ref array(0..19) of integer; izq, der: integer; me: ref integer) is
--------------------------------------------------------------------
 p,k: integer;

 begin
  p := t(izq);
  k := izq;
  me := der + 1;
  k := k + 1;
  while (t(k) <= p) and (k < der) loop
   k := k + 1;
  end loop;
  me := me - 1;
  while (t(me) > p) loop
   me := me - 1;
  end loop;
  while k < me loop
    intercambiar(t(k), t(me));
    k := k + 1;
    while t(k) <= p loop
     k := k + 1;
    end loop;
    me := me - 1;
    while t(me) > p loop
     me := me - 1;
    end loop;
  end loop;
  intercambiar(t(izq), t(me));
 end;

--------------------------------------------------------------------
procedure quicksort (t: ref array(0..19) of integer; izq, der: integer) is
--------------------------------------------------------------------
 me: integer;
 begin
  if der > izq then
    mostrar(t);
    if (der - izq) = 1 then
     ordenar(t(izq), t(der));
    else
      divide(t, izq, der, me);
      quicksort(t, izq, me - 1);
      quicksort(t, me + 1, der);
      iteraciones := iteraciones + 1;
    end if;
  end if;
 end;

--------------------------------------------------------------------
begin
 put_line ("Ilustración del funcionamiento del algoritmo quicksort para ordenar 20 enteros.");
 put_line ("");

 n := 20;
 iteraciones := 0;
 inicializar (t);
 quicksort(t, 0, n-1);

 put_line ("");
 put_line ("Iteraciones: ", iteraciones);
end;
