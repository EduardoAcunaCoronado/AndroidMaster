package com.example.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/5f149ed1513a4c71db1177b0f9721572/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName : String) : Response<SuperheroDataResponse>

    @GET("/api/5f149ed1513a4c71db1177b0f9721572/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String) : Response<SuperheroDetailResponse>
}