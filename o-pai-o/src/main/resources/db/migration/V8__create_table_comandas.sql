CREATE TABLE comandas (
 id SERIAL PRIMARY KEY,
  numero_mesa INT NOT NULL,
  nome_cliente VARCHAR(100),
  status VARCHAR(20) NOT NULL DEFAULT 'ABERTA',
  valor_total DECIMAL(10, 2) DEFAULT 0.00,
  data_abertura TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE itens_comanda (
  id SERIAL PRIMARY KEY,
   comanda_id INT NOT NULL,
   produto_id INT NOT NULL,
   quantidade INT NOT NULL,
   preco_unitario DECIMAL(10, 2) NOT NULL,
   subtotal DECIMAL(10, 2) NOT NULL,
  CONSTRAINT fk_item_comanda_comanda FOREIGN KEY (comanda_id) REFERENCES comandas(id),
  CONSTRAINT fk_item_comanda_produto FOREIGN KEY (produto_id) REFERENCES produtos(id)
);