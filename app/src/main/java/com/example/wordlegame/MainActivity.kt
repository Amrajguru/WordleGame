package com.example.wordlegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.wordlegame.FourLetterWordList
import com.example.wordlegame.FourLetterWordList.getRandomFourLetterWord

var count = 0

class MainActivity : AppCompatActivity() {
    var wordToGuess = getRandomFourLetterWord().toString().uppercase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inputbutton = findViewById<Button>(R.id.inputbutton)
        var resetbutton = findViewById<Button>(R.id.resetbutton)

        inputbutton.setOnClickListener {
            if(count==0) {
                var guessinput = findViewById<EditText>(R.id.GuessInput) as EditText
                var guess = guessinput.text.toString().uppercase()
                var guessdisplay = findViewById<TextView>(R.id.outputG1)
                var guesscheckdisplay = findViewById<TextView>(R.id.outputGC1)
                guessdisplay.setText(guess)
                guesscheckdisplay.setText(checkGuess(guess))
                count++
            }
            else if (count==1) {
                var guessinput = findViewById<EditText>(R.id.GuessInput) as EditText
                var guess = guessinput.text.toString().uppercase()
                var guessdisplay = findViewById<TextView>(R.id.outputG2)
                var guesscheckdisplay = findViewById<TextView>(R.id.outputGC2)
                guessdisplay.setText(guess)
                guesscheckdisplay.setText(checkGuess(guess))
                count++
            }
            else if (count==2){
                var guessinput = findViewById<EditText>(R.id.GuessInput) as EditText
                var guess = guessinput.text.toString().uppercase()
                var guessdisplay = findViewById<TextView>(R.id.outputG3)
                var guesscheckdisplay = findViewById<TextView>(R.id.outputGC3)
                var Finalword = findViewById<TextView>(R.id.FinalWord)
                guessdisplay.setText(guess)
                guesscheckdisplay.setText(checkGuess(guess))
                guessinput.isEnabled = false
                guessinput.setTextColor(ContextCompat.getColor(guessinput.context, R.color.white))
                guessinput.setBackgroundColor(ContextCompat.getColor(guessinput.context, R.color.black))
                guessinput.setText("Max Limit hit")
                Finalword.setText(wordToGuess)
            }
        }

        resetbutton.setOnClickListener{
            count=0;
            wordToGuess = getRandomFourLetterWord().toString().uppercase()
            var guessinput = findViewById<EditText>(R.id.GuessInput) as EditText
            var guessdisplay1 = findViewById<TextView>(R.id.outputG1)
            var guesscheckdisplay1 = findViewById<TextView>(R.id.outputGC1)
            var guessdisplay2 = findViewById<TextView>(R.id.outputG2)
            var guesscheckdisplay2 = findViewById<TextView>(R.id.outputGC2)
            var guessdisplay3 = findViewById<TextView>(R.id.outputG3)
            var guesscheckdisplay3 = findViewById<TextView>(R.id.outputGC3)
            var Finalword = findViewById<TextView>(R.id.FinalWord)

            guessinput.isEnabled = true
            guessinput.setTextColor(ContextCompat.getColor(guessinput.context, R.color.black))
            guessinput.setBackgroundColor(ContextCompat.getColor(guessinput.context, R.color.white))

            guessinput.setText(" ")
            guessdisplay1.setText(" ")
            guesscheckdisplay1.setText(" ")
            guessdisplay2.setText(" ")
            guesscheckdisplay2.setText(" ")
            guessdisplay3.setText(" ")
            guesscheckdisplay3.setText(" ")
            Finalword.setText(" ")

            Toast.makeText( this@MainActivity,"Everything has been Reset", Toast.LENGTH_SHORT).show();
        }

    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

}