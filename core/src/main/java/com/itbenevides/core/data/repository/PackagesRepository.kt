package com.itbenevides.core.data.repository

import com.itbenevides.core.data.model.Packages


interface PackagesRepository {
    suspend fun getPackages(): Packages
}