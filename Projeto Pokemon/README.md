# 📦 Sistema de  Cadastro de Produtos, Usuario e Genero

Aplicação Desktop desenvolvida em **Java** com interface gráfica moderna construída no **SceneBuilder (JavaFX)** e persistência de dados no **MySQL**. O sistema permite gerenciar usuários, produtos e gêneros.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

- **Linguagem:** Java (JDK)
- **Interface Gráfica:** JavaFX & SceneBuilder (FXML)
- **Banco de Dados:** MySQL
- **Conectividade:** JDBC (Java Database Connectivity)
- **IDEs / Ferramentas:** VS Code / SceneBuilder

---

## ✨ Funcionalidades

- [x] **Cadastro de Usuários:** Cadastro, listagem.
- [x] **Cadastro de Produtos:** Cadastro de itens com vínculo de categorias.
- [x] **Cadastro de Gêneros:** Cadastro, listagem E Uniao Com Usuarios.
- [x] **Integração com MySQL:** Operações completas de CRUD (Create, Read, Update, Delete).

---

## 🗄️ Estrutura do Banco de Dados

Para rodar este projeto, utilize o script SQL abaixo para criar a estrutura do banco:

```sql
-- Exemplo de criação do banco de dados
CREATE DATABASE if NOT EXISTS BancoSQL;
USE BancoSQL;

CREATE TABLE if NOT EXISTS Sexualidade(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcao VARCHAR(50) not null,
    Sigla VARCHAR(20) not null,
    Status CHAR(1) not null
);

CREATE TABLE if NOT EXISTS Usuarios(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) not null,
    CPF VARCHAR(16) not null,
    Nascimento DATE not null,
    Telefone VARCHAR(15) not null,
    ID_Genero INT,
    Civil VARCHAR(30) not null,
    CEP VARCHAR(9) NOT NULL,
    Logradouro VARCHAR(160) NOT NULL,
    Bairro VARCHAR(60) NOT NULL,
    Cidade VARCHAR(60),
    UF CHAR(2) NOT NULL,
    Numero INT,
    Complemento VARCHAR(150),
    

    CONSTRAINT fk_usuario_genero
    Foreign Key (ID_Genero) REFERENCES Sexualidade(ID)
    ON DELETE SET NULL
);

CREATE TABLE if NOT EXISTS Produtos(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50) not null,
    Categoria VARCHAR(50) not null,
    Estoque INT DEFAULT(0),
    Validade DATE DEFAULT("Sem Validade"),
    PrecoCusto DECIMAL(10,2) DEFAULT(0),
    PrecoVenda DECIMAL(10,2) DEFAULT(0),
    Status VARCHAR(25) DEFAULT("Inativo")
);