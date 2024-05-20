procedure main is
i: integer;
    procedure a1 is
        function main return integer is
            procedure a3 is
            i: integer;
            begin
                i := main;
            end;
        begin
            return 0;
        end;
    begin
        null;
    end;


begin
    null;
end;


  ENP L0
L1:
  JMP L2
L3:
  JMP L4
L4:
  CSF 
L2:
  OSF  3  0 L3
  CSF 
L0:
  LVP 
