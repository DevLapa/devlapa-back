CREATE TABLE movimentacoes (
                               id SERIAL PRIMARY KEY,
                               estoque_id BIGINT NOT NULL,
                               quantidade INTEGER NOT NULL,
                               tipo VARCHAR(20) NOT NULL,
                               motivo VARCHAR(255),
                               usuario_responsavel VARCHAR(100) NOT NULL,
                               data_hora TIMESTAMP NOT NULL,
                               CONSTRAINT fk_estoque FOREIGN KEY (estoque_id) REFERENCES estoque(id)
);