# Sistema de Gerenciamento para Locadora de Veículos

API básica desenvolvida em Java, utilizando Spring Boot, JPA (Spring Data JPA) e MySQL, que permite gerenciar clientes, veículos e reservas para uma locadora de veículos.

## Configuração e Execução

### Requisitos Prévios
- JDK (Java Development Kit) 8 ou superior instalado
- Maven instalado
- MySQL Server instalado e em execução (com um banco de dados vazio criado)

### Configuração do Banco de Dados
1. Crie um banco de dados MySQL vazio com um nome de sua escolha.

### Configuração da Aplicação
1. Clone ou faça o download do repositório.
2. Abra o arquivo `application.properties` localizado em `src/main/resources`.
3. Configure as propriedades do banco de dados (`spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password`) de acordo com a sua instalação do MySQL.

### Execução da Aplicação
1. Navegue até o diretório raiz do projeto.
2. Execute o seguinte comando no terminal:

```cmd
mvn spring-boot:run
```
A aplicação será iniciada e estará pronta para receber requisições.
