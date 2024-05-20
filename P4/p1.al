procedure main is
i: integer;
c: character;
b: boolean;


begin
    i := 0;
    while i + 1 < 10 loop
        if b then
            c := int2char(i);
            b := char2int(c) mod 3 = i and not (not b or c = 'a');
            i := i + 1;
        else
            exit;
        end if;
    end loop;
end;

  ENP L0
L0:
  SRF  0  3
  STC  0
  ASG 
L1:
  SRF  0  3
  DRF 
  STC  1
  PLUS 
  STC 10
  LT 
  JMF L2
  SRF  0  5
  DRF 
  JMF L3
  SRF  0  4
  SRF  0  3
  DRF 
  ASG 
  SRF  0  5
  SRF  0  4
  DRF 
  STC  3
  MOD 
  SRF  0  3
  DRF 
  EQ 
  SRF  0  5
  DRF 
  NGB 
  SRF  0  4
  DRF 
  STC 97
  EQ 
  OR 
  NGB 
  AND 
  ASG 
  SRF  0  3
  SRF  0  3
  DRF 
  STC  1
  PLUS 
  ASG 
  JMP L4
L3:
  LVP 
L4:
  JMP L1
L2:
  LVP 

