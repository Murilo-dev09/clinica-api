# 🏥 Clínica API

Projeto desenvolvido como **portfólio pessoal** e também como forma de **estudo de desenvolvimento backend com Java e Spring Boot**.

A API permite gerenciar uma clínica médica, incluindo cadastro de médicos, pacientes e agendamento de consultas.

---

## 🚀 Link de Acesso

A API está documentada e disponível para testes através do Swagger:

🔗 **[Acesse o Swagger UI aqui](https://clinica-api-pkwl.onrender.com/swagger-ui/index.html)**

---

## 🔐 Credenciais de Teste (Admin)

Para utilizar os endpoints protegidos, utilize o usuário administrador padrão já cadastrado no banco de dados:

| Campo | Valor |
| :--- | :--- |
| **Login** | `admin` |
| **Senha** | `123456` |

> **Nota:** Para acessar os endpoints, primeiro realize o login no endpoint `/login` para obter o Token JWT e, em seguida, utilize o botão **"Authorize"** no topo do Swagger.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Flyway
- Maven

---

## 📦 Funcionalidades

✔️ CRUD de médicos  
✔️ CRUD de pacientes  
✔️ Agendamento de consultas  
✔️ Listagem de consultas  
✔️ Exclusão de consultas  
✔️ Controle de status da consulta (AGENDADA, CANCELADA, REALIZADA)  
✔️ Autenticação com Spring Security  
✔️ Tratamento global de exceções

---

## 🧪 Como rodar o projeto

### Pré-requisitos

- Java 17 instalado
- MySQL rodando localmente
- IntelliJ (opcional, mas recomendado)

Configurar o MySQL para suportar caracteres UTF-8 (ou conforme sua necessidade).

---

### Clonar o repositório

```bash
git clone https://github.com/Murilo-dev09/clinica-api.git

👨‍💻 Autor
Desenvolvido por Murilo
Estudante de Engenharia de Software
