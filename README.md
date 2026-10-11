 # DevLapa Back-end

API REST do DevLapa para operação e controle financeiro de bares e restaurantes. O serviço concentra regras de negócio para usuários, produtos, estoque, comandas, vendas, fornecedores, contas e movimentações.

> **Estado atual:** a API é um MVP autenticado e conectado a PostgreSQL. Ela ainda não implementa multi-tenancy, planos, cobrança recorrente ou isolamento de dados por cliente.

## Funcionalidades implementadas

- Autenticação com usuário, senha BCrypt e JWT.
- Autorização por roles com Spring Method Security.
- CRUDs e operações de produtos, categorias, estoque e fornecedores.
- Comandas e itens de comanda.
- Vendas, itens de venda e formas de pagamento.
- Contas a pagar e contas a receber.
- Movimentações de estoque.
- Migrations do banco gerenciadas pelo Flyway.
- Documentação OpenAPI/Swagger.
- Empacotamento em imagem Docker.

O código também contém operações de inativação de usuários e alteração de perfil. A cobertura de autorização ainda precisa ser revisada em todos os controllers antes de uma implantação pública.

## Tecnologias

| Tecnologia | Uso |
| --- | --- |
| Java 21 | Linguagem e runtime alvo |
| Spring Boot 4.0.3 | Framework da aplicação |
| Spring WebMVC | Controllers REST |
| Spring Data JPA | Persistência |
| Spring Security | Autenticação e autorização |
| Auth0 java-jwt | Emissão e validação de JWT |
| BCrypt | Hash de senhas |
| PostgreSQL | Banco de dados |
| Flyway | Versionamento do schema |
| Lombok | Redução de código repetitivo |
| Springdoc OpenAPI | Swagger e documentação de API |
| Maven | Build e gerenciamento de dependências |
| Docker | Empacotamento e execução em nuvem |

## Arquitetura

```text
o-pai-o/
├── src/main/java/com/devlapa/o_pai_o/
│   ├── config/          # Security, CORS e Swagger
│   ├── controllers/     # Endpoints REST
│   ├── domain/          # Entidades, DTOs e enums
│   ├── repositories/    # Repositórios JPA
│   ├── service/         # Regras de negócio
│   ├── mapper/          # Conversões entre objetos
│   └── infra/exception/ # Tratamento de erros
├── src/main/resources/
│   ├── db/migration/    # V1 a V11 do Flyway
│   └── application.properties
└── pom.xml
```

## Pré-requisitos

- JDK 21.
- Maven 3.9 ou superior, ou Maven Wrapper.
- PostgreSQL compatível com o driver usado pelo projeto.
- Docker, opcional para execução em container.

## Variáveis de ambiente

Copie `.env.example` para um ambiente local, sem publicar o arquivo resultante:

```env
DATABASE_URL=jdbc:postgresql://localhost:5432/o_pai_o
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=SUA_SENHA_LOCAL
JWT_SECRET=SUA_CHAVE_JWT_LONGA_E_ALEATORIA
FRONTEND_URL=http://localhost:5173
PORT=8080
```

O Spring Boot lê essas propriedades como variáveis de ambiente. `JWT_SECRET` não possui valor padrão e deve ser definido em todos os ambientes.

## Banco de dados e migrations

O projeto usa `spring.jpa.hibernate.ddl-auto=none` e Flyway. As migrations ficam em `o-pai-o/src/main/resources/db/migration` e criam as tabelas de usuários, fornecedores, categorias, produtos, estoque, contas, formas de pagamento, comandas, vendas e movimentações.

Antes de iniciar a aplicação, crie o banco PostgreSQL e configure as três variáveis `DATABASE_*`. O Flyway executará as migrations automaticamente na inicialização. Os arquivos em `database/` são materiais auxiliares de schema e seeds; a fonte executada pela aplicação é a pasta de migrations.

## Executar localmente

Na raiz deste repositório:

```bash
cd o-pai-o
./mvnw spring-boot:run
```

No Windows:

```powershell
cd o-pai-o
.\mvnw.cmd spring-boot:run
```

A API usa a porta definida por `PORT`, com padrão `8080`.

## Build, testes e Docker

```bash
cd o-pai-o
./mvnw test
./mvnw -DskipTests package
```

O teste existente é um teste de carregamento de contexto e requer configuração de banco para execução completa.

Para construir a imagem a partir da raiz do repositório:

```bash
docker build -t devlapa-back .
docker run --rm -p 8080:8080 --env-file .env devlapa-back
```

O `Dockerfile` compila o projeto Maven e executa o JAR com a porta fornecida por `PORT`.

## Autenticação e API

O login público é:

```text
POST /auth/login
```

Após o login, envie o JWT como Bearer Token. A configuração libera também `/v3/api-docs/**`, `/swagger-ui/**` e `/swagger-ui.html`.

Os controllers atualmente expõem, entre outros, estes grupos:

| Grupo | Caminho base |
| --- | --- |
| Categorias | `/api/categorias` |
| Comandas | `/api/comandas` |
| Contas a pagar | `/api/contas` |
| Contas a receber | `/contas-receber` |
| Estoque | `/api/estoque` |
| Fornecedores | `/api/fornecedor` |
| Produtos | `/api/produtos` |
| Usuários | `/usuarios` |
| Vendas | `/vendas` |
| Formas de pagamento | `/formasdepagamento` |
| Itens de venda | `/itensvenda` |
| Movimentações | `/movimentacoes` |

Os caminhos devem ser mantidos alinhados com o front-end. Há chamadas no front-end para endpoints de cadastro, recuperação de senha, notificações e caminhos com prefixo diferente que ainda não estão implementados ou padronizados na API.

## Segurança e operação

- Nunca commite `.env`, credenciais, tokens ou chaves JWT.
- Use uma chave JWT longa, aleatória e diferente por ambiente.
- Restrinja `FRONTEND_URL` ao domínio real da aplicação.
- Use HTTPS em produção.
- Faça backup e teste a restauração do PostgreSQL.
- Desative Swagger público se a política de produção exigir.
- Remova logs de diagnóstico do filtro de segurança antes da produção.
- Revise autorização nos controllers de usuários, fornecedores e categorias.
- Não considere autorização visual do front-end como controle de segurança.

## Visão SaaS

A API é candidata a se tornar o núcleo de um SaaS para bares e restaurantes, mas ainda opera sem uma organização/tenant. Para suportar clientes independentes, será necessário:

- Criar `empresa` ou `tenant`.
- Associar usuários e todas as entidades de negócio a uma empresa.
- Filtrar consultas e mutações sempre pelo tenant autenticado.
- Impedir referências entre registros de empresas diferentes.
- Criar convite de usuários e administração da organização.
- Criar planos, limites, trial e status de assinatura.
- Integrar provedor de cobrança e webhooks.
- Adicionar auditoria, métricas, alertas, backups e estratégia de recuperação.
- Cobrir isolamento de dados com testes de segurança.

Não há atualmente cobrança, multi-tenancy, escalabilidade automática, isolamento entre clientes ou monitoramento operacional implementados.

## Desenvolvimento

Use migrations novas em vez de editar migrations já aplicadas. Separe regras de negócio nos services, mantenha DTOs sem credenciais e adicione testes para autenticação, autorização e operações financeiras. Commits devem ser pequenos e descritivos.
