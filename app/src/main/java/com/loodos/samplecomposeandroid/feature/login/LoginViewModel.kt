package com.loodos.samplecomposeandroid.feature.login

import androidx.lifecycle.viewModelScope
import com.PasswordLengthException
import com.PasswordRequiredException
import com.UsernameLengthException
import com.UsernameRequiredException
import com.login.LoginUseCase
import com.login.ValidateAuthUseCase
import com.loodos.common.result.Resource
import com.loodos.common.result.asResource
import com.loodos.samplecomposeandroid.R
import com.loodos.samplecomposeandroid.arch.BaseViewModel
import com.loodos.samplecomposeandroid.arch.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: com.login.LoginUseCase,
    private val validateAuthUseCase: com.login.ValidateAuthUseCase,
) : BaseViewModel<LoginViewState>() {

    override fun createInitialState(): LoginViewState = LoginViewState()

    fun onLoginClick() {
        viewModelScope.launch {
            validateAuthUseCase.invoke(currentState.userName, currentState.password).onEach { result ->
                when (result) {
                    Resource.Loading -> {
                        setState { copy(loading = true) }
                    }

                    is Resource.Error -> {
                        setState { copy(loading = false) }
                        updateUIErrorState(result.exception)
                    }

                    is Resource.Success -> {
                        setState { copy(loading = false) }
                        onLogin(currentState.userName, currentState.password)
                    }
                }
            }
                .launchIn(this)
        }
    }

    private fun onLogin(username: String, password: String) {
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
                            setState {
                                copy(
                                    loading = false,
                                    navigateToHomeWithContent = triggered(true),
                                    navigateToHome = triggered,
                                )
                            }
                        }
                    }
                }
                .launchIn(this)
        }
    }

    fun onUserNameChange(userName: String) {
        setState { copy(userName = userName, usernameErrorMessage = null) }
    }

    fun onPasswordChange(password: String) {
        setState { copy(password = password, passwordErrorMessage = null) }
    }

    fun onConsumeSingleEvent() {
        setState { copy(navigateToHome = consumed) }
    }

    private fun updateUIErrorState(exception: Throwable?) {
        when (exception) {
            is com.PasswordLengthException -> {
                setState { copy(passwordErrorMessage = R.string.password_length_error) }
            }

            is com.PasswordRequiredException -> {
                setState { copy(passwordErrorMessage = R.string.password_blank_error) }
            }

            is com.UsernameLengthException -> {
                setState { copy(usernameErrorMessage = R.string.username_length_error) }
            }

            is com.UsernameRequiredException -> {
                setState { copy(usernameErrorMessage = R.string.username_blank_error) }
            }
        }
    }
}

data class LoginViewState(
    val loading: Boolean = false,
    val userName: String = "",
    val password: String = "",
    val passwordErrorMessage: Int? = null,
    val usernameErrorMessage: Int? = null,
    val navigateToHome: StateEvent = consumed,
    val navigateToHomeWithContent: StateEventWithContent<Boolean> = consumed(),
) : IViewState
