package com.itbenevides.core.domain.usecase.di

import com.itbenevides.core.domain.usecase.PackagesUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PackageUseCaseModule {
    @Binds
    fun bindLoginUseCase(packageUseCase: PackagesUseCaseImp): PackagesUseCase
}