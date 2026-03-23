# 🚀 To-Do List Full Stack

Aplicação full stack para gerenciamento de tarefas, desenvolvida com foco em boas práticas de backend e frontend, incluindo deploy em produção.

---

## 📌 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de demonstrar habilidades em desenvolvimento backend e frontend, integração entre sistemas e deploy em nuvem.

A aplicação permite:

* ✅ Criar tarefas
* 📋 Listar tarefas
* ✏️ Editar tarefas
* ❌ Excluir tarefas
* 🔍 Pesquisar tarefas

---

## 🧠 Arquitetura

O projeto segue uma arquitetura em camadas no backend e separação clara de responsabilidades no frontend.

### Backend (Spring Boot)

* config → configuração de cors
* Controller → endpoints REST
* Service → regras de negócio
* Repository → acesso ao banco
* DTO → comunicação da API
* Exception Handler → tratamento de erros

### Frontend (HTML, CSS, JS)

* HTML semântico
* CSS com variáveis e responsividade
* JavaScript com `async/await`
* Consumo de API REST

---

## 🛠️ Tecnologias utilizadas

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL (Neon)
* Maven
* Docker
  
### Frontend

* HTML5
* CSS3
* JavaScript

### Deploy

* Banco de dados: Neon (PostgreSQL)
* Backend: Render
* Frontend: Vercel

---

## 🌐 Acessos

### 🔗 Frontend

👉 https://todo-list-nine-eta-58.vercel.app

### 🔗 Backend (API)

👉 https://to-do-list-1-5ou2.onrender.com/tarefas

---

## 📡 Endpoints principais

| Método | Endpoint                | Descrição         |
| ------ | ----------------------- | ----------------- |
| GET    | /tarefas                | Listar tarefas    |
| GET    | /tarefas/{id}           | Buscar por ID     |
| POST   | /tarefas                | Criar tarefa      |
| PUT    | /tarefas/{id}           | Atualizar tarefa  |
| DELETE | /tarefas/{id}           | Excluir tarefa    |
| GET    | /tarefas/search?titulo= | Buscar por título |

---

## 📁 Estrutura do projeto

```
📦 projeto
 ├── backend
 |    ├── config
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    ├── model
 │    ├── exception
 │    └── dockerfile
 │
 └── frontend
      ├── index.html
      ├── css
      └── js
```

---

## ⚙️ Como rodar localmente

### 🔹 Backend

```bash
cd backend
./mvnw spring-boot:run
```

---

### 🔹 Frontend

Abra o arquivo:

```
frontend/index.html
```

ou use extensão Live Server.

---

## 🔐 Variáveis de ambiente

```env
DB_URL=
DB_USER=
DB_PASSWORD=
```

---

## 💡 Funcionalidades implementadas

* CRUD completo
* Busca em tempo real
* Interface responsiva
* Integração frontend/backend
* Tratamento de exceções
* Deploy em produção

---

## 🧠 Aprendizados

Durante o desenvolvimento, foram aplicados conceitos como:

* Arquitetura em camadas
* Consumo de API REST
* Manipulação de DOM
* Tratamento de erros
* Deploy em nuvem
* Integração full stack

---

## 📈 Melhorias futuras

* Paginação de tarefas
* Filtro por status
* Autenticação (login)
* Melhorias visuais (UI/UX)
* Testes automatizados

---

## 👨‍💻 Autor

Desenvolvido por **José Luiz Vitorino Felisbino**

---

## 💼 Projeto para portfólio

Este projeto foi desenvolvido com foco em demonstrar habilidades para vagas de **Desenvolvedor Backend Júnior / Full Stack Júnior**.
