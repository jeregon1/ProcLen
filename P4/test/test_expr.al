procedure Programa is
i: integer;
b: boolean;
c: character;
ai: array(1..10) of integer;
ab: array(1..10) of boolean;

begin

-- PRUEBA--> OPERADORES (hacer)
-- Los operadores aritméticos (+, -, *, /, mod) sólo admiten operandos de tipo integer.
i := c + 'c'; -- Error: se esperaba un entero
i := i - b; -- Error: se esperaba un entero
i := i * ai; -- Error: se esperaba un entero
i := i + ai(1);
i := i / true; -- Error: se esperaba un entero
i := i + ai(1) mod 2 - 3 * 4 / 5; -- Error: se esperaba un entero

-- Los operadores relacionales (<, <=, >, >=, =, /=) admiten operandos del mismo tipo.
b := i < c; -- Error: tipos distintos
b := b > c; -- Error: tipos distintos
b := char2int('3') <= i;
b := '3' >= c;
b := i = ai(1);
b := ai /= ai; -- Error: se debe acceder al array en una expresión
b := ai(1) = ai(2);
b := int2char(3) > '2' = true;

-- Los operadores lógicos (and, or, not) admiten operandos de tipo boolean.


end;