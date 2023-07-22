package com.example.tmdb.retrofit

import com.example.tmdb.apiInterface.PopularApiInterface
import com.example.tmdb.apiInterface.TopRatedApiInterface
import com.example.tmdb.apiInterface.UpComingApiInterface
import com.example.tmdb.gsonClasses.PopularGsonClass
import com.example.tmdb.gsonClasses.TopRatedGsonClass
import com.example.tmdb.gsonClasses.UpComingGsonClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass(baseUrl: String) {
    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl) // the root link for the website
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getTopRatedCall(): Call<TopRatedGsonClass> {
        val apiInterface = retrofit.create(TopRatedApiInterface::class.java)
        return apiInterface.getJson()
    }

    fun getPopularCall(): Call<PopularGsonClass> {
        val apiInterface = retrofit.create(PopularApiInterface::class.java)
        return apiInterface.getJson()
    }

    fun getUpComingCall(): Call<UpComingGsonClass> {
        val apiInterface = retrofit.create(UpComingApiInterface::class.java)
        return apiInterface.getJson()
    }

}