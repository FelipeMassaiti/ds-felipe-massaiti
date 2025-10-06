
CREATE DATABASE escola;
USE escola;
CREATE TABLE aluno(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    turma VARCHAR(50)

);
CREATE TABLE funcionarios(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    setor VARCHAR(50),
    salario DECIMAL(10, 2)

);
CREATE TABLE cursos(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    n_de_aulas INT NOT NULL,
    duracao_em_meses INT NOT NULL,
    n_de_professores INT NOT NULL,
    n_de_materias_tecnicas INT NOT NULL,
    n_de_alunos INT NOT NULL,
    salario_medio DECIMAL(10, 2)
);
CREATE TABLE despesas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    salario_funcionarios DECIMAL(10, 2),
    despesas_manutencao DECIMAL(10, 2),
    despesas_material DECIMAL(10, 2),
    despesas_outros DECIMAL(10, 2)
);
    
