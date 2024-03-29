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

DELIMITER }}
CREATE procedure sp_iniciarSesion(
	IN p_usuario varchar(30),
	IN p_contra varchar(30),
	out p_id int,
	out p_nombres varchar(50),
	out p_apellidoP varchar(50),
	out p_apellidoM varchar(50),
	out p_fechaNac date ,
	out p_domicilio varchar(200)

)
BEGIN
	DECLARE vExisteUsuario INT;
	SELECT COUNT(*) INTO vExisteUsuario FROM clientes WHERE usuario = p_usuario AND contraseña = p_contra;
    
    if vExisteUsuario = 1 then
    select id_cliente,nombres,apellido_paterno,apellido_materno,domicilio,fecha_nacimiento into p_id,p_nombres,p_apellidoP,p_apellidoM,p_domicilio,p_fechaNac from clientes where usuario = p_usuario;
    else
     set p_id= 0;
     set p_nombres= null;
	 set p_apellidoP= null;
	 set p_apellidoM= null;
	 set p_fechaNac= null;
	 set p_domicilio= null;
     end if;
     
     end }};
DELIMITER ;

DELIMITER ??
CREATE procedure sp_todasCuentas(
	in p_idC int,
    out p_numero int,
    out p_estado varchar(10),
    out p_fecha date,
    out p_saldo float
)
BEGIN
	Select numero_cuenta,estado,fecha_apertura,saldo into p_numero,p_estado,p_fecha,p_saldo from cuentas where id_cliente=p_idC;
end??
DELIMITER ;

DELIMITER ll
create procedure sp_crearCuenta(
	in p_idCliente int
)
begin
	insert into cuentas(estado,fecha_apertura,saldo,id_cliente) values ("Activa",now(),0.0,p_idCliente);
	
end ll
DELIMITER ;

DELIMITER !!
CREATE PROCEDURE sp_movimientoTransferencia(
    IN p_numeroCuentaO INT,
    IN p_numeroCuentaD INT,
    IN p_monto DECIMAL(10, 2)
)
BEGIN
    DECLARE p_saldoO DECIMAL(10, 2);
    DECLARE p_saldoD DECIMAL(10, 2);
    DECLARE p_idCuentaO INT;
    DECLARE p_idCuentaD INT;

    START TRANSACTION;

    SELECT saldo, id_cuenta INTO p_saldoO, p_idCuentaO FROM cuentas WHERE numero_cuenta = p_numeroCuentaO;

    IF p_saldoO IS NULL OR p_saldoO < p_monto THEN
        ROLLBACK;
    ELSE
        SELECT id_cuenta INTO p_idCuentaD FROM cuentas WHERE numero_cuenta = p_numeroCuentaD;

        IF p_idCuentaD IS NULL THEN
            ROLLBACK;
        ELSE

            UPDATE cuentas SET saldo = saldo - p_monto WHERE id_cuenta = p_idCuentaO;
            UPDATE cuentas SET saldo = saldo + p_monto WHERE id_cuenta = p_idCuentaD;

            INSERT INTO operaciones (tipo, fecha_hora, monto, id_cuenta) VALUES ('Transferencia', NOW(), p_monto, p_idCuentaO);
            SET @id_operacion = LAST_INSERT_ID();

            INSERT INTO transferencias (id_operacion) VALUES (@id_operacion);

            
            COMMIT;
        END IF;
    END IF;
END!!
DELIMITER ;


/*
DELIMITER ¡¡
CREATE procedure sp_generarRetiro(
	in p_idCuenta int,
    in p_monto float(10.2),
    out p_folio int,
    out p_contraseña int

)
begin
	Declare p_fechaS datetime;
    declare p_fechaL datetime;
    declare p_


end ¡¡
DELIMITER ;*/