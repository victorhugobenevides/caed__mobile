# CAED Mobile

**CAED Mobile**

<a href="https://github.com/victorhugobenevides/caed__mobile/blob/master/app/src/main/res/demo.gif">
<img src="https://github.com/victorhugobenevides/caed__mobile/blob/master/app/src/main/res/demo.gif" alt="Demo" width="500"/>
</a>

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
- **JUnit**: Para testes unitários e testes de interface.

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

<a href="https://github.com/victorhugobenevides/caed__mobile/blob/master/app/src/main/res/circleci_image.png">
<img src="https://github.com/victorhugobenevides/caed__mobile/blob/master/app/src/main/res/circleci_image.png" alt="Pipelines e resultatos de testes" width="500"/>
</a>

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
- **Testes de interface**: Localizados em `app/src/androidTest`, focando em componentes visuais e interações de usuário com o Compose Testing.

## Contribuição

Se você deseja contribuir para o projeto CAED Mobile, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie um branch para suas alterações:

```bash
git checkout -b feature/nova-funcionalidade

// o chatgpt contribuiu, só falta você.  
```

## Mock API

O projeto utiliza a **Mock API** fornecida pelo [Mockfly](https://mockfly.dev) para simulação de dados durante o desenvolvimento e testes. Essa API permite criar e gerenciar dados de forma segura e eficiente, facilitando a implementação e execução de funcionalidades sem necessidade de um servidor real.

### URL Base

A URL base da API é:

https://api.mockfly.dev/mocks/49c3ea82-718e-4a12-93f9-167b91afe63e

```
/login

{
"isLogged": true
}
```

```
/packages

{
  "packageGroup": {
    "code": "160500003517-85",
    "deliveryPoint": "1ª REGIAO",
    "city": "ARACAJU",
    "state": "SE",
    "status": [
      {
        "data": "24/08/23",
        "hour": "14:32",
        "description": "Coordenador recebeu a caixa da transportadora"
      },
      {
        "data": "31/08/23",
        "hour": "18:19",
        "description": "Coordenador abriu a caixa para leitura dos pacotes"
      }
    ]
  },
  "packages": [
    {
      "code": "160500003517-85",
      "deliveryPoint": "2ª REGIAO",
      "city": "JOÃO PESSOA",
      "state": "PB",
      "status": [
        {
          "data": "24/08/23",
          "hour": "14:32",
          "description": "Coordenador recebeu a caixa da transportadora"
        },
        {
          "data": "31/08/23",
          "hour": "18:19",
          "description": "Coordenador abriu a caixa para leitura dos pacotes"
        }
      ]
    },
    {
      "code": "160500003517-86",
      "deliveryPoint": "3ª REGIAO",
      "city": "RECIFE",
      "state": "PE",
      "status": [
        {
          "data": "24/08/23",
          "hour": "14:32",
          "description": "Coordenador recebeu a caixa da transportadora"
        },
        {
          "data": "31/08/23",
          "hour": "18:19",
          "description": "Coordenador abriu a caixa para leitura dos pacotes"
        }
      ]
    },
    {
      "code": "160500003517-87",
      "deliveryPoint": "4ª REGIAO",
      "city": "MACEIÓ",
      "state": "AL",
      "status": [
        {
          "data": "24/08/23",
          "hour": "14:32",
          "description": "Coordenador recebeu a caixa da transportadora"
        },
        {
          "data": "31/08/23",
          "hour": "18:19",
          "description": "Coordenador abriu a caixa para leitura dos pacotes"
        }
      ]
    }
  ],
  "resumePackages": [
    {
      "label": "Pacotes A",
      "value1": 1560,
      "labelValue1": "Recebidos",
      "value2": 440,
      "labelValue2": "Faltantes"
    },
    {
      "label": "Pacotes B",
      "value1": 1200,
      "labelValue1": "Recebidos",
      "value2": 800,
      "labelValue2": "Faltantes"
    },
    {
      "label": "Pacotes C",
      "value1": 1800,
      "labelValue1": "Recebidos",
      "value2": 200,
      "labelValue2": "Faltantes"
    }
  ],
  "status": [
    {
      "data": "24/08/23",
      "hour": "14:32",
      "description": "Coordenador recebeu a caixa da transportadora"
    },
    {
      "data": "31/08/23",
      "hour": "18:19",
      "description": "Coordenador abriu a caixa para leitura dos pacotes"
    }
  ]
}

```