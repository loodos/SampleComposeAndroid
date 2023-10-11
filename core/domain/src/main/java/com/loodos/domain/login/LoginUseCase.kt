package com.loodos.domain.login

import com.loodos.data.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
) {
    operator fun invoke(username: String, password: String): Flow<LoginResult> {
        return flow {
            val result = authenticationRepository.login(username, password)
            (result.getOrNull() ?: throw IllegalArgumentException("error message")).also {
                emit(it.toModel())
            }
        }
    }
}
