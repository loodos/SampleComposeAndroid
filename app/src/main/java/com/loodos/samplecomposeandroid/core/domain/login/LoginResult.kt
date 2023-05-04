package com.loodos.samplecomposeandroid.core.domain.login

import com.loodos.samplecomposeandroid.core.data.model.login.LoginResponse

data class LoginResult(
    val token: String = "",
)

fun LoginResponse.toModel() : LoginResult {
    return LoginResult(this.token)
}
