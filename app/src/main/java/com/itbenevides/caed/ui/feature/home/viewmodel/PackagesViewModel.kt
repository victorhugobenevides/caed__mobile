package com.itbenevides.caed.ui.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbenevides.caed.ui.feature.home.state.PackagesState
import com.itbenevides.core.domain.usecase.di.PackagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PackagesViewModel @Inject constructor(
    private val packagesUseCase: PackagesUseCase
) : ViewModel() {

    private val _packagesState = MutableStateFlow<PackagesState>(PackagesState.Idle)
    val packagesState: StateFlow<PackagesState> = _packagesState.asStateFlow()

    init {
        getPackages()
    }

    private fun getPackages() {
        _packagesState.value = PackagesState.Loading

        viewModelScope.launch {
            val result = packagesUseCase.getPackages()

            result.fold(onSuccess = { packages ->
                _packagesState.value = PackagesState.Success(packages)
            }, onFailure = { error ->
                _packagesState.value = PackagesState.Error(error.message ?: "Erro desconhecido.")
            })
        }
    }
}
