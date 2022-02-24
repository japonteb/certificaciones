create table usuario (
 id int not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table certificacion (
 id int not null auto_increment,
 nombre varchar(100) not null,
 detalle varchar(200) not null,
 duracion int not null,
 precio float not null,
 primary key (id)
);

create table cliente (
 id int not null auto_increment,
 nombre varchar(100) not null,
 tipo_cliente int not null,
 primary key (id)
);

create table examen (
 id int not null auto_increment,
 cliente_id int not null,
 certificacion_id int not null,
 fecha_presentacion datetime not null,
 precio_total float not null,
 primary key (id),
 FOREIGN KEY (cliente_id) REFERENCES cliente(id),
 FOREIGN KEY (certificacion_id) REFERENCES certificacion(id)
);