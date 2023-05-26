package com.example.mydiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*
* This activity allows the user to roll a dice and view the result
* on the screen.
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button3)
        rollButton.setOnClickListener {
           // val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            // toast.show()
            rollDice()
        }
        rollDice()
    }

    /*
* Roll the dice and update the screen with the result.
 */
    private fun rollDice() {

        val dice = Dice(6)
        val diceRoll = dice.roll()//1~6까지의 랜덤 숫자 반환
        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()//1~6까지의 랜덤 숫자 반환
        //Find the ImageView in the layout
        val diceImage2: ImageView = findViewById(R.id.imageView2)


        //Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when(diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}