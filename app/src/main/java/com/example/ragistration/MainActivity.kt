package com.example.ragistration

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistration.Factory.SqliteDbFactory
import com.example.ragistration.Repository1.SqliteDbReposotory
import com.example.ragistration.ViewModel.SqliteDbViewModel
import com.example.ragistration.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    View.OnContextClickListener, CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel:SqliteDbViewModel
    private lateinit var factory:SqliteDbFactory
    var gender:String?= null
    var arraylist:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        factory = SqliteDbFactory(SqliteDbReposotory(this))
        viewmodel = ViewModelProvider(this, factory)[SqliteDbViewModel::class.java]

      binding.rdGroup.setOnCheckedChangeListener(this)
      binding.BCA.setOnCheckedChangeListener(this)
      binding.BTech.setOnCheckedChangeListener(this)
      binding.MCA.setOnCheckedChangeListener(this)
      binding.MTech.setOnCheckedChangeListener(this)
      binding.Diploma.setOnCheckedChangeListener(this)

      binding.submit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submit -> {
                if (binding.editFname.text.isEmpty() && binding.editLname.text.isEmpty() && binding.editMobile.text.isEmpty() && binding.editAlternative.text.isEmpty() && binding.editEmail.text.isEmpty() && binding.editDob.text.isEmpty()) {
                    Toast.makeText(this, "please fill all record", Toast.LENGTH_SHORT).show()
                } else if (binding.editFname.text.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_LONG).show()
                    binding.editFname.requestFocus()
                } else if (binding.editLname.text.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_LONG).show()
                    binding.editFname.requestFocus()
                } else if (binding.editMobile.text.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_LONG).show()
                    binding.editFname.requestFocus()
                } else if (binding.editAlternative.text.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_LONG).show()
                    binding.editFname.requestFocus()
                } else if (binding.editEmail.text.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_LONG).show()
                    binding.editFname.requestFocus()
                } else if (binding.editDob.text.isEmpty()) {
                    Toast.makeText(this, "Please enter Firstname", Toast.LENGTH_LONG).show()
                    binding.editFname.requestFocus()
                } else {
                    val listname=arraylist.toString().replace("["," ").replace("]"," ")
                    viewmodel.createData(binding.editFname.text.toString(),binding.editLname.text.toString(),binding.editMobile.text.toString(),
                    binding.editEmail.text.toString(),binding.editDob.text.toString(),gender!!,listname)
                }
            }
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

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        TODO("Not yet implemented")
        when(group?.checkedRadioButtonId){
            R.id.rb_malename ->{
                gender = binding.rbMalename.text.toString()
            }
            R.id.rb_femalename ->{
                gender=binding.rbFemalename.text.toString()
            }

        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        TODO("Not yet implemented")
        when (buttonView?.id) {
            R.id.BCA -> {
                if (binding.BCA.isChecked) {
                    arraylist.add(binding.BCA.text.toString())

                } else {
                    arraylist.remove(binding.BCA.text.toString())
                }

            }
            R.id.BTech -> {
                if (binding.BTech.isChecked) {
                    arraylist.add(binding.BTech.text.toString())

                } else {
                    arraylist.remove(binding.BTech.text.toString())
                }

            }
            R.id.MCA -> {
                if (binding.MCA.isChecked) {
                    arraylist.add(binding.MCA.text.toString())

                } else {
                    arraylist.remove(binding.MCA.text.toString())
                }
            }
            R.id.MTech -> {
                if (binding.MTech.isChecked) {
                    arraylist.add(binding.MTech.text.toString())

                } else {
                    arraylist.remove(binding.MTech.text.toString())
                }
            }
            R.id.Diploma -> {
                if (binding.Diploma.isChecked) {
                    arraylist.add(binding.Diploma.text.toString())

                } else {
                    arraylist.remove(binding.Diploma.text.toString())
                }

            }
        }
    }

    override fun onContextClick(v: View?): Boolean {
        TODO("Not yet implemented")
    }


}

