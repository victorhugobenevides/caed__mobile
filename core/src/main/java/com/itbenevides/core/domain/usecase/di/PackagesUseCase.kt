package com.itbenevides.core.domain.usecase.di

import com.itbenevides.core.data.model.Packages

interface PackagesUseCase {
    suspend fun getPackages(): Result<Packages>
}

