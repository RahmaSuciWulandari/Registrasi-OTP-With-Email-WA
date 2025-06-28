package com.ciii.e_learn.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

//interface ApiService {
//    @GET("user.php")
//    suspend fun getUser(): List<user>
//
//    @FormUrlEncoded
//    @POST("login.php")
//    suspend fun loginUser(
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): user
//}

interface ApiService {
    @POST("login.php")
    @Headers("Content-Type: application/json")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register.php")
    @Headers("Content-Type: application/json")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>

}

