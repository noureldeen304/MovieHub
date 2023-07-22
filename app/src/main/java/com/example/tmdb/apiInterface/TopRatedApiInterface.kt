package com.example.tmdb.apiInterface

import com.example.tmdb.gsonClasses.TopRatedGsonClass
import retrofit2.Call
import retrofit2.http.GET

interface TopRatedApiInterface {
    @GET("3/movie/top_rated?api_key=c807b8d4a0e4ac5de2695068cdcbfbf8")
    fun getJson():Call<TopRatedGsonClass>
}