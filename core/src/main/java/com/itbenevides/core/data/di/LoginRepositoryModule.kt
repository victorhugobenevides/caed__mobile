package com.itbenevides.core.data.di

import com.itbenevides.core.data.repository.LoginRepository
import com.itbenevides.core.domain.repository.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginRepositoryModule {
    @Binds
    fun bindLoginRepository(repository: LoginRepositoryImpl): LoginRepository
}