
DELIMITER //
CREATE TRIGGER calcular_edad_cliente BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    SET NEW.edad = TIMESTAMPDIFF(YEAR, NEW.fecha_nacimiento, CURDATE());
END;
//
DELIMITER ;

DELIMITER $$

CREATE TRIGGER generar_numero_cuenta
BEFORE INSERT ON cuentas
FOR EACH ROW
BEGIN
    DECLARE numero_cuenta BIGINT;
    SET numero_cuenta = FLOOR(100000 + RAND() * 900000); 
    SET NEW.numero_cuenta = numero_cuenta; 
END$$

DELIMITER ;

DELIMITER {{
CREATE TRIGGER modifica_saldo
BEFORE INSERT ON cuentas

DELIMITER ;

