package com.example.tmdb

import com.example.tmdb.retrofit.RetrofitClass
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.databinding.ActivityAccountBinding
import com.example.tmdb.gsonClasses.PopularGsonClass
import com.example.tmdb.gsonClasses.TopRatedGsonClass
import com.example.tmdb.gsonClasses.UpComingGsonClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AccountActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val name: String? = intent.getStringExtra(INTENT_KEY)
        Toast.makeText(this, "$name", Toast.LENGTH_SHORT).show()
        binding.navigationView.getHeaderView(0).findViewById<TextView>(R.id.textView2).text = name

        val retrofitClass = RetrofitClass("https://api.themoviedb.org/")

        val topRatedCallback = retrofitClass.getTopRatedCall()
        val topRatedListener = object :Callback<TopRatedGsonClass>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<TopRatedGsonClass>,
                response: Response<TopRatedGsonClass>
            ) {
                binding.recTopRated.setHasFixedSize(true)
                binding.recTopRated.layoutManager =
                    LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL,
                        false)

                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        val listOfMovieData = response.body()?.results!!
                        val adapter = MyAdapter(listOfMovieData, baseContext)
                        binding.recTopRated.adapter = adapter
                        adapter.notifyDataSetChanged()
                        binding.switcher1.displayedChild = 1
                    }else {
                        binding.switcher1.displayedChild = 0
                    }
                } else {
                    binding.switcher1.displayedChild = 0
                }
            }

            override fun onFailure(call: Call<TopRatedGsonClass>, t: Throwable) {
                println(t.message)
            }

        }
        topRatedCallback.enqueue(topRatedListener)


        val popularCallback = retrofitClass.getPopularCall()
        val popularCallbackListener = object :Callback<PopularGsonClass>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<PopularGsonClass>,
                response: Response<PopularGsonClass>
            ) {
                binding.recPopular.setHasFixedSize(true)
                binding.recPopular.layoutManager =  LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL,
                    false)

                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        val listOfMovieData = response.body()?.results!!
                        val adapter = MyAdapter(listOfMovieData, baseContext)
                        binding.recPopular.adapter = adapter
                        adapter.notifyDataSetChanged()
                        binding.switcher2.displayedChild = 1

                    } else {
                        binding.switcher2.displayedChild = 0
                    }
                } else {
                    binding.switcher2.displayedChild = 0
                }
            }

            override fun onFailure(call: Call<PopularGsonClass>, t: Throwable) {
                println(t.message)
            }

        }
        popularCallback.enqueue(popularCallbackListener)



        val upComingCallback = retrofitClass.getUpComingCall()
        val upComingCallbackListener = object :Callback<UpComingGsonClass>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<UpComingGsonClass>,
                response: Response<UpComingGsonClass>
            ) {
                binding.recUpcoming.setHasFixedSize(true)
                binding.recUpcoming.layoutManager =  LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL,
                    false)
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        val listOfMovieData = response.body()?.results!!
                        val adapter = MyAdapter(listOfMovieData, baseContext)
                        binding.recUpcoming.adapter = adapter
                        adapter.notifyDataSetChanged()
                        binding.switcher3.displayedChild = 1
                    } else {
                        binding.switcher3.displayedChild = 0
                    }
                } else {
                    binding.switcher3.displayedChild = 0
                }
            }

            override fun onFailure(call: Call<UpComingGsonClass>, t: Throwable) {
                println(t.message)
            }

        }
        upComingCallback.enqueue(upComingCallbackListener)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerlayout,R.string.open,R.string.close)
        binding.drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)



    }
}