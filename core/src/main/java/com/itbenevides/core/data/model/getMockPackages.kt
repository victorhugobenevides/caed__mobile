package com.itbenevides.core.data.model

fun getMockPackages(): Packages {
    val statusList = listOf(
        Status(
            data = "24/08/23",
            hour = "14:32",
            description = "Coordenador recebeu a caixa da transportadora"
        ),
        Status(
            data = "31/08/23",
            hour = "18:19",
            description = "Coordenador abriu a caixa para leitura dos pacotes"
        ),
        Status(
            data = "31/08/23",
            hour = "18:19",
            description = "Coordenador abriu a caixa para leitura dos pacotes"
        ),
        Status(
            data = "31/08/23",
            hour = "18:19",
            description = "Coordenador abriu a caixa para leitura dos pacotes"
        ),
        Status(
            data = "31/08/23",
            hour = "18:19",
            description = "Coordenador abriu a caixa para leitura dos pacotes"
        ),

    )

    val packageGroup = Package(
        code = "160500003517-85",
        deliveryPoint = "1ª REGIAO",
        city = "ARACAJU",
        state = "SE",
        status = statusList
    )

    val packageList = listOf(
        Package(
            code = "160500003517-85",
            deliveryPoint = "2ª REGIAO",
            city = "JOÃO PESSOA",
            state = "PB",
            status = statusList
        ),
        Package(
            code = "160500003517-86",
            deliveryPoint = "3ª REGIAO",
            city = "RECIFE",
            state = "PE",
            status = statusList
        ),
        Package(
            code = "160500003517-87",
            deliveryPoint = "4ª REGIAO",
            city = "MACEIÓ",
            state = "AL",
            status = statusList
        ),
        Package(
            code = "160500003517-87",
            deliveryPoint = "4ª REGIAO",
            city = "MACEIÓ",
            state = "AL",
            status = statusList
        ),
        Package(
            code = "160500003517-87",
            deliveryPoint = "4ª REGIAO",
            city = "MACEIÓ",
            state = "AL",
            status = statusList
        ),
        Package(
            code = "160500003517-87",
            deliveryPoint = "4ª REGIAO",
            city = "MACEIÓ",
            state = "AL",
            status = statusList
        )

    )

    val resumePackagesList = listOf(
        ResumePackages(
            label = "Pacotes A",
            value1 = 1560,
            labelValue1 = "Recebidos",
            value2 = 440,
            labelValue2 = "Faltantes",
        ),
        ResumePackages(
            label = "Pacotes B",
            value1 = 1200,
            labelValue1 = "Recebidos",
            value2 = 800,
            labelValue2 = "Faltantes",
        ),
        ResumePackages(
            label = "Pacotes C",
            value1 = 1800,
            labelValue1 = "Recebidos",
            value2 = 200,
            labelValue2 = "Faltantes",
        )
    )

    return Packages(
        packageGroup = packageGroup,
        packages = packageList,
        resumePackages = resumePackagesList,
        status = statusList
    )
}
