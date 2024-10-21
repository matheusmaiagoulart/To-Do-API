<h1 align="center">
  Lista de Tarefas App
</h1>

# Sobre o projeto
API Rest de lista de Tarefas em que o usuário consegue Cadastrar, Editar, Ler, Excluir e achar uma tarefa pelo ID, interagindo diretamente com um Front-End intuitivo.

## 👨‍💻 Desenvolvedor

* [Matheus Maia Goulart](https://www.linkedin.com/in/matheusmaiagoulart/)


## 💻  Tecnologias

- Frontend:
  - HTML
  - CSS
  - JavaScript
- Backend:
  - Java 17
  - Framework (Spring Boot)
  - Maven (Gerenciamento das Dependências)
  - Jpa (Interações com o Banco de Dados)
  - Flyway (Migrations/Scheamas, criação automatica da estrutura do Banco de Dados)
  - Spring Web (Suporte ao desenvolvimento Web)
- Database:
  - MySQL (MySQL WorkBench)
- Ferramentas:
  - IntelliJ IDE (Plataforma de Desenvolvimento da Aplicação)
  - Postman (Test de requisições HTTP)
  - Git (Controle do versionamento do Código)


## ⤵ Instruções de utilização

Essas instruções vão te auxiliar a ter cópia do projeto rodando em sua máquina local para testar a aplicação.

Pré-requisitos:
- Ter instalado todas as ferramentas e tecnologias indicadas.
  - Java
  - IntelliJ
  - Maven (com as dependências)
  - MySQL

## Clone da Aplicação
Clone a aplicação para sua máquina usando o seguinte código no Terminal:


      git clone https://github.com/matheusmaiagoulart/To-Do-API.git
      cd To-Do-API

## Conexão com o Banco de Dados
Abra na IDE IntelliJ e faça as alterações para seu login no Banco de Dados SQL na parte de resources/applications.properties

  ```xml
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.url=jdbc:mysql://localhost/todo-api
  spring.datasource.username=root -> seu usuario do Banco de Dados
  spring.datasource.password=admin -> sua senha para conectar no Banco de Dados
  spring.jpa.show-sql=true
  ```

## Criação do Banco de Dados
Após isso, crie no seu MySQL um Banco de Dados chamado todo-api. Logo em seguida, poderá rodar o projeto, e a estrutura do Banco de Dados será criada automaticamente!


<h3>Você poderá visualizar os endpoints aqui, com a aplicação já rodando: </h3>

[Swagger EndPoints](http://localhost:8080/swagger-ui/index.html#/)


## Front-End

Para acessar o Front-End acesse esse link ou entre na pasta View/index.HTML e entre pelo navegador que preferir dentre as opções que o IntelliJ dá:

[Front-End](http://localhost:63342/todo-simple-API/todo-simple-API/src/main/java/com/matheusmaia/todo_simple_API/View/index.html)

ou:
  ```
  http://localhost:63342/todo-simple-API/todo-simple-API/src/main/java/com/matheusmaia/todo_simple_API/View/index.html
  ```
## EndPoints Detalhados

<img src="Vieew/img/GETMétodo" alt="Método para pegar todas as Tarefas já cadastradas">