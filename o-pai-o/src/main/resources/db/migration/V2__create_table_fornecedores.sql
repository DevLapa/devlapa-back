CREATE  TABLE fornecedores(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(100),
    telefone VARCHAR(100) NOT NULL,
    email VARCHAR(200),
    endereco VARCHAR(255),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_cadastro TIMESTAMP NOT NULL
);