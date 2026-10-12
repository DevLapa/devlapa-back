CREATE TABLE categorias(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) UNIQUE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL
);