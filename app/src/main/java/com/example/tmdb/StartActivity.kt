package com.example.tmdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdb.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding:ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesForEmailsAndNames = getSharedPreferences(EMAIL_NAME_SP_KEY,MODE_PRIVATE)

        binding.signUpMain.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.logInMain.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}