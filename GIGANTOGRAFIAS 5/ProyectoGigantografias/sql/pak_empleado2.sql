CREATE OR REPLACE PACKAGE pack_empleado AS TYPE empleadoREF IS REF CURSOR;
	
	PROCEDURE ingresar_sistema(
				u_usuario IN VARCHAR2,
				u_password IN VARCHAR2,
	
				resultado IN OUT empleadoREF
				);
	PROCEDURE buscar(
				u_usuario IN VARCHAR2,
				resultado IN OUT empleadoREF
				);

PROCEDURE ingreso(
						
			u_usuario IN VARCHAR2,
                       u_password IN VARCHAR2,
			u_nombre IN VARCHAR2,
                       u_apellido IN VARCHAR2,
                       u_cedula IN VARCHAR2,
                       u_direccion IN VARCHAR2,
			u_telefono IN VARCHAR2,
			u_departamento IN VARCHAR2,
                       u_tipo IN VARCHAR2
			
			);

PROCEDURE buscarXcedula(
				
				u_cedula IN VARCHAR2,
				resultado IN OUT empleadoREF
	);

PROCEDURE modificar(
						
			u_usuario IN VARCHAR2,
                       u_password IN VARCHAR2,
			u_nombre IN VARCHAR2,
                       u_apellido IN VARCHAR2,
                       u_cedula IN VARCHAR2,
                       u_direccion IN VARCHAR2,
			u_telefono IN VARCHAR2,
			u_departamento IN VARCHAR2,
                       u_tipo IN VARCHAR2);

PROCEDURE mostrar(
				resultado IN OUT empleadoREF);

PROCEDURE eliminar(
				u_usuario IN VARCHAR2);

	
END pack_empleado;

CREATE OR REPLACE PACKAGE BODY pack_empleado AS
	

PROCEDURE ingresar_sistema(
				u_usuario IN VARCHAR2,
				u_password IN VARCHAR2,
				resultado IN OUT empleadoREF
				)AS
	  BEGIN
		OPEN resultado FOR SELECT * FROM empleado  WHERE usuario = u_usuario AND password = u_password;
	END ingresar_sistema;
	
PROCEDURE buscar(
				u_usuario IN VARCHAR2,
				resultado IN OUT empleadoREF
				)AS
		BEGIN
		OPEN resultado FOR SELECT * FROM empleado WHERE usuario = u_usuario ;
	END buscar ;






PROCEDURE ingreso(
						
			u_usuario IN VARCHAR2,
                       u_password IN VARCHAR2,
			u_nombre IN VARCHAR2,
                       u_apellido IN VARCHAR2,
                       u_cedula IN VARCHAR2,
                       u_direccion IN VARCHAR2,
			u_telefono IN VARCHAR2,
			u_departamento IN VARCHAR2,
                       u_tipo IN VARCHAR2
			

				)AS
	  BEGIN
		INSERT INTO empleado( usuario,password, nombre , apellido ,cedula,direccion ,telefono, departamento,tipo )
		VALUES(u_usuario, u_password,u_nombre , u_apellido ,u_cedula ,u_direccion,u_telefono,u_departamento,u_tipo);
	END ingreso;
	
PROCEDURE buscarXcedula(
				
				u_cedula IN VARCHAR2,
				resultado IN OUT empleadoREF
				)AS
	  BEGIN
		OPEN resultado FOR SELECT * FROM empleado WHERE cedula = u_cedula;
	END buscarXcedula;

PROCEDURE modificar(
						
			u_usuario IN VARCHAR2,
                       u_password IN VARCHAR2,
			u_nombre IN VARCHAR2,
                       u_apellido IN VARCHAR2,
                       u_cedula IN VARCHAR2,
                       u_direccion IN VARCHAR2,
			u_telefono IN VARCHAR2,
			u_departamento IN VARCHAR2,
                       u_tipo IN VARCHAR2
					   
				)AS
	  BEGIN
		UPDATE empleado SET usuario=u_usuario, password=u_password,nombre = u_nombre, apellido = u_apellido,  direccion= u_direccion,telefono = u_telefono, departamento=u_departamento, tipo=u_tipo
		WHERE cedula= u_cedula ;
		COMMIT;
	END modificar;
	
PROCEDURE mostrar(
				resultado IN OUT empleadoREF
				)AS
	  BEGIN
		OPEN resultado FOR SELECT * FROM empleado;
	END mostrar;
	
PROCEDURE eliminar(
				u_usuario IN VARCHAR2
				)AS
	  BEGIN
		DELETE FROM empleado
		WHERE usuario = u_usuario;
	END eliminar;
	

	
END pack_empleado;
