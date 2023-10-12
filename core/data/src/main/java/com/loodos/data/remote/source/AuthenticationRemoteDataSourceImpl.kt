package com.loodos.data.remote.source

import com.loodos.data.model.login.LoginBody
import com.loodos.data.model.login.LoginResponse
import com.loodos.data.remote.api.AuthenticationService
import javax.inject.Inject

class AuthenticationRemoteDataSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService,
) : AuthenticationRemoteDataSource {

    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        return runCatching {
            authenticationService.login(LoginBody(username, password))
        }
    }
}
