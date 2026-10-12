CREATE TABLE contas_receber (
    id SERIAL PRIMARY KEY,
    cliente VARCHAR(255),
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(12, 2) NOT NULL CHECK (valor >= 0),
    data_vencimento DATE NOT NULL,
    data_recebimento DATE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    comanda_id INT,
    user_criacao_id INT NOT NULL,

    CONSTRAINT fk_contas_comanda
        FOREIGN KEY (comanda_id)
            REFERENCES comandas(id),

    CONSTRAINT fk_contas_user
        FOREIGN KEY (user_criacao_id)
            REFERENCES usuarios(id),

    CONSTRAINT chk_status_contas_receber
        CHECK (status IN ('PENDENTE', 'PAGA', 'CANCELADA', 'RECEBIDO'))
);
