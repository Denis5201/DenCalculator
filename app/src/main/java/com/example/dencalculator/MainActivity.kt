package com.example.dencalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.dencalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    var number1 = ""
    var number2 = ""
    var sign = 'n'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (num in binding.groupNumber.referencedIds) {
            val but = findViewById<Button>(num)
            but.setOnClickListener { binding.textdisplay.append(but.text) }
        }

        for (s in binding.groupSign.referencedIds) {
            val but = findViewById<Button>(s)
            but.setOnClickListener {
                number1 = binding.textdisplay.text.toString()
                binding.textdisplay.setText("")

                sign = but.text[0]
            }
        }

        binding.buttonDot.setOnClickListener {
            binding.textdisplay.append(".")
        }

        binding.buttonAC.setOnClickListener {
            binding.textdisplay.setText("")
            number1 = ""
            number2 = ""
            sign = 'n'
        }

        binding.changeSign.setOnClickListener {
            val temp = binding.textdisplay.text.toString()
            if (temp != "" && temp != "0")
                if (temp.toDouble() > 0)
                    binding.textdisplay.setText("-$temp")
                else
                    binding.textdisplay.setText(temp.drop(1))
        }

        binding.percent.setOnClickListener {
            number2 = binding.textdisplay.text.toString()

            if (number1 != "" && number2 != "") {
                val result = when (sign) {
                    '+' -> (number1.toDouble() + number2.toDouble() * number1.toDouble() / 100).toString()
                    '-' -> (number1.toDouble() - number2.toDouble() * number1.toDouble() / 100).toString()
                    '*' -> (number1.toDouble() * number2.toDouble() / 100).toString()
                    '/' -> (number1.toDouble() / (number2.toDouble() / 100)).toString()
                    else -> ""
                }
                binding.textdisplay.setText(result)
            }

        }

        binding.equal.setOnClickListener {
            number2 = binding.textdisplay.text.toString()

            if (number2 == "0" && sign == '/') {
                Toast.makeText(this, "Деление на 0", Toast.LENGTH_SHORT).show()
                binding.textdisplay.setText("")
            } else if (number1 != "" && number2 != "") {
                val result = when (sign) {
                    '+' -> (number1.toDouble() + number2.toDouble()).toString()
                    '-' -> (number1.toDouble() - number2.toDouble()).toString()
                    'x' -> (number1.toDouble() * number2.toDouble()).toString()
                    '÷' -> (number1.toDouble() / number2.toDouble()).toString()
                    else -> ""
                }
                binding.textdisplay.setText(result)
            }
        }
    }
    
}