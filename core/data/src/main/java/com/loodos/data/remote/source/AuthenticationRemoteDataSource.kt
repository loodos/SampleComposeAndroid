package com.loodos.data.remote.source

import com.loodos.data.model.login.LoginResponse

/**
 * Created by mertcantoptas on 13.04.2023
 */
interface AuthenticationRemoteDataSource {
    suspend fun login(username: String, password: String): Result<LoginResponse>
}
