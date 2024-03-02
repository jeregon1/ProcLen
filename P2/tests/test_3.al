-- function failure return integer is -- ERROR porque un procedimiento debe englobar todo el programa
procedure test_2 is

--------------------------------------------------------------------------
begin
    -- // Esto NO es un comentario -- ERROR porque los comentarios empiezan con '--' 
    -- else null; end if; -- ERROR porque no hay bloque if antes

    -- if _ then end if; -- ERROR porque no hay instrucciones en el bloque if
    -- while _ loop end loop; -- ERROR porque no hay instrucciones en el bloque while


    null;
end;