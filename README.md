
# API REST de Gerenciamento de Tarefas

Projeto desenvolvido para o desafio da DIO utilizando Java 17 e Spring Boot 3.

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Bean Validation
- Swagger / OpenAPI
- Maven

## Funcionalidades

- Criar tarefas
- Listar tarefas
- Buscar por ID
- Atualizar tarefas
- Concluir tarefas
- Excluir tarefas
- Filtrar por status
- Validação dos dados
- Tratamento global de exceções

## Endpoints

| Método | Endpoint |
|---|---|
| GET | `/api/tarefas` |
| GET | `/api/tarefas/{id}` |
| POST | `/api/tarefas` |
| PUT | `/api/tarefas/{id}` |
| PATCH | `/api/tarefas/{id}/concluir` |
| DELETE | `/api/tarefas/{id}` |
| GET | `/api/tarefas/status/{status}` |

## Swagger

Após iniciar a aplicação:

`http://localhost:8080/swagger-ui/index.html`

