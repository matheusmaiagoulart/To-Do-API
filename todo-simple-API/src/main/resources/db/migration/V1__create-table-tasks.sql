create table Tasks (

id bigint not null auto_increment,
titulo varchar(60) not null,
descricao varchar(300) not null,
status varchar (20) not null,

primary key(id)
);