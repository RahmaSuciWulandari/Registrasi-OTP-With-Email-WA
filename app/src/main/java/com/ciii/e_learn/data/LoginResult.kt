package com.ciii.e_learn.data

data class LoginResponse(
    val status: String,
    val message: String,
    //val role: String? = null,
    val user_id: Int? = null
)