# DevLapa: Ó PAI, Ó (Sistema de Gerenciamento Financeiro para BAR) - API
## Equipe Desenvolvedora
```
Clériston Lima– Desenvolvedor / Tech Lead
Allyson Ramos – Desenvolvedor / DBA 
Amanda Rezende – UX/UI Designer
Débora Nascimento – Analista de Documentação / QA (Quality Assurance)

```
## Objetivo
Desenvolver um sistema de gerenciamento financeiro personalizado para o Ó Pai Ó Bar, com o objetivo de otimizar o controle de vendas e despesas, fornecer uma visualização precisa do lucro mensal e disponibilizar relatórios gerenciais detalhados, contribuindo para uma gestão financeira mais organizada, estratégica e eficiente.

## Stack e tecnologias
* Backend: Java + Spring Boot (API REST)
* Banco de Dados: PostgreSQL
* Autenticação: JWT (JSON Web Token)

## Requisitos / Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

### Ferramentas Necessárias

- Java 17 ou superior
- Maven
- Node.js 18 ou superior
- PostgreSQL
- IDE (IntelliJ IDEA ou VS Code)
- Postman (opcional – para testes da API)

---

## 📥 Instalação das Ferramentas

### 1️ Java 17+
Verifique se já está instalado:
java -version

Se não estiver instalado, faça o download no site oficial da Oracle ou utilize uma distribuição como OpenJDK.

---

### 2️ Maven
Verifique:
mvn -version

Caso não tenha, instale via site oficial ou gerenciador de pacotes.

---

### 3️ Node.js 18+
Verifique:
node -v

Download oficial:
https://nodejs.org/

---

### 4️ PostgreSQL
Após instalar:

- Crie um banco de dados
- Configure usuário e senha
- Atualize as credenciais no arquivo `application.properties` do backend

Exemplo:

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco  
spring.datasource.username=seu_usuario  
spring.datasource.password=sua_senha

---

## Executando o Projeto

### Backend (Spring Boot)

#### Clonando o Repositório:
```
   git clone git@gitlab.com:uniube-pi2-2026-1/DevLapa/o-pai-o-api.git
```
ou 
```
 git clone https://gitlab.com/uniube-pi2-2026-1/DevLapa/o-pai-o-api.git
```

#### Entre na pasta do projeto::
```   
cd o-pai-o
```
#### Execute a aplicação:
```
    mvn spring-boot:run
```
#### Acesso à API:
http://localhost:8080

## Observações:
- Verifique se as configurações do banco de dados estão corretas no arquivo:
```
src/main/resources/application.properties
```
---