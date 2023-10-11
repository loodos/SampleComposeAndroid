package com.loodos.data.model.login

import com.google.gson.annotations.SerializedName

/**
 * Created by mertcantoptas on 13.04.2023
 */
data class LoginBody(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
)
