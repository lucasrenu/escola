create database escola;
use escola;
create table professor(
    id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(35) NOT NULL,
    salario NUMERIC(9,2) NOT NULL,
    titulacao VARCHAR(20) NOT NULL,
    especializacao VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);
INSERT INTO professor(cpf, nome, salario, titulacao, especializacao) VALUES("01928374651", "Nananin Nananan", 3000.00, "Bacharel", "Física");