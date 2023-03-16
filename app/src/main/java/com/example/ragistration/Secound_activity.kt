package com.example.ragistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ragistration.databinding.ActivityMainBinding
import com.example.ragistration.databinding.ActivitySecoundBinding

class Secound_activity : AppCompatActivity() {
    private lateinit var binding: ActivitySecoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)
        binding = ActivitySecoundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val name = intent.getStringExtra("fname")
        val lname = intent.getStringExtra("lastname")
        val Phone = intent.getStringExtra("Phone")
        val alternative = intent.getStringExtra("Al.number")
        val email = intent.getStringExtra("Email")
        val gender1=intent.getStringExtra("Gender")
        val hobbies=intent.getStringExtra("Hobbies")


        binding.edit.setText("name:-$name $lname \n phone:- $Phone\n alternative_phone:- $alternative\n email:- $email \n Gender:- $gender1 \n hobbies:- $hobbies  ")
    }

}