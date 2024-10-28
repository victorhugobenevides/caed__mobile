package com.itbenevides.caed.ui.feature.home.state

import com.itbenevides.core.data.model.Packages

sealed class PackagesState {
    object Idle : PackagesState()
    object Loading : PackagesState()
    data class Success(val packages: Packages) : PackagesState()
    data class Error(val message: String) : PackagesState()
}