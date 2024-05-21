package com.example.projrct

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projrct.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var addBinding: ActivityAddBinding
    var lifeno: Int = 3
    var scoreno: Int = 0
    var number1: Int = 0
    var number2: Int = 0
    var sum: Int=0
    private var timer: CountDownTimer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(addBinding.root)

        resetGame()

        timer=object :CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                addBinding.time.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                lifeno--
                addBinding.life.text=lifeno.toString()
                if(lifeno>0){
                    resetRound()
                }
                else{
                    Toast.makeText(this@AddActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
            }
        }

        timer?.start()

        addBinding.checkbtn.setOnClickListener{
            val givenAns: Int = addBinding.entryFieldSum.text.toString().toInt()
            if(givenAns==sum){
                scoreno=scoreno+10
                addBinding.score.text=scoreno.toString()
                resetRound()
            }
            else{
                lifeno--
                addBinding.life.text=lifeno.toString()
                if(lifeno<=0){
                    Toast.makeText(this@AddActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
                else{
                    resetRound()
                }
            }
        }

        addBinding.nectbtn.setOnClickListener{
            if(lifeno>0){
                resetRound()
            }
            else{
                Toast.makeText(this@AddActivity,"Game Over",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun resetGame(){
        lifeno=3
        scoreno=0
        addBinding.life.text=lifeno.toString()
        addBinding.score.text=scoreno.toString()
        resetRound()
    }

    fun resetRound(){
        number1=(0..100).random()
        number2=(0..100).random()
        sum=number1+number2
        addBinding.operand1.text=number1.toString()
        addBinding.operand2.text=number2.toString()
        addBinding.entryFieldSum.text.clear()
        timer?.start()
    }
}





