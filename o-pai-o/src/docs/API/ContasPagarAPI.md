# API - Gestao de Contas a Pagar

API REST desenvolvida com Spring Boot para gerenciamento financeiro, lancamentos de despesas e controle de pagamentos.

## Base URL
```
http://localhost:8080/api/contas
```

---

## Autenticacao no Postman

Para acessar os endpoints protegidos, e necessario configurar o Bearer Token:

1. Realize o login no endpoint `/auth/login`.
2. Copie o valor do campo `token` da resposta.
3. No Postman, va em **Authorization** -> **Type: Bearer Token** e cole o codigo.

---

## Endpoints

### Lancar nova conta

**POST** \
`http://localhost:8080/api/contas`

Registra uma nova conta a pagar vinculada a um fornecedor.

### Body
```json
{
  "descricao": "Aluguel Escritorio",
  "valor": 1500.00,
  "dataVencimento": "2026-04-05",
  "fornecedorId": 1,
  "categoria": "ALUGUEL"
}
```

### Resposta
```json
{
  "id": 102,
  "descricao": "Aluguel Escritorio",
  "valor": 1500.0,
  "dataVencimento": "2026-04-05",
  "dataPagamento": null,
  "categoria": "ALUGUEL",
  "status": "PENDENTE"
}
```

---

### Listar todas as contas

**GET** \
`http://localhost:8080/api/contas`

Retorna o historico completo de lancamentos financeiros cadastrados.

---

### Baixar conta (Pagar)

**PATCH** \
`http://localhost:8080/api/contas/{id}/pagar`

Altera o status da conta de **PENDENTE** para **PAGA** e preenche `dataPagamento`.

Se o `id` nao existir, a API agora responde com `404 Not Found`.

---

### Atualizar conta

**PUT** \
`http://localhost:8080/api/contas/{id}`

Atualiza os dados de uma conta especifica, incluindo `fornecedorId`, `descricao`, `valor`, `categoria` e `dataVencimento`.

---

### Excluir lancamento

**DELETE** \
`http://localhost:8080/api/contas/{id}`

Remove permanentemente o registro da conta do banco de dados.

---
