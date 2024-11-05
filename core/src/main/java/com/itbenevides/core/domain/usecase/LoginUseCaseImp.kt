package com.itbenevides.core.domain.usecase

import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User
import com.itbenevides.core.domain.repository.LoginRepository
import com.itbenevides.core.domain.usecase.di.LoginUseCase
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCaseImp @Inject constructor(private val loginRepository: LoginRepository) :
    LoginUseCase {
    override suspend fun login(user: User): Result<ResponseLogin> {
        try {
            val response = loginRepository.login(user = user)

            return Result.success(response)

        } catch (e: Throwable) {
            val errorMessage = when (e) {
                is HttpException -> if (e.code() == 401) {
                    "Login ou senha incorretos."
                } else {
                    "Erro de servidor. Tente novamente."
                }

                is IOException -> "Erro de conexão. Verifique sua internet."
                else -> "Erro desconhecido. Tente novamente."
            }
            return Result.failure(Exception(errorMessage))
        }
    }
}

