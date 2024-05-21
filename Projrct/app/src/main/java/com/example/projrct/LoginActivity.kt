package com.example.projrct

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projrct.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.signUpText.setOnClickListener {
            intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBinding.loginBtn.setOnClickListener {
            sharedPreferences = getSharedPreferences("SignUp", MODE_PRIVATE)
            var email = sharedPreferences.getString("email", "")
            var pass = sharedPreferences.getString("password", "")

            if (email == loginBinding.entryEmail.text.toString() && pass == loginBinding.entryPass.text.toString()) {
                intent = Intent(this@LoginActivity, DashActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onPause() {
        if (loginBinding.checkBox.isChecked) {
            sharedPreferences.edit().putString("email", loginBinding.entryEmail.text.toString())
                .apply()
            sharedPreferences.edit().putString("password", loginBinding.entryPass.text.toString())
                .apply()
            Toast.makeText(this@LoginActivity, "Saved", Toast.LENGTH_SHORT).show()
            super.onPause()
        }
        else{
            Toast.makeText(this@LoginActivity, "Not Saved", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        loginBinding.entryEmail.setText(sharedPreferences.getString("email", ""))
        loginBinding.entryPass.setText(sharedPreferences.getString("password", ""))
        Toast.makeText(this@LoginActivity, "Resumed", Toast.LENGTH_SHORT).show()
    }
}