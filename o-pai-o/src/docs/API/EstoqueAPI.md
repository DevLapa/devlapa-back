#  API - Gestão de Estoque

Módulo de controle de inventário desenvolvido com **Spring Boot**, focado em movimentação de mercadorias e monitoramento de níveis de segurança (estoque mínimo).

##  Base URL
```http
http://localhost:8080/api/estoque
```

---

##  Segurança e Acesso
Os endpoints de escrita possuem proteção por nível de acesso (**Role-Based Access Control**):

* **POST/PATCH/PUT**: Liberado para `ADMIN` e `GERENTE`.
* **DELETE**: Liberado apenas para `ADMIN`.
* **GET**: Liberado para todos os usuários autenticados.

> **Configuração Postman:** > 1. Obtenha o token em `/auth/login`.
> 2. Em **Authorization**, escolha **Bearer Token** e cole o código.

---

## Endpoints

### 1. Cadastrar Item no Estoque
**POST** `/api/estoque`

Vincula um produto existente ao controle de estoque.

**Body:**
```json
{
  "produtoId": 1,
  "quantidade": 100,
  "minimo": 20
}
```

---

### 2. Listar Inventário
**GET** `/api/estoque`

Retorna a lista de todos os itens monitorados.

**Exemplo de Resposta:**
```json
[
  {
    "id": 1,
    "produto": "Teclado Mecânico RGB",
    "quantidade": 150,
    "minimo": 20,
    "status": "NORMAL"
  }
]
```

---

### 3. Registrar Entrada (Soma)
**PATCH** `/api/estoque/{id}`

Incrementa a quantidade atual. O sistema recalcula o status automaticamente.

**Body:**
```json
{
  "quantidade": 50
}
```

---

### 4. Atualizar Registro
**PUT** `/api/estoque/{id}`

Substitui todos os dados do registro (útil para correções de inventário).

---

### 5. Remover do Controle
**DELETE** `/api/estoque/{id}`

Exclui o registro de estoque permanentemente.

**Resposta Esperada:** `204 No Content`

---

## Regras de Negócio (Status)
A API gerencia o campo `status` automaticamente com base na quantidade:
* **NORMAL**: Quantidade > Mínimo.
* **BAIXO**: Quantidade <= Mínimo.
* **INDISPONÍVEL**: Quantidade = 0.

---
