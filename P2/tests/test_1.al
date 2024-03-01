procedure test_1 is


function vivira2 (colonia: ref array(1..80) of boolean; i: integer) return boolean is
    vivos: integer;
begin
    vivos := 0;
    if i > 1 then 


        if colonia(i-1) then 
            vivos := vivos + 1; 
        end         if; 
    end 
                             if;

    if not colonia(i) then
        return (vivos = 2) or (vivos = 3);
    else
        return (vivos = 2) or (vivos = 4);
    end if;
end;

begin 

end;