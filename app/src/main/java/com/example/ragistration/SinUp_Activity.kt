package com.example.ragistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistration.Factory.SinUpFactory
import com.example.ragistration.ViewModel.SinUpViewModel
import com.example.ragistration.databinding.ActivitySinUpBinding
import com.example.ragistration.repository.SinUpRepository

class SinUp_Activity : AppCompatActivity() {
     lateinit var binding: ActivitySinUpBinding
     lateinit var factory:SinUpFactory
     lateinit var viewmodel:SinUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_sin_up)
        factory= SinUpFactory(SinUpRepository,this)
        viewmodel=ViewModelProvider(this,factory)[SinUpViewModel::class.java]


        binding.btnSinup.setOnClickListener {
            viewmodel.savedata(binding.editMobno.text.toString().toInt())
        }

        binding.btnLoginHere.setOnClickListener {
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }

    }
}