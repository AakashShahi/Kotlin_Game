package com.example.projrct

import android.R
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.projrct.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var data = arrayOf("Male", "Female")
    lateinit var signUpBinding: ActivitySignUpBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)

        var adapter = ArrayAdapter(this@SignUpActivity, R.layout.simple_spinner_dropdown_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        signUpBinding.gender.adapter = adapter
        signUpBinding.gender.onItemSelectedListener=this

        signUpBinding.signupBtn.setOnClickListener {
            sharedPreferences=getSharedPreferences("SignUp", MODE_PRIVATE)
            var editor=sharedPreferences.edit()
            editor.putString("name",signUpBinding.entryName.text.toString())
            editor.putString("email",signUpBinding.entryFieldEmail.text.toString())
            editor.putString("password",signUpBinding.entryPassword.text.toString())
            var getPass=signUpBinding.entryPassword.text.toString()
            if (signUpBinding.confirmPass.text.toString().equals(getPass)){
                editor.putString("confirmPass",signUpBinding.confirmPass.text.toString())
            }
            else{
                signUpBinding.confirmPass.error="Password not match"
            }
            editor.putString("gender",signUpBinding.gender.selectedItem.toString())
            if (signUpBinding.checkbox.isChecked){
                var intent= Intent(this@SignUpActivity,LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@SignUpActivity,"SignUp Successfully", Toast.LENGTH_SHORT).show()
                finish()

            }
            else{
                signUpBinding.checkbox.error="Please accept the terms and conditions"
            }
            editor.apply()
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            val selectedItem = parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}