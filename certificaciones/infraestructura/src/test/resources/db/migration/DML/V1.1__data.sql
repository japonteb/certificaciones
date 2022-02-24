insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());
insert into certificacion(id, nombre,detalle,duracion, precio) values(1,'test nombre','test detalle',120,500000);
insert into certificacion(id, nombre,detalle,duracion, precio) values(2,'test nombre 2','test detalle 2',120,500000);
insert into cliente(id, nombre,tipo_cliente) values(1,'test nombre',1);
insert into examen(id, cliente_id,certificacion_id,fecha_presentacion, precio_total) values(1,1,1,now(),500000);