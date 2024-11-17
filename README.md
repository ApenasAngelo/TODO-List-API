# ☕ TODO List API

## 📜 Descrição

API RESTful para gerenciamento de tarefas (TODO List) desenvolvida em Java. O projeto foi criado visando
aprimorar conhecimentos em programação orientada a objetos e práticas de desenvolvimento de software.

### Endpoints

- GET /tasks - Retorna todas as tarefas do usuário autenticado
- GET /tasks/{id} - Retorna uma tarefa específica por ID do usuário autenticado
- POST /tasks - Cria uma nova tarefa para o usuário autenticado
- PUT /tasks - Atualiza uma tarefa do usuário autenticado
- DELETE /tasks/{id} - Deleta uma tarefa específica por ID do usuário autenticado
- POST /users/register - Registra um novo usuário
- PUT /users/change-password - Altera a senha do usuário autenticado

### Diagrama:

```mermaid
classDiagram
    class Task {
        +Integer id
        +Integer userId
        +String title
        +String description
        +Boolean completed
        +Date createdAt
        +Date updatedAt
    }

    class User {
        +Integer id
        +String username
        +String password
        +String role
    }

    class TaskRepository {
        +List~Task~ findByUserId(Integer userId)
    }

    class UserRepository {
        +User findByUsername(String username)
    }

    class TaskController {
        +List~Task~ getTasks()
        +Task getTask(Integer id)
        +void createTask(Task task)
        +void updateTask(Task task)
        +void deleteTask(Integer id)
    }

    class UserController {
        +void changePassword(ChangePasswordRequest changePasswordRequest)
    }

    class SecurityDatabaseService {
        +UserDetails loadUserByUsername(String username)
    }

    class WebSecurityConfig {
        +SecurityFilterChain filterChain(HttpSecurity http)
        +PasswordEncoder passwordEncoder()
    }

    Task --> User : "userId"
    TaskController --> TaskRepository
    UserController --> UserRepository
    SecurityDatabaseService --> UserRepository
    WebSecurityConfig --> SecurityDatabaseService
```

## ⚙️ Construção

Recursos utilizados na construção do projeto.

### 💻 Tecnologias

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

### 🛠️ Ferramentas

![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![GIT](https://img.shields.io/static/v1?label=&message=GIT&color=%23F05032&style=for-the-badge&logo=git&logoColor=whitesmoke)
![GITHUB](https://img.shields.io/static/v1?label=&message=GITHUB&color=%23181717&style=for-the-badge&logo=github&logoColor=whitesmoke)

## ✏️ Aprendizado

- Aprofundamento em conhecimentos de programação orientada a objetos em Java;
- Ambiente de desenvolvimento Java configurado;
- Familiarização com o uso de repositórios Git;
- Desenvolvimento de API RESTful utilizando Spring Boot;
- Configuração e utilização do PostgreSQL como banco de dados;
- Implementação de tratamento de exceções para garantir a robustez da aplicação;
- Integração de Spring Security para autenticação e autorização;
- Uso do Spring Data JPA para simplificar o acesso a dados.
## ✒️ Autores

Miguel Angelo Gonzaga Marques - [GitHub](https://github.com/ApenasAngelo)

## 📨 Contato

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/miguelangelogonzaga/)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:mangelogm28@gmail.com)