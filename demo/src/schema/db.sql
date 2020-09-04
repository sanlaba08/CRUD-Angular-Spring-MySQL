drop database personas;
create database personas;
use personas;

create table personas(
	id Integer auto_increment,
	nombre Varchar(50) not null,
    apellido Varchar(50) not null,
	
	constraint pk_personas_id primary key (id)
);
