---

```markdown
# 💰 Módulo: Gestão de Contas a Receber (Devlapa)

Este módulo é responsável pelo controle de entradas financeiras do sistema **O Pai Ó**. Ele gerencia desde a criação de uma expectativa de recebimento até a efetiva baixa (recebimento) do valor, com integrações a usuários e comandas.

## 🛠️ Tecnologias Utilizadas
- **Spring Boot 3**
- **Spring Data JPA** (PostgreSQL)
- **Spring Security** (Controle de acesso por Roles)
- **Flyway** (Migração de banco de dados)
- **Bean Validation** (Validação de DTOs)

---

## 📋 Regras de Negócio Implementadas

1.  **Estado Inicial:** Toda conta criada nasce com o status `PENDENTE`.
2.  **Fluxo de Recebimento:** Ao marcar uma conta como recebida, o sistema registra automaticamente a `dataRecebimento` com a data atual.
3.  **Bloqueio de Conflito:** 
    *   Não é possível receber uma conta que já está com status `RECEBIDO`.
    *   Não é possível receber uma conta que foi `CANCELADA`.
4.  **Segurança:** Apenas usuários com perfil `ADMIN` ou `GERENTE` podem realizar operações de escrita (Criar, Editar, Receber, Excluir).

---

## 🚀 Endpoints da API

### Base URL: `/contas-receber`

| Método | Endpoint | Descrição | Acesso |
| :--- | :--- | :--- | :--- |
| **GET** | `/` | Lista todos os lançamentos | Livre/Autenticado |
| **POST** | `/` | Cadastra uma nova conta | ADMIN/GERENTE |
| **PUT** | `/{id}` | Atualiza dados cadastrais | ADMIN/GERENTE |
| **PATCH** | `/{id}/receber` | Registra o pagamento do cliente | ADMIN/GERENTE |
| **DELETE** | `/{id}` | Remove o registro permanentemente | ADMIN/GERENTE |

---

## 📦 Exemplos de Requisição (JSON)

### Criar Nova Conta (`POST`)
```json
{
  "usuarioId": 1,
  "cliente": "João Silva",
  "descricao": "Consumo Comanda #45",
  "valor": 150.00,
  "dataVencimento": "2026-04-10",
  "dataCriacao": "2026-04-03T10:00:00"
}
```

### Resposta de Sucesso (200 OK / 201 Created)
```json
{
  "id": 4,
  "cliente": "João Silva",
  "descricao": "Consumo Comanda #45",
  "valor": 150.00,
  "status": "PENDENTE",
  "dataVencimento": "2026-04-10",
  "dataRecebimento": null
}
```

---

## ⚠️ Tratamento de Erros

A API utiliza códigos de status HTTP semânticos para facilitar a integração com o Front-end:

*   **404 Not Found:** Quando o ID informado não existe no banco.
*   **409 Conflict:** Quando tenta-se receber uma conta já recebida ou cancelada.
*   **403 Forbidden:** Quando um usuário sem permissão tenta realizar uma alteração.
*   **400 Bad Request:** Quando os dados enviados no JSON violam as validações (ex: valor negativo).



