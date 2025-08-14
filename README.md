# Sistema de Gestão de Pedidos e Estoque

## Descrição
Este é um sistema de **gestão de pedidos e controle de estoque** desenvolvido em **Java** utilizando **Spring Boot**.  
O projeto demonstra boas práticas de desenvolvimento back-end, como **arquitetura em camadas**, **validações**, **relacionamentos entre entidades** e **API RESTful**.  

O sistema permite:
- Criar, listar e gerenciar produtos.  
- Criar pedidos vinculando produtos ao estoque.  
- Atualizar o estoque automaticamente ao criar pedidos.  
- Validação de dados e tratamento de exceções.  
- (Opcional) Documentação interativa da API via Swagger.  

---

## Tecnologias Utilizadas
- Java 17+  
- Spring Boot 3.3.x  
- Spring Web  
- Spring Data JPA  
- H2 Database (pode ser alterado para MySQL/PostgreSQL)  
- Validation (Bean Validation com Jakarta)  
- Lombok  
- Spring Boot DevTools  
- Springdoc OpenAPI (opcional, para documentação Swagger)  

---

## Estrutura do Projeto
src/main/java/com/keven/pedidosestoque
├── controller # APIs REST
├── dto # Data Transfer Objects
├── exception # Tratamento de exceções
├── model # Entidades do banco de dados
├── repository # Repositórios JPA
├── service # Regras de negócio
└── util # Utilitários e helpers


---

## Funcionalidades
1. **Produtos**
   - Criar produto com nome, preço e quantidade em estoque.
   - Listar todos os produtos.
   - Buscar produto por nome.

2. **Pedidos**
   - Criar pedidos adicionando múltiplos produtos.
   - Calcular total do pedido automaticamente.
   - Atualizar estoque ao criar pedidos.
   - Validação de quantidade disponível no estoque.

3. **Tratamento de Erros**
   - Exceções personalizadas com mensagens claras.

4. **Documentação da API (opcional)**
   - Swagger UI: `/swagger-ui.html`  

---

## Rodando o Projeto
1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/pedidos-estoque.git
   
Autor
Keven Nogueira da Silva
Desenvolvedor Back-End Java | Spring Boot
LinkedIn | GitHub
