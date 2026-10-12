CREATE TABLE contas_pagar (
                              id SERIAL PRIMARY KEY,
                              fornecedor_id INT NOT NULL,
                              user_criacao_id INT NOT NULL,
                              descricao VARCHAR(255) NOT NULL,
                              valor DECIMAL(12,2) NOT NULL CHECK (valor >= 0),
                              data_vencimento DATE NOT NULL,
                              data_pagamento DATE,
                              categoria VARCHAR(100),
                              status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',

                              CONSTRAINT fk_conta_fornecedor
                                  FOREIGN KEY (fornecedor_id)
                                      REFERENCES fornecedores(id),

                              CONSTRAINT fk_conta_usuario
                                  FOREIGN KEY (user_criacao_id)
                                      REFERENCES usuarios(id),

                              CONSTRAINT chk_status_contas_pagar
                                  CHECK (status IN ('PENDENTE', 'PAGA', 'CANCELADA'))
);
