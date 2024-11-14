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

*Figura 1: Tela de Inicio*

![Captura de Tela (9)](https://github.com/user-attachments/assets/c261c768-31d6-4930-900e-737ed44cfe07)

*Figura 2: Tela de vizualização de Tasks*

![Captura de Tela (10)](https://github.com/user-attachments/assets/08ce1c0b-209c-426c-ab89-aea98e69039f)

*Figura 3: Tela de cadastro de nova Task*

![Captura de Tela (14)](https://github.com/user-attachments/assets/780a8de1-998f-4ef2-9c27-376e4d619d38)

*Figura 4: Tela de actualização de Task*

![Captura de Tela (12)](https://github.com/user-attachments/assets/34114351-8069-46b9-811c-f2b650aaa0e6)


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

Configure o arquivo `persistence.xml` para definir a conexão com o banco de dados em memoria H2.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
    http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
	version="2.1">

	<persistence-unit name="desafio" transaction-type="RESOURCE_LOCAL">
		<properties>
			<!-- URL do banco de dados H2 em memória -->
			<property name="javax.persistence.jdbc.url" 
				value="jdbc:h2:mem:desafio;DB_CLOSE_DELAY=-1" />
				
			<!-- Configuração do driver para H2 -->
			<property name="javax.persistence.jdbc.driver" 
				value="org.h2.Driver" />

			<!-- Usuário e senha padrão para H2 em memória -->
			<property name="javax.persistence.jdbc.user" value="sa" />
			<property name="javax.persistence.jdbc.password" value="" />

			<!-- Configuração do Hibernate para atualizar o banco -->
			<property name="hibernate.hbm2ddl.auto" value="update" />
			
			<!-- Dialeto para H2 -->
			<property name="hibernate.dialect" 
				value="org.hibernate.dialect.H2Dialect" />
			
			<!-- Habilita logs do SQL para depuração -->
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
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
