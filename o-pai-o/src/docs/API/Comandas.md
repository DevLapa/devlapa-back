
# 🚀 API - Gestão de Comandas (O Pai Ó)

Módulo de frente de caixa e controle de consumo desenvolvido com **Spring Boot**, focado em atendimento de mesas, processamento de pedidos e integridade de estoque.

## 📍 Base URL
```http
http://localhost:8080/api/comandas
```

---

## 🔐 Segurança e Acesso
Os endpoints possuem proteção por nível de acesso (**RBAC - Role-Based Access Control**):

* **POST / GET**: Liberado para `ADMIN`, `GERENTE` e `USUARIO`.
* **PUT (Finalizar/Cancelar)**: Liberado para `ADMIN` e `GERENTE`.
* **DELETE (Excluir Registro)**: Liberado apenas para `ADMIN`.

> **Dica Postman:** > 1. Realize o login em `/api/auth/login` para obter o JWT.
> 2. Em **Authorization**, selecione **Bearer Token** e cole o código.

---

## 📝 Endpoints Principais

### 1. Abrir Nova Comanda
**POST** `/api/comandas`
Cria um registro de consumo para uma mesa específica.

**Body:**
```json
{
  "numeroMesa": 15,
  "nomeCliente": "Allyson Ramos"
}
```

### 2. Adicionar Item à Comanda
**POST** `/api/comandas/{id}/itens`
Adiciona um produto, calcula o subtotal e **baixa o estoque** automaticamente.

**Body:**
```json
{
  "produtoId": 3068,
  "quantidade": 2
}
```

### 3. Finalizar Comanda (Pagamento)
**PUT** `/api/comandas/{id}/finalizar`
Altera o status para `FINALIZADA` e trava a comanda para novos lançamentos.

### 4. Cancelar Comanda (Estorno)
**DELETE** `/api/comandas/{id}`
Muda o status para `CANCELADA` e realiza o **estorno automático** dos itens para o estoque.

---

## ⚙️ Regras de Negócio Aplicadas
* **Cálculo Automático:** O sistema busca o preço unitário no banco e calcula o `subtotal` e o `valorTotal` da comanda em tempo real.
* **Validação de Estoque:** Impede a adição de itens caso a quantidade solicitada seja maior que o estoque atual.
* **Integridade Transacional:** Utiliza `@Transactional` para garantir que, se houver erro no salvamento do item, o estoque não seja alterado indevidamente.

---

