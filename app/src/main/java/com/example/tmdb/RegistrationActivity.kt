package com.example.tmdb

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.tmdb.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    lateinit var name:String
    lateinit var email:String
    lateinit var password:String

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createRegistration.setOnClickListener {
            name = binding.fullNameRegistration.text.toString()
            email = binding.emailRegistration.text.toString()
            password = binding.passwordRegistration.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty())
            {
                if (name.isEmpty())
                    binding.fullNameRegistration.error = "Full name is required"

                if (email.isEmpty())
                    binding.emailRegistration.error = "Email address is required"

                if (password.isEmpty())
                    binding.passwordRegistration.error = "Password is required"
            }
            else{
                editor = sharedPreferencesForEmailsAndNames.edit()
                editor.putString(password,"$email $name")
                editor.apply()
                Toast.makeText(this, "Name: $name \nEmail: $email", Toast.LENGTH_SHORT).show()
                navigateFromLoginToLogin()
            }
        }

    }

    private fun navigateFromLoginToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}