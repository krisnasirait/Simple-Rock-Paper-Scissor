package com.krisna.simplerockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRock: AppCompatButton = findViewById(R.id.btnRock)
        val btnScissor: AppCompatButton = findViewById(R.id.btnScissors)
        val btnPaper: AppCompatButton = findViewById(R.id.btnPaper)
        val btnReset: AppCompatButton = findViewById(R.id.btnReset)

        var userInput: TextView = findViewById(R.id.tvUserInput)
        var botInput: TextView = findViewById(R.id.tvBotInput)
        var resOutput: TextView = findViewById(R.id.tvResult)

        fun randBot(): String{
            val botInp = arrayOf("ROCK", "PAPER", "SCISSORS")
            val randInp = botInp.random()

            botInput.setText(randInp)

            return randInp
        }

        fun inpProcess(user:String, bot:String){
            if(user == "ROCK"){
                when(bot){
                    "ROCK" -> resOutput.setText("DRAW")
                    "PAPER" -> resOutput.setText("LOSE")
                    "SCISSORS" -> resOutput.setText("WIN")
                }
            }else if (user == "PAPER"){
                when(bot){
                    "ROCK" -> resOutput.setText("WIN")
                    "PAPER" -> resOutput.setText("DRAW")
                    "SCISSORS" -> resOutput.setText("LOSE")
                }
            }else if (user == "SCISSORS"){
                when(bot){
                    "ROCK" -> resOutput.setText("LOSE")
                    "PAPER" -> resOutput.setText("WIN")
                    "SCISSORS" -> resOutput.setText("DRAW")
                }
            }
        }

        btnRock.setOnClickListener {
            randBot()
            userInput.setText("ROCK")

            inpProcess("ROCK", randBot())

        }

        btnPaper.setOnClickListener {
            randBot()
            userInput.setText("PAPER")

            inpProcess("PAPER", randBot())
        }

        btnScissor.setOnClickListener {
            randBot()
            userInput.setText("SCISSORS")

            inpProcess("SCISSORS", randBot())
        }

        btnReset.setOnClickListener {
            userInput.setText("")
            botInput.setText("")
            resOutput.setText("")
        }
    }
}