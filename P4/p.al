procedure main is
ai : array(0..3) of integer;
i: integer;

    function p (aiv : array(0..3) of integer; air: ref array(0..3) of integer) return integer is
    begin
        air(0) := air(3);
        aiv(0) := aiv(3);

        aiv(1) := p (air, air);
        return 0;
    end;
    
begin
    ai(i*2) := p (ai, ai);
end;

  ENP L0
L1:
  SRF  0  7
  ASGI 
  SRF  0  6
  ASGI 
  SRF  0  5
  ASGI 
  SRF  0  4
  ASGI 
  SRF  0  3
  ASGI 
  JMP L2
L2:
  STC  0
  STC  0
  SBT 
  SRF  0  7
  DRF 
  PLUS 
  STC  3
  STC  0
  SBT 
  SRF  0  7
  DRF 
  PLUS 
  DRF 
  ASG 
  STC  0
  STC  0
  SBT 
  SRF  0  3
  PLUS 
  STC  3
  STC  0
  SBT 
  SRF  0  3
  PLUS 
  DRF 
  ASG 

  STC  1
  STC  0
  SBT 
  SRF  0  3
  PLUS      ; @aiv + 1

  SRF  0  7
  DRF 
  STC  0
  PLUS 
  DRF       ; air[0]

  SRF  0  7
  DRF 
  STC  1
  PLUS 
  DRF 

  SRF  0  7
  DRF 
  STC  2
  PLUS 
  DRF 

  SRF  0  7
  DRF 
  STC  3
  PLUS 
  DRF       ; air[3]

  SRF  0  7 ; @@air
  DRF       ; @air
  OSF  8  1 L1
  ASG 
  STC  0
  CSF 
  CSF 
L0:
  SRF  0  7
  DRF 
  STC  2
  TMS 

  STC  0
  SBT 
  SRF  0  3
  PLUS 
  
  SRF  0  3
  DRF 
  SRF  0  4
  DRF 
  SRF  0  5
  DRF 
  SRF  0  6
  DRF 

  SRF  0  3
  OSF  8  0 L1
  ASG 

  LVP 


teachers
