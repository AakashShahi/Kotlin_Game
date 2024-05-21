package com.example.projrct

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projrct.databinding.ActivityAddBinding
import com.example.projrct.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    lateinit var subBinding: ActivitySubBinding
    var lifeno: Int = 3
    var scoreno: Int = 0
    var number1: Int = 0
    var number2: Int = 0
    var sub: Int=0
    private var timer: CountDownTimer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subBinding=ActivitySubBinding.inflate(layoutInflater)
        setContentView(subBinding.root)

        resetGame()
        timer=object :CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                subBinding.time1.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                lifeno--
                subBinding.life1.text=lifeno.toString()
                if(lifeno>0){
                    resetRound()
                }
                else{
                    Toast.makeText(this@SubActivity,"Game Over", Toast.LENGTH_LONG).show()
                }
            }
        }

        timer?.start()

        subBinding.checkbtn1.setOnClickListener{
            val givenAns: Int = subBinding.entryfieldno.text.toString().toInt()
            if(givenAns==sub){
                scoreno=scoreno+10
                subBinding.score1.text=scoreno.toString()
                resetRound()
            }
            else{
                lifeno--
                subBinding.life1.text=lifeno.toString()
                if(lifeno<=0){
                    Toast.makeText(this@SubActivity,"Game Over", Toast.LENGTH_LONG).show()
                }
                else{
                    resetRound()
                }
            }
        }

        subBinding.nextbtn1.setOnClickListener{
            if(lifeno>0){
                resetRound()
            }
            else{
                Toast.makeText(this@SubActivity,"Game Over", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun resetGame(){
        lifeno=3
        scoreno=0
        subBinding.life1.text=lifeno.toString()
        subBinding.score1.text=scoreno.toString()
        resetRound()
    }

    fun resetRound(){
        number1=(0..100).random()
        number2=(0..100).random()
        sub=number1-number2
        subBinding.operand11.text=number1.toString()
        subBinding.operand22.text=number2.toString()
        subBinding.entryfieldno.text.clear()
        timer?.start()
    }


}