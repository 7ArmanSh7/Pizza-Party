package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialising the variables by passing the ID
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * This function is initiated when the user clicks on calculate button
     * and it calculates the totall number of pizza needed based on
     * user input on how many people are attanding the party and how
     * hungry they are. At the end, it sets the text of the num_pizzas text_view
     * to the totall number of pizza needed.
     * @param View view The associated view
     */
    fun CALCULATE(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toInt()

        // Determine how many slices on average each person will eat
        // 2 slices of pizza per person for light,
        // 3 slices of pizza per person for medium,
        // and 4 slices of pizza per person for ravenous,
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        // Calculate and show the number of pizzas needed
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        //Sets the result to the text of  numPizzasTextView
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}