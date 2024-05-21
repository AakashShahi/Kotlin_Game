package com.example.projrct

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projrct.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    lateinit var gameBinding:ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameBinding=ActivityGameBinding.inflate(layoutInflater)
        setContentView(gameBinding.root)

        gameBinding.addbtn.setOnClickListener{
            var intent= Intent(this@GameActivity,AddActivity::class.java)
            startActivity(intent)
        }

        gameBinding.subbtn.setOnClickListener{
            var intent= Intent(this@GameActivity,SubActivity::class.java)
            startActivity(intent)
        }

        gameBinding.mulbtn.setOnClickListener {
            var intent= Intent(this@GameActivity,MulActivity::class.java)
            startActivity(intent)
        }
    }
}