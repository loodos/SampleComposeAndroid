package com.loodos.samplecomposeandroid.core.data.remote.api

import com.loodos.samplecomposeandroid.core.data.model.login.LoginBody
import com.loodos.samplecomposeandroid.core.data.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by mertcantoptas on 13.04.2023
 */

interface AuthenticationService {
    @POST("login")
    suspend fun login(
        @Body requestBody: LoginBody
    ): LoginResponse
}