package com.example.ragistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


        binding.btnRagister.setOnClickListener {
            if(binding.editFname.text.toString().isEmpty()&&binding.editLname.text.toString().isEmpty()&&binding.editMobno.text.toString().isEmpty())
            {
                Toast.makeText(this, "please fill value", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "ragistration succesfully", Toast.LENGTH_SHORT).show()
                viewmodel.savedata(binding.editFname.text.toString(),binding.editLname.text.toString(),binding.editMobno.text.toString())
                startActivity(Intent(this,MainActivity::class.java))
            }
        }

        binding.btnLoginHere.setOnClickListener {
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }

    }
}