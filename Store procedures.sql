DELIMITER //
create procedure sp_insertarClienteNuevo(
	in p_nombre VARCHAR(50),
	in p_apellido_paterno VARCHAR(50),
	in p_apellido_materno VARCHAR(50),
	in p_fecha_nacimiento date,
	in p_usuario VARCHAR(30),
	in p_contraseña VARCHAR(30),
    in p_domicilio varchar(200)
    )
BEGIN
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK; 
	END;
    
    START transaction;
	SET AUTOCOMMIT = 0;

	insert clientes(nombres,apellido_paterno,apellido_materno,fecha_nacimiento,usuario,contraseña,domicilio)
    values (p_nombre, p_apellido_paterno, p_apellido_materno, p_fecha_nacimiento, p_usuario, p_contraseña,p_domicilio);

	set @id_cliente_ultimo = last_insert_id();
	
    insert into cuentas(estado,fecha_apertura,saldo,id_cliente) values ("Activa",now(),0.0,@id_cliente_ultimo);
    
    COMMIT; 
END //
DELIMITER ;

-- ACTUALIZACION DEL CLIENTE

DELIMITER &&
CREATE procedure sp_actualizar_cliente(
in p_id_cliente int,
in p_nombres VARCHAR(50),
in p_apellido_paterno VARCHAR(50),
in p_apellido_materno VARCHAR(50),
in p_fecha_nacimiento date,
in p_usuario VARCHAR(30),
in p_contraseña VARCHAR(30),
in p_domicilio varchar(200)
)
BEGIN
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN 
        ROLLBACK;
    END;

    START transaction;
    SET AUTOCOMMIT = 0;

    UPDATE clientes SET nombres = p_nombres,apellido_paterno = p_apellido_paterno,apellido_materno = p_apellido_materno,
    fecha_nacimiento = p_fecha_nacimiento,usuario = p_usuario,contraseña = p_contraseña,domicilio=p_domicilio 
    where id_cliente=p_id_cliente;
    
    COMMIT;
END && ;
DELIMITER ;

