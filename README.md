# 🚨 SurvivAPP API

A **SurvivAPP API** é uma aplicação backend desenvolvida em **Java 17** com **Spring Boot 3.2.2**, endpoints para envio de **sinais de emergência**.

Usuários se autenticam via **email e senha** (quando conectados à internet), podendo enviar **alertas emergenciais** vinculados ao seu perfil.

---

## 📘 Sobre o Projeto

O **SurvivAPP** é um sistema backend de suporte para um aplicativo de **sobrevivência em situações de emergência**, como desorientação em trilhas ou falta de energia em áreas remotas.

🧭 O frontend oferece orientações mesmo offline.  
📡 O backend entra em ação quando há conexão, permitindo:
- Autenticação de usuários
- Registro de emergências

O objetivo principal é garantir **segurança**, **agilidade** e **confiabilidade** em momentos críticos.

---

## 📁 Estrutura do Projeto

```

src/
└── main/
└── java/
└── com.example.survivalsos/
├── emergencia/             # Entidade, controller e service para emergências
│   ├── controller/
│   ├── model/
│   ├── repository/
│   └── service/
│
└── user/                   # Funcionalidades de usuário
├── controller/
├── dto/
├── model/
├── repository/
└── service/

````

---

## 🔧 Camadas do Projeto

| Camada     | Função                                                                 |
|------------|------------------------------------------------------------------------|
| `controller` | Define os endpoints REST da API                                       |
| `service`    | Contém as regras de negócio                                            |
| `repository` | Comunicação com o banco via Spring Data JPA                          |
| `dto`        | Objetos para transporte de dados (entrada e saída)                   |
| `model`      | Entidades JPA (como `Usuario` e `Emergencia`)                        |

---

## 🚀 Como Rodar o Projeto

### ✅ Pré-requisitos

- Java 17
- Maven
- IDE (IntelliJ, VS Code, Eclipse)

### ▶️ Passos

```bash
git clone [https://github.com/ruiasiqueira/GS-SOA]
cd GS-SOA
mvn spring-boot:run
````

A API estará acessível em:
📍 [http://localhost:8080](http://localhost:8080)

---

## 📚 Documentação da API

* Swagger UI:
  🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🔐 Endpoints Principais


---

### 🆕 Criar Conta

`POST /usuarios`

Content-Type: application/json

```json
{
    "nome": "João da Silva",
    "email": "joao@email.com",
    "senha": "senha123",
    "tipoSanguineo": "O+",
    "alergia": "Nenhuma"
}
```

---

### 🔑 Login

`POST /usuarios/login`

Content-Type: application/json

```json
{
  "email": "maria@email.com",
  "senha": "segura123"
}
```

**Resposta:**

* `"Login bem-sucedido!"` em caso de sucesso
* `"Email ou senha incorretos."` em caso de falha

---

### 👥 Listar todos os usuários

`GET /usuarios`

**Resposta:** Lista de usuários no formato JSON, exemplo:

```json
[
  {
    "nome": "João da Silva",
    "email": "joao@email.com",
    "tipoSanguineo": "O+",
    "alergia": "Nenhuma"
  },
  {
    "nome": "Maria Oliveira",
    "email": "maria@email.com",
    "tipoSanguineo": "A-",
    "alergia": "Penicilina"
  }
]
```

---

### 👤 Buscar usuário por ID

`GET /usuarios/{id}`

**Parâmetros:**

* `id` (path) — ID numérico do usuário a ser buscado.

**Resposta:** Usuário no formato JSON, exemplo:

```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "tipoSanguineo": "O+",
  "alergia": "Nenhuma"
}
```


---

### 🆕 Criar Emergência

`POST /emergencias`

Content-Type: application/json

```json
{
  "tipoEmergencia": "Incêndio",
  "usuarioId": 1
}
```

**Resposta:**
Objeto EmergenciaDTO criado, exemplo:

```json
{
  "id": 10,
  "tipoEmergencia": "Incêndio",
  "usuarioId": 1
}
```

---

### 📋 Listar todas as emergências

`GET /emergencias`

**Resposta:** Lista de objetos Emergencia, exemplo:

```json
[
  {
    "id": 10,
    "tipoEmergencia": "Incêndio",
    "usuario": {
      "id": 1,
      "nome": "João da Silva",
      "email": "joao@email.com",
      "tipoSanguineo": "O+",
      "alergia": "Nenhuma"
    }
  },
  {
    "id": 11,
    "tipoEmergencia": "Acidente",
    "usuario": {
      "id": 2,
      "nome": "Maria Oliveira",
      "email": "maria@email.com",
      "tipoSanguineo": "A-",
      "alergia": "Penicilina"
    }
  }
]
```

---

### 👤 Buscar emergência por ID

`GET /emergencias/{id}`

**Parâmetros:**

* `id` (path) — ID da emergência a ser buscada.

**Resposta:** Objeto Emergencia, exemplo:

```json
{
  "id": 10,
  "tipoEmergencia": "Incêndio",
  "usuario": {
    "id": 1,
    "nome": "João da Silva",
    "email": "joao@email.com",
    "tipoSanguineo": "O+",
    "alergia": "Nenhuma"
  }
}
```

---

### ✏️ Atualizar emergência

`PUT /emergencias/{id}`

Content-Type: application/json

```json
{
  "tipoEmergencia": "Enchente",
  "usuarioId": 1
}
```

**Resposta:** Objeto Emergencia atualizado (retornado opcionalmente).

---

### 🗑 Deletar emergência

`DELETE /emergencias/{id}`

**Parâmetros:**

* `id` (path) — ID da emergência a ser deletada.

**Resposta:** Nenhuma (204 No Content esperado).

---


## 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot 3.2.2
* H2 Database (banco em memória)
* Maven
* Swagger (Documentação da API)

---

## 🧪 Testes

Você pode utilizar ferramentas como **Postman** ou **Insomnia** para testar os endpoints da API. Use o token JWT recebido no login para acessar os endpoints protegidos.

---

## 📌 Observações

Este projeto é um backend simples, ideal para simulações, testes e aprendizado de autenticação com JWT e criação de APIs REST seguras com Spring Boot.

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

```
