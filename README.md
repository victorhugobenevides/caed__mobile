# CAED Mobile

**CAED Mobile** é um aplicativo voltado para o gerenciamento de catálogos e controle de estoque de produtos. O app é desenvolvido para a plataforma Android, utilizando Jetpack Compose, seguindo os princípios da Clean Architecture e práticas modernas de desenvolvimento.

## Índice
- [Funcionalidades Principais](#funcionalidades-principais)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Integração Contínua com CircleCI](#integração-contínua-com-circleci)
- [Estrutura de Diretórios](#estrutura-de-diretórios)
- [Testes](#testes)
- [Contribuição](#contribuição)

## Funcionalidades Principais

- **Autenticação de Usuários**: Gerenciamento seguro de usuários e autenticação.
- **Controle de Estoque**: Gerenciamento de pacotes e status de pedidos.
- **Interface Moderna**: Utilização de Jetpack Compose para criar uma interface de usuário nativa e responsiva.
- **Navegação Dinâmica**: Suporte ao Navigation Component para navegação entre telas.
- **Componentes Reutilizáveis**: Implementação de componentes UI reutilizáveis e centralização de temas visuais.

## Estrutura do Projeto

O projeto segue a **Clean Architecture**, organizada em diferentes camadas para garantir a separação de responsabilidades, modularidade e fácil manutenção:

- **Data Layer**: Implementações de repositórios, modelos de dados e comunicação com APIs.
- **Domain Layer**: Contém os casos de uso e interfaces de repositórios.
- **UI Layer**: Contém telas, componentes visuais e lógica de apresentação com Jetpack Compose.
- **Navigation**: Gerenciamento das rotas de navegação entre telas.
- **Theme**: Definição centralizada de temas, cores, tamanhos de fontes e estilos de texto.

## Tecnologias Utilizadas

- **Kotlin**: Linguagem de programação principal para desenvolvimento Android.
- **Jetpack Compose**: Ferramenta moderna para construção de interfaces nativas no Android.
- **Dagger Hilt**: Framework de injeção de dependência para gerenciar a criação de objetos.
- **Retrofit**: Biblioteca para comunicação com APIs REST.
- **Coroutines**: Utilizado para operações assíncronas.
- **Material3**: Design system para criação de componentes visuais consistentes.
- **JUnit e Espresso**: Para testes unitários e testes de interface.

## Pré-requisitos

- Android Studio Dolphin ou superior.
- Kotlin 1.5 ou superior.
- JDK 11 ou superior.

## Como Executar o Projeto

1. **Clone o repositório**:
    ```bash
    git clone <URL_DO_REPOSITORIO>
    cd caed
    ```

2. **Abra o projeto no Android Studio**:
   - Selecione a opção "Open Project" e escolha o diretório clonado.

3. **Configure o ambiente**:
   - Verifique se o SDK do Android está configurado corretamente (versão mínima do SDK especificada no `build.gradle`).

4. **Execute o projeto**:
   - Conecte um dispositivo Android ou inicie um emulador.
   - Clique em "Run" ou use o atalho `Shift + F10`.

O projeto utiliza **CircleCI** para integração contínua, permitindo a execução automática de testes e a construção de builds. A configuração está definida no arquivo `.circleci/config.yml` e inclui:

![Pipelines e resultatos de testes](https://ibb.co/ZKBHKdx)


- **Instalação das dependências**: Configuração do ambiente com o JDK 17 e permissões de execução para o script `gradlew`.
- **Execução de testes unitários**: São executados testes unitários para verificar a lógica de negócios e a integração dos componentes.
- **Construção do APK**: Compilação do APK no modo debug.
- **Armazenamento de artefatos**: Os resultados dos testes e o APK gerado são armazenados como artefatos.

## Estrutura de Diretórios

```plaintext
caed-mobile/
│
├── app/                    # Aplicativo Android principal
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/itbenevides/caed/
│   │   │   │   ├── ui/                # Camada de apresentação
│   │   │   │   ├── navigation/        # Navegação
│   │   │   │   └── theme/             # Estilos e temas
│   │   │   └── res/                   # Recursos (layouts, imagens)
│   │   └── AndroidManifest.xml
│   └── build.gradle
│
├── core/                 # Módulo central compartilhado
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/itbenevides/core/
│   │   │   │   ├── data/              # Modelos de dados e utilitários
│   │   │   │   ├── domain/            # Casos de uso reutilizáveis
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── README.md
```
    
## Testes

Os testes estão divididos nas seguintes camadas:

- **Testes unitários**: Localizados em `app/src/test`, verificando a lógica de negócio e integração dos casos de uso.
- **Testes de interface**: Localizados em `app/src/androidTest`, focando em componentes visuais e interações de usuário com o Espresso e o Compose Testing.

## Contribuição

Se você deseja contribuir para o projeto CAED Mobile, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie um branch para suas alterações:

```bash
git checkout -b feature/nova-funcionalidade
