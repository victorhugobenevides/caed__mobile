package com.itbenevides.core.domain.usecase.di

import com.itbenevides.core.domain.usecase.LoginUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginUseCaseModule {
    @Binds
    fun bindLoginUseCase(repository: LoginUseCaseImp): LoginUseCase
}