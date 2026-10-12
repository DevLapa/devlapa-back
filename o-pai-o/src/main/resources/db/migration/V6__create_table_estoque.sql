CREATE TABLE estoque (
                         id SERIAL PRIMARY KEY,
                         produto_id BIGINT NOT NULL,
                         quantidade INTEGER NOT NULL,
                         minimo INTEGER NOT NULL,
                         status VARCHAR(50) NOT NULL,
                         data_cadastro TIMESTAMP NOT NULL,
                         data_modificacao TIMESTAMP,
                         CONSTRAINT fk_estoque_produto FOREIGN KEY (produto_id) REFERENCES produtos(id)
);