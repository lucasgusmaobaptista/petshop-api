<h1 align="center">PetShop API</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Linkedin&message=devlucasgusmao&color=1921E1&labelColor=000000" alt="devlucasgusmao" />
</p>

A PetShop API é uma aplicação Spring Boot desenvolvida para gerenciar reservas de pets em uma pet shop. Esta API permite criar, atualizar, deletar e buscar reservas por ID, nome do pet ou horário de reserva.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven/Gradle
- JPA/Hibernate
- MySQL

## Requisitos

Para executar este projeto, você precisará ter instalado:

- JDK 11 ou superior
- Maven ou Gradle
- IDE de sua preferência (recomendado: IntelliJ IDEA)
- Ferramenta para teste de Endpoints (recomendado: Isomnia ou Postman)

## Configuração

Clone o repositório para sua máquina local usando:

`git clone https://github.com/seu-usuario/petshop-api.git`

## Instalação

### Com Maven

Execute o seguinte comando na raiz do projeto para compilar o projeto e baixar as dependências:

`mvn clean install`

### Com Gradle

Execute o seguinte comando na raiz do projeto para compilar o projeto e baixar as dependências:

`gradle build`

## Configurações Básicas

Abra o arquivo src/main/resources/application.properties e configure as propriedades do banco de dados:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/produtos_db
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
(ESCOLHA UM BASEADO NA SUA VERSÃO DO MYSQL)
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
(ESCOLHA UM BASEADO NA SUA VERSÃO DO MYSQL)
```

## Execução

### Com Maven

Execute o seguinte comando na raiz do projeto para iniciar a aplicação:

`mvn spring-boot:run`

### Com Gradle

Execute o seguinte comando na raiz do projeto para iniciar a aplicação:

`gradle bootRun`

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

A API disponibiliza os seguintes endpoints:

-     `GET /pet/find`: Lista todas as reservas.
-     `GET /pet/find/{id}`: Busca uma reserva pelo ID.
-     `GET /pet/find/nome/{nome}`: Busca reservas pelo nome do pet.
-     `GET /pet/find/horario/{horario}`: Busca reservas pelo horário.
-     `POST /pet/create`: Cria uma nova reserva.
-     `PUT /pet/update/{id}`: Atualiza uma reserva existente.
-     `DELETE /pet/delete/{id}`: Deleta uma reserva pelo ID.

## Contribuindo

Contribuições são sempre bem-vindas! Para contribuir, por favor, crie um fork do repositório, crie uma branch para sua feature, faça suas alterações e envie um pull request.



