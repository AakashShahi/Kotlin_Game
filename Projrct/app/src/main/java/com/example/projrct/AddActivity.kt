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





//        var sum: Int=operand1+operand2
//
//
//
//        addBinding.life.text=life.toString()
//        addBinding.score.text=score.toString()
//        object :CountDownTimer(10000,1000){
//            override fun onTick(p0: Long) {
//                addBinding.time.text=(p0/1000).toString()
//
//            }
//
//            override fun onFinish() {
//                operand1= (0..100).random()
//                addBinding.operand1.text=operand1.toString()
//                operand2= (0..100).random()
//                addBinding.operand2.text=operand2.toString()
//                life=life-1
//                addBinding.life.text=life.toString()
//            }
//        }
//
//        addBinding.operand1.text=operand1.toString()
//        addBinding.operand2.text=operand2.toString()
//
//
//        if(life>0){
//        addBinding.checkbtn.setOnClickListener {
//            val givenAns: Int = addBinding.entryFieldSum.text.toString().toInt()
//            if (givenAns == sum) {
//                score = score + 10
//                addBinding.score.text = score.toString()
//                operand1 = (0..100).random()
//                addBinding.operand1.text = operand1.toString()
//                operand2 = (0..100).random()
//                addBinding.operand2.text = operand2.toString()
//                sum = operand1 + operand2
//            } else {
//                if(life>0) {
//                    life = life - 1
//                    addBinding.life.text = life.toString()
//                }
//                else{
//                    Toast.makeText(this,"Game Over", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//        }
//        else{
//            Toast.makeText(this,"Game Over", Toast.LENGTH_LONG).show()
//        }
//
//        addBinding.nectbtn.setOnClickListener{
//            if (life>0) {
//                operand1 = (0..100).random()
//                addBinding.operand1.text = operand1.toString()
//                operand2 = (0..100).random()
//                addBinding.operand2.text = operand2.toString()
//                life = life - 1
//                addBinding.life.text = life.toString()
//            }
//            else{
//                Toast.makeText(this,"Game Over", Toast.LENGTH_LONG).show()
//            }
//        }
//
//
//    }