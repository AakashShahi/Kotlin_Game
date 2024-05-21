package com.example.projrct

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.projrct.databinding.ActivityMain3Binding
import com.example.projrct.fragments.ProfileFragment

class MainActivity3 : AppCompatActivity() {
    lateinit var main3Binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        main3Binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(main3Binding.root)

        val fragmentManager: FragmentManager=supportFragmentManager
        val fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
        val profFragment=ProfileFragment()

        main3Binding.button.setOnClickListener {
            var email: String = main3Binding.emailField.text.toString()
            var pass: String = main3Binding.passField.text.toString()

            var bundle=Bundle()
            bundle.putString("email",email)
            bundle.putString("pass",pass)

            profFragment.arguments=bundle

            fragmentTransaction.replace(R.id.frameLayout,profFragment)
            fragmentTransaction.commit()


        }
    }
}