package com.loodos.samplecomposeandroid.feature.login

import androidx.lifecycle.viewModelScope
import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import com.loodos.samplecomposeandroid.core.common.Resource
import com.loodos.samplecomposeandroid.core.common.asResource
import com.loodos.samplecomposeandroid.core.domain.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginViewState>() {

    override fun createInitialState(): LoginViewState = LoginViewState()

    fun onLoginClick(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase(username, password)
                .asResource()
                .onEach { result ->
                    when (result) {
                        Resource.Loading -> {
                            setState { copy(loading = true) }
                        }

                        is Resource.Error -> {
                            setState { copy(loading = false) }
                        }

                        is Resource.Success -> {
                            setState { copy(loading = false) }
                        }
                    }
                }
                .launchIn(this)
        }
    }
}

data class LoginViewState(
    val loading: Boolean = false
) : IViewState