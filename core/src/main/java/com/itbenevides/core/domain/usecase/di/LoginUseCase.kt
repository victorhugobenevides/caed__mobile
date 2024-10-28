package com.itbenevides.core.domain.usecase.di

import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User

interface LoginUseCase {
    suspend fun login(user: User): Result<ResponseLogin>
}

