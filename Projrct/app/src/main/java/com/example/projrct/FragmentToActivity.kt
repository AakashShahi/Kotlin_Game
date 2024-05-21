package com.example.projrct

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.projrct.databinding.ActivityFragmentToBinding
import com.example.projrct.fragments.SearchFragment

class FragmentToActivity : AppCompatActivity() {
    lateinit var fragmentBinding: ActivityFragmentToBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentBinding=ActivityFragmentToBinding.inflate(layoutInflater)
        setContentView(fragmentBinding.root)


        supportFragmentManager.beginTransaction().replace(R.id.frameLayout5,SearchFragment())
            .commit()

    }

    fun setData(name:String,pass:String){
        fragmentBinding.textView.text=name
        fragmentBinding.textView2.text=pass
    }
}


