
---

# 📋 Plano de Testes Postman - Sistema O Pai Ó

> **Base URL:** `http://localhost:8080`  
> **Auth:** Bearer Token (Necessário em todas as rotas após o Login)

## 🔐 0. Login (Obter acesso)
*   **POST** `/auth/login`
*   **Body:**
```json
{
    "login": "allyson.admin",
    "senha": "123"
}
```

---

## 🏗️ 1. Preparar o Estoque (POST)
*   **POST** `/estoque`
*   **Body:**
```json
{
    "produtoId": 1,
    "quantidade": 100,
    "minimo": 20
}
```

---

## 📥 2. Registrar Entrada (Soma ao Saldo)
*   **POST** `/movimentacoes`
*   **Body:**
```json
{
    "estoqueId": 1,
    "quantidade": 50,
    "tipo": "ENTRADA",
    "motivo": "Carga recebida via Logística"
}
```
*   **O que observar no Log:** Um `insert into movimentacoes` seguido de um `update estoque`.

---

## 📤 3. Registrar Saída (Subtrai do Saldo)
*   **POST** `/movimentacoes`
*   **Body:**
```json
{
    "estoqueId": 1,
    "quantidade": 30,
    "tipo": "SAIDA",
    "motivo": "Venda realizada"
}
```

---

## 🛑 4. Testar Erro: Saldo Insuficiente
*   **POST** `/movimentacoes`
*   **Body:**
```json
{
    "estoqueId": 1,
    "quantidade": 500,
    "tipo": "SAIDA",
    "motivo": "Tentativa de estourar o estoque"
}
```
*   **Resultado esperado:** Status `400 Bad Request` com a mensagem personalizada que apareceu no seu log.

---

## 📊 5. Consultar Histórico e Status
*   **GET** `/movimentacoes` (Verifica se o `usuario_responsavel` gravou como `allyson.admin`).
*   **GET** `/estoque/1` (Verifica se o saldo final e o status `NORMAL` ou `CRITICO` estão coerentes).

---

## 🗑️ 6. Testar Estorno (Delete)
*   **DELETE** `/movimentacoes/{id}`
*   **Validação:** Ao deletar uma movimentação, o saldo do item no estoque deve ser revertido automaticamente.

---

