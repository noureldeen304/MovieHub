package com.example.tmdb.apiInterface

import com.example.tmdb.gsonClasses.UpComingGsonClass
import retrofit2.Call
import retrofit2.http.GET


interface UpComingApiInterface {
    @GET("3/movie/upcoming?api_key=c807b8d4a0e4ac5de2695068cdcbfbf8")
    fun getJson(): Call<UpComingGsonClass>
}