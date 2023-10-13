package com.loodos.domain.login

import com.loodos.domain.PasswordLengthException
import com.loodos.domain.PasswordRequiredException
import com.loodos.domain.UsernameLengthException
import com.loodos.domain.UsernameRequiredException
import com.loodos.common.result.Resource
import com.loodos.common.result.asResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by mertcantoptas on 12.05.2023
 */

private const val MinUsernameLength = 6
private const val MinPasswordLength = 6

class ValidateAuthUseCase @Inject constructor() {
    operator fun invoke(username: String, password: String): Flow<Resource<Unit>> {
        return flow {
            if (username.isEmpty()) {
                throw UsernameRequiredException()
            }
            if (username.length < MinUsernameLength) {
                throw UsernameLengthException()
            }
            if (password.isEmpty()) {
                throw PasswordRequiredException()
            }
            if (password.length < MinPasswordLength) {
                throw PasswordLengthException()
            }
            emit(Unit)
        }.asResource()
    }
}
