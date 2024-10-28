package com.itbenevides.core.domain.repository


import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.data.remote.APIService
import com.itbenevides.core.data.repository.PackagesRepository
import javax.inject.Inject

class PackagesRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : PackagesRepository {
    override suspend fun getPackages(): Packages {
        val response = apiService.getPackages()
        return response
    }
}