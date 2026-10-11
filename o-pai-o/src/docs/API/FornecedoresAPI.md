# API - Sistema de Fornecedores

API REST desenvolvida com Spring Boot para gerenciamento de fornecedores.

## Base URL
``````
 http://localhost:8080/api/
``````

---

## Endpoints 


### Criar fornecedor

**POST** \
`http://localhost:8080/api/fornecedor`

Cria um novo fornecedor.

### Body

```json
{
  "nome": "Clériston dos Santos lima",
  "cnpj": "12345678911",
  "telefone": "12345678932",
  "email": "cleristonTeste@gmail.com",
  "endereco": "Rua São Tinino"
}
```
### Resposta
````json
{
    "id": 6687,
    "nome": "Clériston dos Santos lima",
    "cnpj": "12345678911",
    "telefone": "12345678932",
    "email": "cleristonTeste@gmail.com",
    "endereco": "Rua São Tinino",
    "ativo": true,
    "data_cadastro": "2026-03-11T20:12:04.4138132"
}
````
---
### Listar fornecedores

**GET**\
`http://localhost:8080/api/fornecedor?page=0&size=7`


Retorna todos os fornecedores cadastrados utilizando o formato de paginação.

### Resposta
````json
    [
  {
    "id": 5462,
    "nome": "Clériston dos Santos lima",
    "cnpj": "12345678911",
    "telefone": "34991210545",
    "email": "cleriston@gmail.com",
    "endereco": "Rua São Tinino",
    "ativo": true,
    "date_cadastro": "2026-03-11T19:44:58.424721"
  },
  {
    "id": 5585,
    "nome": "Clériston dos Santos lima",
    "cnpj": "12345678911",
    "telefone": "34991210545",
    "email": "cleriston@gmail.com",
    "endereco": "Rua São Tinino",
    "ativo": true,
    "date_cadastro": "2026-03-11T20:02:07.498677"
  },
  {
    "id": 1519,
    "nome": "Clériston dos Santos lima",
    "cnpj": "12345678911",
    "telefone": "34991210545",
    "email": "cleriston@gmail.com",
    "endereco": "Rua São Tinino",
    "ativo": true,
    "date_cadastro": "2026-03-11T20:02:11.562997"
  }
]
````
___

### Atualizar fornecedor

**PATCH**\
`http://localhost:8080/api/fornecedor/5628`

### Body

````json
{
  "nome": "Osvaldo"
}
````
___

### Deletar fornecedor

**DELETE**
````
http://localhost:8080/api/fornecedor/delete/{id}
````


