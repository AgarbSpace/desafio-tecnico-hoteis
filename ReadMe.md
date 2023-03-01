# Desafio Técnico Backend

## :computer: Características do projeto

- Este projeto faz o registro de CPF's com suspeitas de fraude.
- Ele foi construído usando Java Spring Boot
- Optei por usar a Arquitetura de camadas ou Arquitetura MVC (Model-View-Controller), pois ela traz uma Separação por Responsabilidades, Reutilização de Código, Desenvolvimento Paralelo, Facilidade de Teste e Flexibilidade.
- Optei também por usar o banco de dados H2 por ser um banco relacional mais prático para o desenvolvimento, além de trazer maior desempenho, poder ser executado em memória ou em disco e ter facilidade para a realização dos testes.
- Eu fiz os testes unitários de todas as funcionalidades e add-cases que consegui ver, utilizando o JUnit 5 e Mockito por serem ferramentas amplamente utilizadas no ecossistema do SpringBoot além da praticidade para configurações, diversos Asserts para verificar o resultado do código, cobertura de código e criação de objetos simulados para ver comportamento de classes e métodos.
- Utilizei estrutura de organização de pacotes mais comum na comunidade (com.example.app).

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente do `<Java / Maven>`
- Você tem uma máquina `<Windows / Linux / Mac>`.

## 🚀 Instalando <Desafio_Técnico_BackEnd>

Para instalar o <Desafio_Técnico_BackEnd>, siga estas etapas:


Na raiz do projeto, utilize o comando

```
<mvn clean install>
```

Esse comando irá baixar as dependências do projeto e instalá-las em seu repositório local do Maven.
Uma vez que todas essas ferramentas e dependências estejam instaladas e configuradas, você pode executar o projeto Spring Boot usando o comando 

```
<mvn spring-boot:run>
```
,  ou clicando no botão "Run" na sua IDE.
## ☕ Usando <Desafio_Técnico_BackEnd>

Para usar <Desafio_Técnico_BackEnd>, siga estas etapas:

Caso o programa esteja rodando localmente, basta acessar o endereço <http://localhost:8080/cpf>
##### O método GET em /cpf vai trazer a lista de todos os cpfs registrados.
##### O método GET em </cpf/{cpf}> vai trazer os dados do cpf em específico registrado.
##### O método POST em /cpf vai registrar um cpf.
##### O método PUT em </cpf/{cpf}> vai atualizar aquele cpf específico enviado pelo parâmetro para parâmetro que foi enviado pelo body da requisição.
##### O método DELETE em </cpf/{cpf}> vai deletar aquele cpf específico do parâmetro.
#### Os métodos POST e PUT esperam um corpo no formato {cpf: String}, sendo o cpf sem formatação xxx.xxx.xxx-xx


