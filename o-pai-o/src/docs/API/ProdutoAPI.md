# API - Produtos

API REST desenvolvida com Spring Boot para gerenciamento de Produtos.

## Base URL
``````
 http://localhost:8080/api/
``````

---

## Endpoints


### Criar fornecedor

**POST** \
`http://localhost:8080/api/produtos`

Cria um novo Produto.

### Body

```json
{
  "nome": "Detergente 4 em 1",
  "preco": 2.50,
  "unidade": "350ml - lata",
  "categoriaId": 684,
  "fornecedoresId": 7128
}
```
### Resposta
````json
{
  "id": 7704,
  "nome": "Detergente IPÉ 4 em 1",
  "preco": 2.50,
  "unidade": "350ml - lata",
  "categoria": {
    "id": 684,
    "nome": "Lavagem de Roupa",
    "descricao": "Sabão em pé",
    "data_criacao": "2026-03-19T23:54:09.781254"
  },
  "fornecedor": {
    "id": 7128,
    "nome": "KeDis",
    "cnpj": "321456789951",
    "telefone": "34991216584",
    "email": "kedIS@gmail.com",
    "endereco": "Rua jOAO BATISTA",
    "ativo": true,
    "data_cadastro": "2026-03-19T23:51:04.963777"
  },
  "ativo": true,
  "dataCriacao": "2026-03-26T20:40:28.6536889"
}
````
---
### Listar Produtos

**GET**\
`http://localhost:8080/api/produtos?page=0&size=10`


Retorna todos os produtos cadastrados utilizando o formato de paginação.

### Resposta
````json
    [
  {
    "id": 4646,
    "nome": "Detergente IPÉ 3 em 1",
    "preco": 2.50,
    "unidade": "350ml - lata",
    "categoria": {
      "id": 684,
      "nome": "Lavagem de Roupa",
      "descricao": "Sabão em pé",
      "data_criacao": "2026-03-19T23:54:09.781254"
    },
    "fornecedor": {
      "id": 7128,
      "nome": "KeDis",
      "cnpj": "321456789951",
      "telefone": "34991216584",
      "email": "kedIS@gmail.com",
      "endereco": "Rua jOAO BATISTA",
      "ativo": true,
      "data_cadastro": "2026-03-19T23:51:04.963777"
    },
    "ativo": true,
    "datacricao": "2026-03-25T23:44:01.265282"
  },
  {
    "id": 7704,
    "nome": "Detergente IPÉ 4 em 1",
    "preco": 2.50,
    "unidade": "350ml - lata",
    "categoria": {
      "id": 684,
      "nome": "Lavagem de Roupa",
      "descricao": "Sabão em pé",
      "data_criacao": "2026-03-19T23:54:09.781254"
    },
    "fornecedor": {
      "id": 7128,
      "nome": "KeDis",
      "cnpj": "321456789951",
      "telefone": "34991216584",
      "email": "kedIS@gmail.com",
      "endereco": "Rua jOAO BATISTA",
      "ativo": true,
      "data_cadastro": "2026-03-19T23:51:04.963777"
    },
    "ativo": true,
    "datacricao": "2026-03-26T20:40:28.671101"
  }
]
````
___

### Atualizar fornecedor

**PATCH**\
`http://localhost:8080/api/produtos/update/3910`

### Body

````json
{
  "fornecedor": 4825
}
````
### Resposta
````json
{
  "id": 7704,
  "nome": "Detergente IPÉ 4 em 1",
  "preco": 2.50,
  "unidade": "350ml - lata",
  "categoria": {
    "id": 684,
    "nome": "Lavagem de Roupa",
    "descricao": "Sabão em pé",
    "data_criacao": "2026-03-19T23:54:09.781254"
  },
  "fornecedor": {
    "id": 7128,
    "nome": "KeDis",
    "cnpj": "321456789951",
    "telefone": "34991216584",
    "email": "kedIS@gmail.com",
    "endereco": "Rua jOAO BATISTA",
    "ativo": true,
    "data_cadastro": "2026-03-19T23:51:04.963777"
  },
  "ativo": true,
  "dataCriacao": "2026-03-26T20:40:28.6536889"
}
````
````
___

### Deletar fornecedor

**DELETE**
````
http://localhost:8080/api/fornecedor/delete/{id}
````


