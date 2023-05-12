package com.loodos.samplecomposeandroid.core.domain.login

import com.loodos.samplecomposeandroid.core.common.Resource
import com.loodos.samplecomposeandroid.core.common.asResource
import com.loodos.samplecomposeandroid.core.domain.PasswordLengthException
import com.loodos.samplecomposeandroid.core.domain.PasswordRequiredException
import com.loodos.samplecomposeandroid.core.domain.UsernameLengthException
import com.loodos.samplecomposeandroid.core.domain.UsernameRequiredException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by mertcantoptas on 12.05.2023
 */

class ValidateAuthUseCase @Inject constructor() {
    operator fun invoke(username: String, password: String): Flow<Resource<Unit>> {
        return flow {
            if (username.isEmpty()) {
                throw UsernameRequiredException()
            }
            if (username.length < 6) {
                throw UsernameLengthException()
            }
            if (password.isEmpty()) {
                throw PasswordRequiredException()
            }
            if (password.length < 6) {
                throw PasswordLengthException()
            }
            emit(Unit)
        }.asResource()
    }
}
