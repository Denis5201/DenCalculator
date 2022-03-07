package com.example.dencalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.dencalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val work = Logic()

        for (num in binding.groupNumber.referencedIds) {
            val but = findViewById<Button>(num)
            but.setOnClickListener { binding.textdisplay.append(but.text) }
        }

        for (s in binding.groupSign.referencedIds) {
            val but = findViewById<Button>(s)
            but.setOnClickListener {
                work.setNumAndSign(binding.textdisplay.text.toString(), but.text[0])
                binding.textdisplay.setText("")
            }
        }

        binding.buttonDot.setOnClickListener {
            binding.textdisplay.append(".")
        }

        binding.buttonAC.setOnClickListener {
            binding.textdisplay.setText("")
            work.clean()
        }

        binding.changeSign.setOnClickListener {
            val result = work.change(binding.textdisplay.text.toString())
            binding.textdisplay.setText(result)
        }

        binding.percent.setOnClickListener {
            val result = work.percentRes(binding.textdisplay.text.toString())
            binding.textdisplay.setText(result)
        }

        binding.equal.setOnClickListener {
            val result = work.usualRes(binding.textdisplay.text.toString())

            if (result == "/0") {
                Toast.makeText(this, "Деление на 0", Toast.LENGTH_SHORT).show()
                binding.textdisplay.setText("")
            }
            else {
                binding.textdisplay.setText(result)
            }
        }
    }

}