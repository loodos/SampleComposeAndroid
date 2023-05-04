package com.loodos.samplecomposeandroid.core.data.remote.source

import com.loodos.samplecomposeandroid.core.data.model.login.LoginBody
import com.loodos.samplecomposeandroid.core.data.model.login.LoginResponse
import com.loodos.samplecomposeandroid.core.data.remote.api.AuthenticationService
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
