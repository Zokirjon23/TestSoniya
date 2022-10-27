package com.example.testsoniya.data.source.remote

import retrofit2.http.GET
import com.example.testsoniya.data.model.Character
import retrofit2.Response
import retrofit2.http.Query

interface Api {

    @GET("character")
    suspend fun allArtist(@Query("page") page: Int) : Response<Character>

    @GET("character")
    suspend fun searchCharacter(@Query("page") page: Int,@Query("name") name: String): Response<Character>
}