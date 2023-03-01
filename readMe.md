# Desafio Técnico Backend

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/iuricode/README-template?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/iuricode/README-template?style=for-the-badge)

> Este projeto faz o registro de CPF's com suspeitas de fraude.

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
Uma vez que todas essas ferramentas e dependências estejam instaladas e configuradas, você pode executar o projeto Spring Boot usando o comando <mvn spring-boot:run>, , ou clicando no botão "Run" na sua IDE.

## ☕ Usando <Desafio_Técnico_BackEnd>

Para usar <Desafio_Técnico_BackEnd>, siga estas etapas:

Caso o programa esteja rodando localmente, basta acessar o endereço <http://localhost:8080/cpf>
#### O método GET em </cpf> vai trazer a lista de todos os cpfs registrados.
#### O método GET em </cpf/{cpf}> vai trazer os dados do cpf em específico registrado.
#### O método POST em </cpf> vai registrar um cpf.
#### O método PUT em </cpf/{cpf}> vai atualizar aquele cpf específico enviado pelo parâmetro para parâmetro que foi enviado pelo body da requisição.
#### O método DELETE em </cpf/{cpf}> vai deletar aquele cpf específico do parâmetro.
#### Os métodos POST e PUT esperam um corpo no formato {cpf: String}, sendo o cpf sem formatação xxx.xxx.xxx-xx

[⬆ Voltar ao topo](#Desafio Técnico Backend)<br>
