package com.example.ragistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistration.Factory.SinUpFactory
import com.example.ragistration.ViewModel.SinUpViewModel
import com.example.ragistration.databinding.ActivityLoginBinding
import com.example.ragistration.repository.SinUpRepository

class Login_Activity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    lateinit var factory:SinUpFactory
    lateinit var view:SinUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        factory=SinUpFactory(SinUpRepository,this)
        view= ViewModelProvider(this,factory)[SinUpViewModel::class.java]


       binding.sinup.setOnClickListener {
            val intent = Intent(this, SinUp_Activity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            //var mobile= binding.editMobnoLogin.text.toString()

//            if(binding.editMobnoLogin.text.toString().isEmpty()){
//                Toast.makeText(this, "please enter mobile number", Toast.LENGTH_SHORT).show()
           if ( binding.editMobnoLogin.text.toString().equals(view.getdata())){
            startActivity(Intent(this, MainActivity::class.java))

            }
             else if(binding.editMobnoLogin.text.toString().isEmpty()){
               Toast.makeText(this, "please enter mobile number", Toast.LENGTH_SHORT).show()

           }

            else{
            Toast.makeText(this, "Please enter correct mobile number", Toast.LENGTH_SHORT).show()

            }
        }

    }
}