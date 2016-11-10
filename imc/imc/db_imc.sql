create database db_imc;
use db_imc;

create table tblimc (
  id int(2) not null primary key,
  rangodesde float not null,
  rangohasta float not null,
  concepto varchar(200) not null
);

create table tblpersona (
  id int(11) not null auto_increment primary key,
  nombre varchar(50) not null,
  edad int(3) not null,
  peso float not null,
  estatura float not null, 
  sexo varchar(20) not null,
  fuma int(1) not null,
  bebe int(1) not null
);

create table tbltratamiento (
  id int(11) not null auto_increment primary key,
  id_imc int(2) not null,
  tratamiento varchar(500) not null
);

alter table tbltratamiento
  add constraint fk_tbltratamiento_tblimc foreign key (id_imc) references tblimc (id);

insert into tblimc(id,rangodesde,rangohasta,concepto) values(1,0.0,18.49,'Peso insuficientre. Menos de 53.4 kg.'); 
insert into tblimc(id,rangodesde,rangohasta,concepto) values(2,18.5,24.9,'Peso normal. Entre 53.46 y 72.22 kg.'); 
insert into tblimc(id,rangodesde,rangohasta,concepto) values(3,25,26.9,'Sobrepeso grado I. Entre 72.25 y 78 kg.'); 
insert into tblimc(id,rangodesde,rangohasta,concepto) values(4,27,29.9,'Sobrepeso grado II(preobesidad). Entre 78.06 y 86.67 kg.'); 
insert into tblimc(id,rangodesde,rangohasta,concepto) values(5,30,34.9,'Obesidad de tipo I. Entre 86.07 y 101.12 kg.');
insert into tblimc(id,rangodesde,rangohasta,concepto) values(6,35,39.9,'Obesidad de tipo II. Entre 101.15 y 115.57 kg.'); 
insert into tblimc(id,rangodesde,rangohasta,concepto) values(7,40,49.9,'Obesidad de tipo III(mórbida). Entre 115.06 y 144.47 kg.');
insert into tblimc(id,rangodesde,rangohasta,concepto) values(8,50,1000,'Obesidad de tipo IV(extrema). Más de 144.5 kg.');