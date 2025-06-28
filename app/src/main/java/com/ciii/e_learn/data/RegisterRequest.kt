package com.ciii.e_learn.data

data class RegisterRequest(
    val username: String,
    val password: String,
    val email: String,
    val phone: String,
    val otp_method: String
)
