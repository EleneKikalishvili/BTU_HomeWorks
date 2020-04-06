package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        equals.setOnClickListener {
            val secOperandText: String = resultText.text.toString()
            var secOperand = 0.0
            if (!TextUtils.isEmpty(secOperandText)) {
                secOperand = secOperandText.toDouble()
            }
            when(this.operation) {
                "+" -> resultText.text = (this.operand + secOperand).toString()
                "-" -> resultText.text = (this.operand - secOperand).toString()
                "*" -> resultText.text = (this.operand * secOperand).toString()
                "/" -> {
                    if(secOperand != 0.0)
                    {resultText.text = (this.operand / secOperand).toString()}
                }
            }
        }

        Clear.setOnClickListener {
            resultText.text = ""
            this.operand = 0.0
            this.operation = ""
            dot.isClickable = true
        }

        dot.setOnClickListener {
            val numbers = resultText.text.toString()
            resultText.setText(numbers+".")
            dot.isClickable=false

        }

        delete.setOnClickListener{
            val string = resultText.text.toString()
            if(string.isNotEmpty()){
                resultText.text = string.substring(0, string.length-1)
                if(!resultText.text.contains(".")){
                    dot.isClickable=true
                }
            }
        }

    }

    fun numberClick(view: View){
        if (view is TextView) {
            val number:String = view.text.toString()
            var result:String = resultText.text.toString()

            if (result == "0") {
                result = ""
            }

            resultText.text = result + number
        }
    }

fun operationClick(view: View) {
        if (view is TextView) {
            if (!TextUtils.isEmpty(resultText.text)){
                this.operand = resultText.text.toString().toDouble()
            }

            resultText.text = ""

            this.operation = view.text.toString()
            dot.isClickable=true
        }
    }


}
