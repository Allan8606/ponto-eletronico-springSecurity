# ⏰ Sistema de Ponto Eletrônico - API REST

Este projeto é uma API REST desenvolvida em Java com **Spring Boot** para gerenciamento de ponto eletrônico de funcionários.

O sistema permite o cadastro de colaboradores, registro de entradas e saídas, e conta com autenticação segura via **JWT (JSON Web Token)**.

---

## 🚀 Tecnologias Utilizadas

- **Java 21+** (Linguagem base)
- **Spring Boot 3** (Framework principal)
- **Spring Data JPA** (Persistência de dados)
- **PostgreSQL** (Banco de dados relacional)
- **Spring Security** (Segurança e Autenticação)
- **Auth0 Java-JWT** (Geração e validação de tokens)
- **Lombok** (Redução de código boilerplate)
- **Bean Validation** (Validação de dados de entrada)
- **Maven** (Gerenciador de dependências)

---

## ⚙️ Funcionalidades

### 🔐 Autenticação e Segurança

- Login via email e senha
- Geração de Token JWT (**Bearer Token**)
- Controle de acesso baseado em perfis (**RBAC**):
  - `ADMIN`
  - `FUNCIONARIO`
- Senhas criptografadas com **BCrypt**

---

### 👥 Gestão de Funcionários

| Método | Rota                | Descrição                     | Permissão |
|--------|---------------------|-------------------------------|-----------|
| POST   | `/funcionario`      | Cadastra um novo funcionário  | Livre     |
| GET    | `/funcionario`      | Lista todos os funcionários   | Livre     |
| GET    | `/funcionario/{id}` | Busca funcionário por ID      | Livre     |
| PUT    | `/funcionario/{id}` | Atualiza dados do funcionário | ADMIN     |
| DELETE | `/funcionario/{id}` | Remove um funcionário         | ADMIN     |

#### Exemplo de JSON (Cadastro/Edição)

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123",
  "perfil": "ADMIN"
}
```
---

## 🔑 Autenticação

| Método | Rota   | Descrição                          | Permissão |
|--------|--------|------------------------------------|-----------|
| POST   | `/login` | Autentica o usuário e retorna JWT | Livre     |

### Exemplo de JSON (Login)

```json
{
  "email": "admin@email.com",
  "senha": "123"
}
```

---
## 🛠 Configuração e Instalação

### Pré-requisitos

- Java JDK 17 ou superior
- Maven instalado
- PostgreSQL instalado e rodando

---
### 🗄 Configuração do Banco de Dados

Crie o banco no PostgreSQL:

```sql
CREATE DATABASE ponto_eletronico;
```
- Edite o arquivo src/main/resources/application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/ponto_eletronico
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres
spring.jpa.hibernate.ddl-auto=update

api.security.token.secret=minha-senha-secreta-super-segura-123

```

--- 
### ▶ Rodando a Aplicação

Abra o terminal na raiz do projeto e execute:

```bash
mvn spring-boot:run
```
A aplicação ficará disponível em:
```
http://localhost:8080
```
---

## 📚 Documentação da API (Endpoints)

### 🔐 Autenticação

| Método | Rota    | Descrição                              | Permissão |
|--------|---------|----------------------------------------|-----------|
| POST   | `/login`| Autentica o usuário e retorna o Token JWT | Livre     |

#### Exemplo de JSON (Login)

```json
{
  "email": "admin@email.com",
  "senha": "123"
}
```
### 👥 Funcionários

| Método | Rota                | Descrição                     | Permissão |
|--------|---------------------|-------------------------------|-----------|
| POST   | `/funcionario`      | Cadastra um novo funcionário  | Livre     |
| GET    | `/funcionario`      | Lista todos os funcionários   | Livre     |
| GET    | `/funcionario/{id}` | Busca funcionário por ID      | Livre     |
| PUT    | `/funcionario/{id}` | Atualiza dados do funcionário | ADMIN     |
| DELETE | `/funcionario/{id}` | Remove um funcionário         | ADMIN     |

#### Exemplo de JSON (Cadastro/Edição)

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123",
  "perfil": "ADMIN"
}
```
Obs: O perfil pode ser ADMIN ou FUNCIONARIO.

### ⏰ Registro de Ponto

| Método | Rota                                  | Descrição                   | Permissão |
|--------|---------------------------------------|-----------------------------|-----------|
| POST   | `/registroPonto`                      | Registra um novo ponto      | ADMIN     |
| GET    | `/registroPonto`                      | Lista todos os registros    | ADMIN     |
| GET    | `/registroPonto/funcionario?nome=X`   | Busca registros pelo nome   | ADMIN     |
| PUT    | `/registroPonto/{id}`                 | Edita um registro de ponto  | ADMIN     |
| DELETE | `/registroPonto/{id}`                 | Deleta um registro de ponto | ADMIN     |


#### Exemplo de JSON (Registrar Ponto)

```json
{
  "data": "31/12/2025",
  "horaEntrada": "08:00",
  "horaSaida": "17:00",
  "funcionarioId": 1
}
```
Obs: As datas devem seguir o formato dd/MM/yyyy e as horas HH:mm.

---
## 🧪 Como Testar (Postman / Insomnia)

1. Crie um usuário com perfil **ADMIN** usando `POST /funcionario`
2. Faça login usando `POST /login`
3. Copie o campo **token** retornado
4. Nas rotas protegidas:
   - Vá em **Authorization**
   - Selecione **Bearer Token**
   - Cole o token gerado
--- 

## 👨‍💻 Autor

Desenvolvido por **Allan**


