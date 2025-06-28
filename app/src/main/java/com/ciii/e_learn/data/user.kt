package com.ciii.e_learn.data

import retrofit2.http.GET

//data class user(
//    val id: Int,
//    val username: String,
//    val PASSWORD: String,
//    val email: String,
//    val phone: String,
//    val verified: Int,
//    val created_at: String
//)

data class UserResponse(
    val id: Int,
    val username: String,
    val email: String,
    val phone: String,
    val verified: Int,
    val otp_method: String,
    val created_at: String
)


