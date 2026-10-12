CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    preco DECIMAL(10,2) NOT NULL CHECK (preco >= 0),
    unidade VARCHAR(20) NOT NULL,
    categoria_id INT NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    fornecedor_id INT,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categorias(id),

    CONSTRAINT fk_produto_fornecedor
        FOREIGN KEY (fornecedor_id)
        REFERENCES fornecedores(id)
);

CREATE INDEX idx_produto_fornecedor ON produtos(fornecedor_id);
CREATE INDEX idx_produto_categoria ON produtos(categoria_id);