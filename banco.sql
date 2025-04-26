create database pets_db;

use pets_db;

-- 1. Proprietario
CREATE TABLE proprietario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20)
);

-- 2. Pet
CREATE TABLE pet (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    raca VARCHAR(100),
    cor VARCHAR(50),
    genero VARCHAR(20),
    proprietario_id BIGINT,
    CONSTRAINT fk_pet_proprietario FOREIGN KEY (proprietario_id) REFERENCES proprietario(id)
);

-- 3. Agendamento
CREATE TABLE agendamento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME NOT NULL,
    descricao VARCHAR(255),
    pet_id BIGINT,
    CONSTRAINT fk_agendamento_pet FOREIGN KEY (pet_id) REFERENCES pet(id)
);
