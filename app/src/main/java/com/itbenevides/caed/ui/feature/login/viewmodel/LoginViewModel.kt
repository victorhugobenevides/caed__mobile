package com.itbenevides.caed.ui.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itbenevides.caed.ui.feature.login.state.LoginState
import com.itbenevides.core.data.model.User
import com.itbenevides.core.domain.usecase.di.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun login(name: String, password: String) {
        val user = User(name, password)
        _loginState.value = LoginState.Loading
        viewModelScope.launch {
            val result = loginUseCase.login(user)
            result.fold(onSuccess = {
                _loginState.value = LoginState.Success
            }, onFailure = {
                _loginState.value =
                    LoginState.Error(result.exceptionOrNull()?.message ?: "Erro desconhecido.")
            })
        }

    }
}
