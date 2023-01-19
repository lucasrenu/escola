# escola
Trabalho de Programação Orientada a Objetos, sistema CRUD usando JDBC, MariaDB e JavaFX.

---

### Membros:
Este projeto foi desenvolvido por *Lucas Renu* e *[Sávio Rodrigues](https://github.com/rodriguessavio)*.

## Sobre:
- **Tecnologias**: Java;
- **Bibliotecas:** JavaFx e Jdbc;
- **Gerenciador de Pacotes:** Maven
- **Descrição:** Este projeto é um sistema de CRUD para a classe do tipo Professor, foi implementado utilizando o banco de dados MariaDB;

## Ajuda:
### Banco de Dados:
**MariaDB**

USER: local

SENHA: toor


```sql
-- Comando para criação da base de dados.
create database escola;
use escola;
create table professor(
    id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(45) NOT NULL,
    salario NUMERIC(9,2) NOT NULL,
    titulacao VARCHAR(30) NOT NULL,
    especializacao VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
);
INSERT INTO professor(cpf, nome, salario, titulacao, especializacao) VALUES("01928374651", "Nananin Nananan", 3000.00, "Bacharel", "Física");
```

Onde configurar a conexão com o banco de dados? [aqui](./src/main/java/com/utils/ProfessorDAO.java).