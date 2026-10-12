CREATE TABLE vendas(
                       id SERIAL PRIMARY KEY,
                       usuario_id INT NOT NULL,
                       formaDePagamento_id INT NOT NULL,
                       valor_total DECIMAL(10,2),
                       status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
                       data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT fk_vendas_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
                       CONSTRAINT fk_vendas_formaDePagamento FOREIGN KEY (formaDePagamento_id) REFERENCES formas_de_pagamentos(id)
);

CREATE TABLE itens_vendas(
                             id SERIAL PRIMARY KEY,
                             vendas_id INT NOT NULL,
                             produto_id INT NOT NULL,
                             quantidade INT NOT NULL,
                             preco_unitario DECIMAL (10, 2) NOT NULL,
                             sub_total DECIMAL (10, 2) NOT NULL,

                             CONSTRAINT fk_itens_vendas_vendas FOREIGN KEY (vendas_id) REFERENCES vendas(id),
                             CONSTRAINT fk_itens_vendas_produto FOREIGN KEY (produto_id) REFERENCES produtos(id)
);