package com.example.projrct

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projrct.databinding.ActivityMulBinding

class MulActivity : AppCompatActivity() {
    lateinit var mulBinding: ActivityMulBinding
    var lifeno: Int = 3
    var scoreno: Int = 0
    var number1: Int = 0
    var number2: Int = 0
    var mul: Int=0
    private var timer: CountDownTimer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mulBinding=ActivityMulBinding.inflate(layoutInflater)
        setContentView(mulBinding.root)


        resetGame()
        timer=object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                mulBinding.time2.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                lifeno--
                mulBinding.life2.text=lifeno.toString()
                if(lifeno>0){
                    resetRound()
                }
                else{
                    Toast.makeText(this@MulActivity,"Game Over", Toast.LENGTH_LONG).show()
                }
            }
        }

        timer?.start()

        mulBinding.check2.setOnClickListener{
            val givenAns: Int = mulBinding.entryno11.text.toString().toInt()
            if(givenAns==mul){
                scoreno=scoreno+10
                mulBinding.score2.text=scoreno.toString()
                resetRound()
            }
            else{
                lifeno--
                mulBinding.life2.text=lifeno.toString()
                if(lifeno<=0){
                    Toast.makeText(this@MulActivity,"Game Over", Toast.LENGTH_LONG).show()
                }
                else{
                    resetRound()
                }
            }
        }

        mulBinding.next2.setOnClickListener{
            if(lifeno>0){
                resetRound()
            }
            else{
                Toast.makeText(this@MulActivity,"Game Over", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun resetGame(){
        lifeno=3
        scoreno=0
        mulBinding.life2.text=lifeno.toString()
        mulBinding.score2.text=scoreno.toString()
        resetRound()
    }

    fun resetRound(){
        number1=(0..100).random()
        number2=(0..100).random()
        mul=number1*number2
        mulBinding.operand111.text=number1.toString()
        mulBinding.operand222.text=number2.toString()
        mulBinding.entryno11.text.clear()
        timer?.start()
    }


    }
