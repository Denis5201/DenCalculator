package com.example.dencalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        binding.buttonAC.setOnClickListener {
            binding.textdisplay.setText("")
            number1 = ""
            number2 = ""
            sign = 'n'
        }

        binding.changeSign.setOnClickListener {
            val temp = binding.textdisplay.text.toString()
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

    fun onNumberClick(view: View) {
        var ID = view.id
        when (ID) {
            binding.button0.id -> binding.textdisplay.append("0")
            binding.button1.id -> binding.textdisplay.append("1")
            binding.button2.id -> binding.textdisplay.append("2")
            binding.button3.id -> binding.textdisplay.append("3")
            binding.button4.id -> binding.textdisplay.append("4")
            binding.button5.id -> binding.textdisplay.append("5")
            binding.button6.id -> binding.textdisplay.append("6")
            binding.button7.id -> binding.textdisplay.append("7")
            binding.button8.id -> binding.textdisplay.append("8")
            binding.button9.id -> binding.textdisplay.append("9")
            binding.buttonDot.id -> binding.textdisplay.append(".")
        }
    }

    fun onSignClick(view: View) {
        number1 = binding.textdisplay.text.toString()
        binding.textdisplay.setText("")

        var ID = view.id
        when (ID) {
            binding.sum.id -> sign = '+'
            binding.sub.id -> sign = '-'
            binding.multi.id -> sign = '*'
            binding.division.id -> sign = '/'
        }
    }


}