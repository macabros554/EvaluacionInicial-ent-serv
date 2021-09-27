DROP TABLE cliente;
DROP TABLE empleado;
DROP TABLE producto;
DROP TABLE PROVEEDOR;


CREATE TABLE proveedor (
nombre varchar2(32),
cantidad NUMBER (5),
codigo NUMBER (10) PRIMARY KEY,
fecha_salida DATE,
fecha_entrega DATE
);

CREATE TABLE producto(
nombre varchar2(32),
codigoProveedo NUMBER (10),
codigoProducto number(10) PRIMARY KEY,
cantidad NUMBER (5),
precio_unidad decimal (7,2),
CONSTRAINT codigoProv FOREIGN KEY (codigoProveedo) REFERENCES proveedor(codigo)
);

CREATE TABLE empleado( 
nombre varchar2(32),
dni varchar2(9),
codEmpleado NUMBER(10) PRIMARY KEY ,
codProducto number(10),
salario NUMBER (4),
CONSTRAINT codigoProvEmp FOREIGN KEY (codProducto) REFERENCES producto(codigoProducto)
);
 
CREATE TABLE cliente(
nombre varchar2(32),
dni NUMBER (9),
codCliente NUMBER (10) primary key,
Producto varchar2(32),
codProducto number(10),
codEmpleado number(10),
CONSTRAINT codigoProvCli FOREIGN KEY (codProducto) REFERENCES producto(codigoProducto),
CONSTRAINT codigitoEmpleado FOREIGN KEY (codEmpleado) REFERENCES empleado(codEmpleado)
);

INSERT INTO PROVEEDOR VALUES ('RTX 3080',200,13,'2-3-2025','2-6-2026');
INSERT INTO PROVEEDOR VALUES ('SSD Kingston 500GB',100,14,'2-3-2025','2-6-2026');
INSERT INTO PROVEEDOR VALUES ('GTX 1660 SUPER',600,15,'2-3-2025','2-6-2026');
INSERT INTO PROVEEDOR VALUES ('RX 210',20,16,'2-3-2030','2-6-2031');


INSERT INTO producto VALUES ('RTX 3080',13,14,300,3000.99);
INSERT INTO producto VALUES ('SSD Kingston 500GB',14,15,200,39.90);
INSERT INTO producto VALUES ('GTX 1660 SUPER',15,16,610,1200);
INSERT INTO producto VALUES ('RX 210',16,17,20,400);

INSERT INTO empleado VALUES ('Manolo',111111111,1,14,1200);
INSERT INTO empleado VALUES ('Pepe',111111113,2,14,1100);
INSERT INTO empleado VALUES ('Antonio',111111114,3,15,1000);
INSERT INTO empleado VALUES ('El tonto',111111115,4,16,1400);

INSERT INTO cliente VALUES ('Manue',111111115,12,'La el disco solido',14,1);
INSERT INTO cliente VALUES ('Pepito',111111116,14,'El disco duro',14,1);
INSERT INTO cliente VALUES ('Montaito de lomo',111111117,15,'La 1660',15,3);
INSERT INTO cliente VALUES ('Tortilla de patatas',111111118,16,'La 3080',14,1);

UPDATE EMPLEADO SET CODPRODUCTO = 15
WHERE CODEMPLEADO = 2;

UPDATE CLIENTE SET NOMBRE = 'Federico'
WHERE CODCLIENTE = 1;

UPDATE CLIENTE SET NOMBRE = 'Ramon'
WHERE CODCLIENTE = 3;


DELETE FROM CLIENTE c WHERE CODCLIENTE = 16;

SELECT * FROM CLIENTE c ;

SELECT NOMBRE o FROM EMPLEADO e
WHERE CODPRODUCTO = 14;

SELECT NOMBRE FROM EMPLEADO e 
WHERE NOMBRE LIKE 'Ma%';

SELECT NOMBRE FROM EMPLEADO e 
WHERE NOMBRE LIKE 'Ma_o_o';

SELECT NOMBRE FROM EMPLEADO e 
WHERE NOMBRE LIKE 'M%o';

SELECT NOMBRE FROM EMPLEADO e 
WHERE NOMBRE LIKE '%o';

SELECT NOMBRE,CODEMPLEADO FROM EMPLEADO e 
WHERE CODEMPLEADO BETWEEN 0 AND 2;

SELECT NOMBRE,CODEMPLEADO FROM EMPLEADO e 
WHERE CODEMPLEADO >= 2;

SELECT NOMBRE FROM EMPLEADO e 
ORDER BY NOMBRE ASC;

SELECT MAX(CODPRODUCTO) AS codigoMasAlto FROM EMPLEADO e;

SELECT COUNT(NOMBRE) AS NumeroDeClientes FROM CLIENTE c ;

SELECT sum(SALARIO) AS TotalSalarioEmp FROM EMPLEADO e ;

SELECT e.SALARIO ,e.NOMBRE FROM EMPLEADO e
WHERE e.SALARIO > (SELECT AVG(e2.SALARIO) from EMPLEADO e2) ; 
