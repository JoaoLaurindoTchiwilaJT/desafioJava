Para completar o documento de documentação do projeto "Gestor de Tarefas", vou adicionar as seções "Capturas de Tela", "Estrutura de Pastas", "Dependências", "Autores" e "Agradecimentos". Esse conteúdo irá detalhar melhor a estrutura do projeto e facilitar a configuração.

---

## Sistema de Gestão de Tarefas em Java

# Gestor de Tarefas

Este aplicativo permite o gerenciamento de tarefas para ajudar o usuário a organizar seus afazeres.

## Índice

- [Visão Geral](#visão-geral)
- [Recursos](#recursos)
- [Capturas de Tela](#capturas-de-tela)
- [Instalação](#instalação)
- [Uso](#uso)
- [Configuração](#configuração)
- [Estrutura de Pastas](#estrutura-de-pastas)
- [Dependências](#dependências)
- [Autores](#autores)
- [Agradecimentos](#agradecimentos)

## Visão Geral

Esse projeto é uma aplicação para gerenciamento de tarefas pessoais, com suporte a listas de tarefas. Foi desenvolvido para ajudar usuários a organizar suas atividades de forma prática.

## Recursos

Lista de funcionalidades principais do projeto:

- Criação, edição e exclusão de tarefas
- Visualização de tarefas em uma tabela
- Atualização do status das tarefas

## Capturas de Tela

Aqui estão algumas capturas de tela do projeto:

![Tela Principal](./screenshots/Captura de Tela (9).png)
*Figura 1: Tela principal de visualização de tarefas*

![Tela de Cadastro](./screenshots/tela_cadastro.png)
*Figura 2: Tela de cadastro de nova tarefa*

## Instalação

Instruções para clonar o repositório e configurar o ambiente local.

### Pré-requisitos

- **Java** 8+ ou superior
- **Maven** 3.4
- **Git**

### Passo a passo

1. Clone o repositório:

    ```bash
    git clone https://github.com/JoaoLaurindoTchiwilaJT/desafioJava
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd nome-do-projeto
    ```

3. Instale as dependências:

    ```bash
    mvn install
    ```

4. Execute o projeto:

    ```bash
    mvn exec:java -Dexec.mainClass="com.exemplo.GerenciadorDeTarefa"
    ```

## Uso

Explicação sobre como usar o projeto e exemplos de comandos.

### Exemplo de uso

1. Acesse o sistema.
2. Visualize as tarefas.
3. Crie uma nova tarefa com os detalhes desejados.
4. Atualize uma tarefa já existente.

## Configuração

### Configuração do arquivo `persistence.xml`

Configure o arquivo `persistence.xml` para definir a conexão com o banco de dados MySQL.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
    http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
    version="2.1">
    
    <persistence-unit name="desafio" transaction-type="RESOURCE_LOCAL">
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/desafio?useSSL=false&amp;serverTimezone=UTC&amp;characterEncoding=UTF-8" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
        </properties>
    </persistence-unit>
</persistence>
```

## Estrutura de Pastas

Aqui está uma visão geral da estrutura do projeto:

```plaintext
Gestor_de_Tarefas/
├── Source Packages/
│   ├── Entity/
│   │    ├── Task.java
│   ├── Repository
│   │    ├── TaskManager.java
│   │   UI 
│   │    ├──GerenciadorDeTarefa.java   
│   │   UTIL   
│   │    ├──Gestor_de_Tarefas.java  
│   │    ├──Processo.java
│   ├── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
├── pom.xml
└── README.md
```

- **GerenciadorDeTarefa.java**: Classe principal da aplicação.
- **Task.java**: Modelo de dados de tarefa.
- **TaskManager.java**: Classe de gerenciamento de tarefas.
- **persistence.xml**: Configuração de persistência JPA.
- **processo.java**: Verificação de UUID correcto e verificação do combobox.
- **Gestor_de_Tarefas.java**: Classe usada para testes no console.

## Dependências

As principais dependências do projeto estão listadas no `pom.xml`:

- **JPA (Java Persistence API)** para persistência de dados.
- **Hibernate** para ORM.
- **MySQL Connector** para integração com o banco de dados MySQL.
- **Swing** para a interface gráfica do usuário.

## Autores

- João Laurindo Tchiwila (Tchiwila) - Desenvolvedor do projeto.

## Agradecimentos

Agradecemos a todos que contribuíram com o desenvolvimento deste sistema de gestão de tarefas.