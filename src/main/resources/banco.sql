create database escola;
use escola;
create table professor(
    cpf varchar(11) not null,
    nome varchar(35) not null,
    salario numeric(9,2) not null,
    titulacao varchar(20) not null,
    especializacao varchar(20) not null,
    primary key(cpf));