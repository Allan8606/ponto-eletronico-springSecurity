# ⏰ Sistema de Ponto Eletrônico – API REST

Este projeto é uma **API REST** desenvolvida em **Java com Spring Boot** para gerenciamento de **ponto eletrônico de funcionários**.

Toda a **documentação da API é disponibilizada via Swagger (OpenAPI)** e o sistema conta com **tratamento padronizado de erros**, garantindo respostas claras e consistentes para o cliente.

---

## 🚀 Tecnologias Utilizadas

* Java 21+
* Spring Boot 3
* Spring Data JPA
* Spring Security
* JWT (Auth0 Java-JWT)
* PostgreSQL
* Bean Validation
* Swagger / OpenAPI 3
* Lombok
* Maven

---

## ⚙️ Funcionalidades

### 🔐 Autenticação e Segurança

* Login via **email e senha**
* Geração de **JWT (Bearer Token)**
* Controle de acesso baseado em perfis (**RBAC**):

  * `ADMIN`
  * `FUNCIONARIO`
* Senhas criptografadas com **BCrypt**

---

### 👥 Gestão de Funcionários

| Método | Rota              | Descrição                     | Permissão |
| ------ | ----------------- | ----------------------------- | --------- |
| POST   | /funcionario      | Cadastra um novo funcionário  | Livre     |
| GET    | /funcionario      | Lista todos os funcionários   | ADMIN     |
| GET    | /funcionario/{id} | Busca funcionário por ID      | ADMIN     |
| PUT    | /funcionario/{id} | Atualiza dados do funcionário | ADMIN     |
| DELETE | /funcionario/{id} | Remove um funcionário         | ADMIN     |

**Exemplo de JSON (Cadastro / Edição):**

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123",
  "perfil": "ADMIN"
}
```

> Obs: O perfil pode ser `ADMIN` ou `FUNCIONARIO`.

---

### 🔑 Autenticação

| Método | Rota   | Descrição                         | Permissão |
| ------ | ------ | --------------------------------- | --------- |
| POST   | /login | Autentica o usuário e retorna JWT | Livre     |

**Exemplo de JSON (Login):**

```json
{
  "email": "admin@email.com",
  "senha": "123"
}
```

---

### ⏰ Registro de Ponto

| Método | Rota                              | Descrição                                | Permissão          |
| ------ | --------------------------------- | ---------------------------------------- | ---------          |
| POST   | /registroPonto                    | Registra um novo ponto                   | ADMIN e FUNCIONARIO|
| GET    | /registroPonto                    | Lista todos os registros                 | ADMIN              |
| GET    | /registroPonto/funcionario?nome=X | Busca registros pelo nome do funcionário | ADMIN              |
| PUT    | /registroPonto/{id}               | Edita um registro de ponto               | ADMIN              |
| DELETE | /registroPonto/{id}               | Remove um registro de ponto              | ADMIN              |

**Exemplo de JSON (Registro de Ponto):**

```json
{
  "data": "31/12/2025",
  "horaEntrada": "08:00",
  "horaSaida": "17:00",
  "funcionarioId": 1
}
```

> Datas devem seguir o formato `dd/MM/yyyy` e horas `HH:mm`.

---

## 📚 Documentação da API – Swagger

A documentação completa e interativa da API está disponível via **Swagger UI**.

Após iniciar a aplicação, acesse:

```
http://localhost:8080/swagger-ui.html
```

ou

```
http://localhost:8080/swagger-ui/index.html
```

No Swagger é possível:

* Visualizar todos os endpoints
* Ver modelos de request/response
* Testar requisições diretamente pelo navegador
* Enviar o **Bearer Token** para rotas protegidas

---


## 🛠 Configuração e Instalação

### Pré-requisitos

* Java JDK 17 ou superior
* Maven
* PostgreSQL


## ▶ Rodando a Aplicação

No terminal, na raiz do projeto:

```bash
mvn spring-boot:run
```

Aplicação disponível em:

```
http://localhost:8080
```

---

## 🧪 Como Testar (Postman / Insomnia / Swagger)

1. Crie um usuário `ADMIN` usando `POST /funcionario`
2. Faça login em `POST /login`
3. Copie o **token JWT** retornado
4. Nas rotas protegidas:

   * Authorization → Bearer Token
   * Cole o token

---

## 👨‍💻 Autor

Desenvolvido por **Allan Isaac**
