package com.itbenevides.core.domain.usecase

import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.data.repository.PackagesRepository
import com.itbenevides.core.domain.usecase.di.PackagesUseCase
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PackagesUseCaseImp @Inject constructor(
    private val packagesRepository: PackagesRepository
) : PackagesUseCase {

    override suspend fun getPackages(): Result<Packages> {
        return try {
            val response = packagesRepository.getPackages()
            Result.success(response)
        } catch (e: Throwable) {
            val errorMessage = when (e) {
                is HttpException -> "Erro de servidor. Tente novamente."
                is IOException -> "Erro de conexão. Verifique sua internet."
                else -> "Erro desconhecido. Tente novamente."
            }
            return Result.failure(Exception(errorMessage))
        }
    }
}
