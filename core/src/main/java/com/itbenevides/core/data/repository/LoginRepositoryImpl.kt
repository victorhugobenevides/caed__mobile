package com.itbenevides.core.data.repository


import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User
import com.itbenevides.core.data.remote.APIService
import com.itbenevides.core.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : LoginRepository {
    override suspend fun login(user: User): ResponseLogin {

        val response = apiService.login(user = user)

        return response

    }
}