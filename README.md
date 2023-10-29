# Projeto web com Spring Boot e banco MongoDB (NoSQL)
[![NPM](https://img.shields.io/bower/l/react)](https://github.com/devjleonardo/workshop-springboot3-mongodb/blob/main/LICENSE)

# Sobre o projeto

Este repositório é um projeto de um serviço web construído durante o curso **Programação Orientada a Objetos +Projetos**, ministrado pela [DevSuperior](https://devsuperior.com "Site da DevSuperior").

A aplicação consiste em um sistema de postagens simples, onde contém um CRUD (Create, Read, Update, Delete) básico com alguns dados inseridos manualmente e alguns podem ser insredios via web (Rest).

# Objetivos
- Compreender as principais diferenças entre paradigma orientado a documentos e relacional
- Implementar operações de CRUD
- Refletir sobre decisões de design para um banco de dados orientado a documentos
- Implementar associações entre objetos
    - Objetos aninhados
    - Referências
- Realizar consultas com Spring Data e MongoRepository

## Modelo conceitual
![Modelo conceitual](https://raw.githubusercontent.com/devjleonardo/assets/main/workshop-springboot3-mongodb/Modelo%20conceitual.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Spring Data
- Maven

## Banco de dados NoSQL
- MongoDB

# Como executar o projeto

## Back end
Pré-requisitos: Java 17 e Spring boot 3

```bash
# clonar repositório
git clone https://github.com/devjleonardo/workshop-springboot3-mongodb.git

# entrar na pasta do projeto back end

# executar o projeto
./mvnw spring-boot:run
```

# Autor

José Leonardo: <br/>
https://www.linkedin.com/in/jose-leonardo-cordeiro-bahia/

Professor: Nélio Alves <br/>
https://github.com/acenelio
