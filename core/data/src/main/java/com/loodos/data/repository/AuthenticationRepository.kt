package com.loodos.data.repository

import com.loodos.data.model.login.LoginResponse

/**
 * Created by mertcantoptas on 13.04.2023
 */
interface AuthenticationRepository {
    suspend fun login(username: String, password: String): Result<LoginResponse>
}
