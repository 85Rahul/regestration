package com.example.ragistration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.ragistration.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    var gender:String?= null
    var arraylist: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener(this)

        binding.rdGroup.setOnCheckedChangeListener(this)
        binding.cbCoding.setOnCheckedChangeListener(this)
        binding.cbGaming.setOnCheckedChangeListener(this)
        binding.cbReadingNobel.setOnCheckedChangeListener(this)
        binding.cbTavling.setOnCheckedChangeListener(this)


    }

    override fun onClick(pO: View) {
        var fname = binding.textFname.text.toString()
        var lname = binding.textLname.text.toString()
        var phone = binding.textPhone.text!!.toString()
        var alterphone = binding.textAlternative.text.toString()
        var email = binding.textEmail.text.toString()


        when (pO.id) {
            R.id.submit -> {
                var intent = Intent(this, Secound_activity::class.java)
                val listname=arraylist.toString().replace("["," ").replace("]"," ")
                intent.putExtra("fname", fname)
                intent.putExtra("lastname", lname)
                intent.putExtra("Phone", phone)
                intent.putExtra("Al.number", alterphone)
                intent.putExtra("Email", email)
                intent.putExtra("Gender", gender)
                intent.putExtra("gender", gender)

                intent.putExtra("Hobbies", listname)


                startActivity(intent)

            }
        }


    }

    override fun onCheckedChanged(chacked: RadioGroup?, p1: Int) {
        when (chacked?.checkedRadioButtonId) {
            R.id.rb_malename -> {
                gender = binding.rbMalename.text.toString()
            }
            R.id.rb_femalename -> {
                gender = binding.rbFemalename.text.toString()
            }

        }

    }

    override fun onCheckedChanged(view: CompoundButton?, ischecked: Boolean) {
        when (view?.id) {
            R.id.cbCoding -> {
                if (binding.cbCoding.isChecked) {
                    arraylist.add(binding.cbCoding.text.toString())

                } else {
                    arraylist.remove(binding.cbCoding.text.toString())
                }

            }
            R.id.cbGaming -> {
                if (binding.cbGaming.isChecked) {
                    arraylist.add(binding.cbGaming.text.toString())

                } else {
                    arraylist.remove(binding.cbGaming.text.toString())

                }

            }
            R.id.cbTavling -> {
                if (binding.cbTavling.isChecked) {
                    arraylist.add(binding.cbTavling.text.toString())

                } else {
                    arraylist.remove(binding.cbTavling.text.toString())

                }

            }
            R.id.cbReadingNobel -> {
                if (binding.cbReadingNobel.isChecked) {
                    arraylist.add(binding.cbReadingNobel.text.toString())

                } else {
                    arraylist.remove(binding.cbReadingNobel.text.toString())


                }

            }

        }
    }
}






