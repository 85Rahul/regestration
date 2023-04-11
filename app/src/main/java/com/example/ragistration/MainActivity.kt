package com.example.ragistration

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistration.Factory.SqliteDbFactory
import com.example.ragistration.Repository1.SqliteDbReposotory
import com.example.ragistration.ViewModel.SqliteDbViewModel
import com.example.ragistration.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel:SqliteDbViewModel
    private lateinit var factory:SqliteDbFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        factory = SqliteDbFactory(SqliteDbReposotory(this))
        viewmodel = ViewModelProvider(this, factory)[SqliteDbViewModel::class.java]

        binding.submit.setOnClickListener {
            viewmodel.createData(binding.editFname.


            )
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_logout -> {

            }
            R.id.user_information -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }


        }

