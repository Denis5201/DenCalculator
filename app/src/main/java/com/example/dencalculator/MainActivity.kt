package com.example.dencalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.button0.setOnClickListener { binding.textdisplay.append("0") }
        binding.button1.setOnClickListener { binding.textdisplay.append("1") }
        binding.button2.setOnClickListener { binding.textdisplay.append("2") }
        binding.button3.setOnClickListener { binding.textdisplay.append("3") }
        binding.button4.setOnClickListener { binding.textdisplay.append("4") }
        binding.button5.setOnClickListener { binding.textdisplay.append("5") }
        binding.button6.setOnClickListener { binding.textdisplay.append("6") }
        binding.button7.setOnClickListener { binding.textdisplay.append("7") }
        binding.button8.setOnClickListener { binding.textdisplay.append("8") }
        binding.button9.setOnClickListener { binding.textdisplay.append("9") }
        binding.buttonDot.setOnClickListener { binding.textdisplay.append(".") }

        binding.buttonAC.setOnClickListener {
            binding.textdisplay.setText("")
            number1 = ""
            number2 = ""
            sign = 'n'
        }
        binding.changeSign.setOnClickListener {
            var temp = binding.textdisplay.text.toString()
            if (temp != "" && temp != "0")
            if (temp.toDouble()>0)
                binding.textdisplay.setText("-$temp")
            else
                binding.textdisplay.setText(temp.drop(1))
        }

        binding.percent.setOnClickListener {
            number2 = binding.textdisplay.text.toString()

            if (number1 != "" && number2 != "") {
                val result = when (sign) {
                    '+' -> (number1.toDouble() + number2.toDouble()*number1.toDouble()/100).toString()
                    '-' -> (number1.toDouble() - number2.toDouble()*number1.toDouble()/100).toString()
                    '*' -> (number1.toDouble() * number2.toDouble()/100).toString()
                    '/' -> (number1.toDouble() / (number2.toDouble()/100)).toString()
                    else -> ""
                }
                binding.textdisplay.setText(result)
            }

        }

        binding.sum.setOnClickListener {
            number1 = binding.textdisplay.text.toString()
            sign = '+'
            binding.textdisplay.setText("")
        }
        binding.sub.setOnClickListener {
            number1 = binding.textdisplay.text.toString()
            sign = '-'
            binding.textdisplay.setText("")
        }
        binding.multi.setOnClickListener {
            number1 = binding.textdisplay.text.toString()
            sign = '*'
            binding.textdisplay.setText("")
        }
        binding.division.setOnClickListener {
            number1 = binding.textdisplay.text.toString()
            sign = '/'
            binding.textdisplay.setText("")
        }

        binding.equal.setOnClickListener {
            number2 = binding.textdisplay.text.toString()

            if (number2 == "0" && sign == '/') {
                Toast.makeText(this, "Деление на 0", Toast.LENGTH_SHORT).show()
                binding.textdisplay.setText("")
            }
            else if (number1 != "" && number2 != "") {
                val result = when (sign) {
                    '+' -> (number1.toDouble() + number2.toDouble()).toString()
                    '-' -> (number1.toDouble() - number2.toDouble()).toString()
                    '*' -> (number1.toDouble() * number2.toDouble()).toString()
                    '/' -> (number1.toDouble() / number2.toDouble()).toString()
                    else -> ""
                }
                binding.textdisplay.setText(result)
            }
        }
    }
}