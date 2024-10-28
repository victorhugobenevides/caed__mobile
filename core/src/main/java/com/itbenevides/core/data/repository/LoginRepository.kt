package com.itbenevides.core.data.repository

import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User


interface LoginRepository {
    suspend fun login(user : User): ResponseLogin
}