package com.e.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value="character")
    suspend fun getListOfCharacters():Response<ApiResponse>
}