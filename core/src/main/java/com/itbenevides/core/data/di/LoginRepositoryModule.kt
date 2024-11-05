package com.itbenevides.core.data.di

import com.itbenevides.core.data.repository.LoginRepositoryImpl
import com.itbenevides.core.domain.repository.LoginRepository
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