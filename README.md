# Project Gestion

## Descrição:
Project Gestion é um sistema de gestão de projetos desenvolvido seguindo os princípios do Clean Architecture e Domain-Driven Design (DDD). O projeto permite criar, visualizar e deletar projetos com funcionalidades de persistência e validações. Ele foi construído utilizando o framework Spring Boot, e a camada de persistência é feita por meio de repositórios.

## Funcionalidades
* Criar e salvar projetos no banco de dados
* Consultar todos os projetos cadastrados
* Consultar um ID específico por projeto
* Deletar projetos

## Estrutura do Projeto:
* application: Contém DTO (Data Transfer Object), use cases e mapper.
* domain: Contém entidades, modelos e serviços de negócio.
* infra: Cotntém a camada de persistência, repositórios e controladores.

## Tecnologias Utilizadas:
* Versão do Java: 17
* Spring Web
* Spring DevTools
* Spring JPA
* H2 Database
* JUnit e Mockito

# Para rodar no Docker
Para criar uma imagem do Docker:
```bash
  docker build -f deploy/Dockerfile -t project_gestion .
```

Para criar um contêiner do Docker:
```bash
    docker run -d --name project_gestion_container project_gestion
```

Verificar o status do Docker
```bash
  docker ps
```
# Kubernetes
Para rodar o código:
```bash
     minikube start --driver=docker
```

Criar um Deployment de Teste
```bash
    kubectl create deployment hello-minikube --image=kicbase/echo-server:1.0
```

Expor o Serviço
```bash
  kubectl expose deployment hello-minikube --type=NodePort --port=8080
```

Acessar o serviço de navegador

# JSON
```
Projects:
[
    {
        "id": 1,
        "name": "CyberTruck Tesla",
        "description": "Automotive",
        "startDate": "2020-01-01",
        "endDate": "2020-02-01"
    },
    {
        "id": 2,
        "name": "iPhone 16",
        "description": "Apple",
        "startDate": "2026-06-01",
        "endDate": "2026-07-01"
    },
    {
        "id": 3,
        "name": "MacBook",
        "description": "Apple",
        "startDate": "2025-01-01",
        "endDate": "2025-02-01"
    },
    {
        "id": 4,
        "name": "MacBook Pro",
        "description": "Apple",
        "startDate": "2025-02-01",
        "endDate": "2025-03-01"
    },
    {
        "id": 5,
        "name": "Civic Car",
        "description": "Automotive Honda",
        "startDate": "2027-01-01",
        "endDate": "2027-02-01"
    }
]
```
```
Tasks:
[
    {
        "id": 1,
        "name": "Tesla Testing",
        "complete": true
    },
    {
        "id": 2,
        "name": "Apple Testing",
        "complete": true
    },
    {
        "id": 3,
        "name": "Apple Testing",
        "complete": true
    },
    {
        "id": 4,
        "name": "Apple Testing",
        "complete": true
    },
    {
        "id": 5,
        "name": "Honda Testing",
        "complete": true
    }
]
```

## Licença
Este projeto está licenciado sob Gabriel de Souza Conceição