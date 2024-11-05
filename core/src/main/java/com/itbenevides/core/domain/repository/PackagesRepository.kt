package com.itbenevides.core.domain.repository

import com.itbenevides.core.data.model.Packages


interface PackagesRepository {
    suspend fun getPackages(): Packages
}