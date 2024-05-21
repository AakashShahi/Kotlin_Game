package com.example.projrct

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.projrct.databinding.ActivityDashBinding
import com.example.projrct.fragments.HomeFragment
import com.example.projrct.fragments.ListFragment
import com.example.projrct.fragments.ProfileFragment
import com.example.projrct.fragments.SearchFragment

class DashActivity : AppCompatActivity() {
    lateinit var dashBinding:ActivityDashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dashBinding=ActivityDashBinding.inflate(layoutInflater)
        setContentView(dashBinding.root)

        dashBinding.navMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->replaceFragment(HomeFragment())
                R.id.search->replaceFragment(SearchFragment())
                R.id.list->replaceFragment(ListFragment())
                R.id.profile->replaceFragment(ProfileFragment())
                else->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager =supportFragmentManager
        val fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}