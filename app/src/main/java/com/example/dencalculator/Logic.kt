package com.example.dencalculator

class Logic {

    private var number1 = ""
    private var sign = 'n'

    fun setNumAndSign(num:String, s:Char){
        number1 = num
        sign = s
    }

    fun clean(){
        number1 = ""
        sign = 'n'
    }

    fun change(str:String):String {
        return if (str != "" && str != "0")
            if (str.toDouble() > 0)
                "-$str"
            else
                str.drop(1)
        else str
    }

    fun usualRes(number2:String):String {

        return if (number2 == "0" && sign == '÷') {
            "/0"
        }
        else if (number1 != "" && number2 != "") {
            when (sign) {
                '+' -> (number1.toDouble() + number2.toDouble()).toString()
                '-' -> (number1.toDouble() - number2.toDouble()).toString()
                'x' -> (number1.toDouble() * number2.toDouble()).toString()
                '÷' -> (number1.toDouble() / number2.toDouble()).toString()
                else -> ""
            }
        }
        else ""
    }

    fun percentRes(number2:String):String {

        return if (number1 != "" && number2 != "") {
            when (sign) {
                '+' -> (number1.toDouble() + number2.toDouble() * number1.toDouble() / 100).toString()
                '-' -> (number1.toDouble() - number2.toDouble() * number1.toDouble() / 100).toString()
                '*' -> (number1.toDouble() * number2.toDouble() / 100).toString()
                '/' -> (number1.toDouble() / (number2.toDouble() / 100)).toString()
                else -> ""
            }
        }
        else ""
    }
}