package com.loodos.domain.login

import com.loodos.data.model.login.LoginResponse


data class LoginResult(
    val token: String = "",
)

fun LoginResponse.toModel(): LoginResult {
    return LoginResult(this.token)
}
