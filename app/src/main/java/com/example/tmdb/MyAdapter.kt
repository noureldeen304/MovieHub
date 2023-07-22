package com.example.tmdb//package com.example.androidtutorial
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.databinding.CustomItemBinding
import com.example.tmdb.gsonClasses.TopRatedGsonClass
import com.squareup.picasso.Picasso
import retrofit2.Callback
import java.lang.Exception
import java.security.AccessControlContext

class MyAdapter(var listOfMovieDataClass: ArrayList<MovieDataClass>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item, null,
            false)
        val binding_for_view = CustomItemBinding.bind(view)
        return MyHolder(view, binding_for_view)
    }

    override fun onBindViewHolder(MyHolder_: MyHolder, position: Int) {
        val movieDataClass = listOfMovieDataClass[position]
        MyHolder_.binding.textView.text = movieDataClass.title
        Picasso.with(context)
            .load("http://image.tmdb.org/t/p/w500" + movieDataClass.poster_path)
            .into(MyHolder_.binding.imageView)
    }

    override fun getItemCount(): Int {
        return listOfMovieDataClass.size
    }

    inner class MyHolder(view: View, binding_for_itemView: CustomItemBinding) :
        RecyclerView.ViewHolder(view) {
        val binding = binding_for_itemView
        }
    }