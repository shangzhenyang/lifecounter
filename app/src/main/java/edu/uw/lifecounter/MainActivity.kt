package edu.uw.lifecounter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonsMinus = arrayOf(
            findViewById<Button>(R.id.btn_minus_1),
            findViewById<Button>(R.id.btn_minus_2),
            findViewById<Button>(R.id.btn_minus_3),
            findViewById<Button>(R.id.btn_minus_4)
        )
        val buttonsPlus = arrayOf(
            findViewById<Button>(R.id.btn_plus_1),
            findViewById<Button>(R.id.btn_plus_2),
            findViewById<Button>(R.id.btn_plus_3),
            findViewById<Button>(R.id.btn_plus_4)
        )
        val buttonsMinusFive = arrayOf(
            findViewById<Button>(R.id.btn_minus_five_1),
            findViewById<Button>(R.id.btn_minus_five_2),
            findViewById<Button>(R.id.btn_minus_five_3),
            findViewById<Button>(R.id.btn_minus_five_4)
        )
        val buttonsPlusFive = arrayOf(
            findViewById<Button>(R.id.btn_plus_five_1),
            findViewById<Button>(R.id.btn_plus_five_2),
            findViewById<Button>(R.id.btn_plus_five_3),
            findViewById<Button>(R.id.btn_plus_five_4)
        )
        val labelsScore = arrayOf(
            findViewById<TextView>(R.id.player_score_1),
            findViewById<TextView>(R.id.player_score_2),
            findViewById<TextView>(R.id.player_score_3),
            findViewById<TextView>(R.id.player_score_4)
        )
        val buttonBars = arrayOf(
            findViewById<LinearLayout>(R.id.button_bar_1),
            findViewById<LinearLayout>(R.id.button_bar_2),
            findViewById<LinearLayout>(R.id.button_bar_3),
            findViewById<LinearLayout>(R.id.button_bar_4)
        )
        for (button in buttonsMinus) {
            button.setOnClickListener {
                buttonClicked(-1, it as Button, labelsScore, buttonBars)
            }
        }
        for (button in buttonsPlus) {
            button.setOnClickListener {
                buttonClicked(1, it as Button, labelsScore, buttonBars)
            }
        }
        for (button in buttonsMinusFive) {
            button.setOnClickListener {
                buttonClicked(-5, it as Button, labelsScore, buttonBars)
            }
        }
        for (button in buttonsPlusFive) {
            button.setOnClickListener {
                buttonClicked(5, it as Button, labelsScore, buttonBars)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun buttonClicked(delta: Int, button: Button, labelsScore: Array<TextView>,
                              buttonBars: Array<LinearLayout>) {
        val index = button.resources.getResourceName(button.id).last().toString().toInt()
        val labelScore = labelsScore[index - 1]
        val newScore = labelScore.text.toString().toInt() + delta
        labelScore.text = newScore.toString()
        if (newScore <= 0) {
            val labelStatus = findViewById<TextView>(R.id.label_status)
            labelStatus.text = "Player $index LOSES!"
            labelStatus.visibility = View.VISIBLE
            buttonBars[index - 1].visibility = View.INVISIBLE
        }
    }
}