# Cadastro de pet

## Descrição
Este é um projeto Android desenvolvido como parte da avaliação AV2 para a disciplina de Programação para Dispositivos Móveis (PDM) para UERJ/ZO. O projeto utiliza o sistema de build Gradle e está configurado com Kotlin Script (`.kts`).

## Estrutura do Projeto

Através deste trabalho, foi desenvolvida uma aplicação mobile na IDE Android Studio que realiza operações de armazenamento, exclusão e alteração de dados (CRUD) para registros de cadastro de Pets (animais de estimação). Esses registros são mantidos em uma tabela chamada "pets.db" no banco de dados SQLite. A tabela possui sete colunas, cada uma representando um tipo de dado diferente:

- **id:** do tipo long
- **nome:** do tipo String
- **idade:** do tipo int
- **vacinado:** do tipo boolean
- **sexo:** do tipo char (com valores "M" ou "F")
- **peso:** do tipo double
- **altura:** do tipo float
O aplicativo conta com duas telas, com passagem de dados entre elas: uma tela principal que mostra ao usuário os registros presentes na tabela e uma segunda tela onde o usuário pode alterar, incluir ou excluir um registro da tabela. Caso seja optado por realizar uma alteração, a segunda tela será automaticamente preenchida com os dados do registro selecionado.

## Como executar
1. Clone este repositório.
2. Abra o projeto no Android Studio.
3. Sincronize o Gradle.
4. Construa e execute o aplicativo em um dispositivo ou emulador Android.

## Requisitos
- Android Studio (versão compatível com Kotlin e Gradle).
- JDK 11 ou superior.

## Licença
Este projeto está licenciado sob a licença MIT.
"""
