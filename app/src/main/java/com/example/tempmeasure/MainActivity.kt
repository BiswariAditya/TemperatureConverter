package com.example.tempmeasure
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTemperature: EditText = findViewById(R.id.inputTemperature)
        val toCelsius: RadioButton = findViewById(R.id.toCelsius)
        val convertButton: Button = findViewById(R.id.convertButton)
        val resultText: TextView = findViewById(R.id.resultText)

        convertButton.setOnClickListener {
            val temperature = inputTemperature.text.toString().toDoubleOrNull()

            if (temperature == null) {
                resultText.text = "Invalid temperature"
                return@setOnClickListener
            }

            val convertedTemperature = if (toCelsius.isChecked) {
                (temperature - 32) * 5 / 9
            } else {
                (temperature * 9 / 5) + 32
            }

            val resultMessage = "Converted temperature: %.2f".format(convertedTemperature)
            resultText.text = resultMessage
        }
    }
}
