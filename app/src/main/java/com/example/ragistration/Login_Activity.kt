package com.example.ragistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.ragistration.databinding.ActivityLoginBinding

class Login_Activity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.btnSinupLogin.setOnClickListener {
            val intent = Intent(this, SinUp_Activity::class.java)
            startActivity(intent)
        }


    }
}