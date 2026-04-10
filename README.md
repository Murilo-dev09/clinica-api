# Clínica API

API REST desenvolvida para gerenciamento de uma clínica médica, permitindo o controle de médicos, pacientes e consultas.

Esse projeto foi criado como parte do meu portfólio, com foco em praticar o desenvolvimento backend utilizando Java e Spring Boot em um cenário mais próximo do mundo real.

## 🔗 Acesso

A API está documentada e disponível para testes via Swagger:

🔗 **[Acesse o Swagger UI aqui](https://clinica-api-pkwl.onrender.com/swagger-ui/index.html)**

### 🔐 Credenciais de teste

Para acessar os endpoints protegidos, utilize:

* **Login:** admin
* **Senha:** 123456

> Após realizar o login no endpoint `/login`, utilize o token JWT no botão **Authorize** no Swagger.

---

## ⚙️ Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Flyway
* Maven
* Swagger

---

## 🚀 Funcionalidades

* CRUD de médicos
* CRUD de pacientes
* Agendamento de consultas
* Listagem de consultas
* Cancelamento e exclusão de consultas
* Controle de status (AGENDADA, CANCELADA, REALIZADA)
* Autenticação com Spring Security (JWT)
* Tratamento global de exceções

---

## 🧱 Estrutura

O projeto segue o padrão de arquitetura em camadas:

Controller → Service → Repository

---

## 👨‍💻 Autor

Desenvolvido por Murilo
Estudante de Engenharia de Software
