package com.loodos.data.repository

import com.loodos.data.model.login.LoginResponse
import com.loodos.data.remote.source.AuthenticationRemoteDataSource
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource,
) : AuthenticationRepository {

    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        return authenticationRemoteDataSource.login(username, password)
    }
}
