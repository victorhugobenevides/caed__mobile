package com.itbenevides.core.data.di

import com.itbenevides.core.data.repository.PackagesRepository
import com.itbenevides.core.domain.repository.PackagesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PackageRepositoryModule {
    @Binds
    fun bindLoginRepository(repository: PackagesRepositoryImpl): PackagesRepository
}