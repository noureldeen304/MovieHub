package com.example.tmdb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.tmdb.databinding.ActivityLoginBinding
import javax.security.auth.callback.PasswordCallback



class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var email:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginInLogin.setOnClickListener {
            email = binding.emailLogin.text.toString()


            password = binding.passwordLogin.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                if (email.isEmpty())
                    binding.emailLogin.error = "Email address is required"
                if (password.isEmpty())
                    binding.passwordLogin.error = "Password is required"
            }
            else{
                val expectedEmailAndName = sharedPreferencesForEmailsAndNames.getString(password, "no email or name")!!.split(" ", limit = 2)
                if(email == expectedEmailAndName[0]) {
                    navigateFromLoginToAccount(expectedEmailAndName[1])
                }
                else
                    Toast.makeText(this, "Email or password is wrong", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun navigateFromLoginToAccount(name: String){
        val intent = Intent(this, AccountActivity::class.java)
        intent.putExtra(INTENT_KEY, name)
        startActivity(intent)
    }
}