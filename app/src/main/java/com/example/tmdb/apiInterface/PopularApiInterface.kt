package com.example.tmdb.apiInterface

import com.example.tmdb.gsonClasses.PopularGsonClass
import retrofit2.Call
import retrofit2.http.GET

interface PopularApiInterface {
    @GET("3/movie/popular?api_key=c807b8d4a0e4ac5de2695068cdcbfbf8")
    fun getJson(): Call<PopularGsonClass>
}