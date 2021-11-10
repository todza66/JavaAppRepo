package com.example.calctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.calctest.R.layout.activity_main
import net.objecthunter.exp4j.ExpressionBuilder

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        calc0.setOnClickListener { addToExpression("0", true)}
        calc1.setOnClickListener { addToExpression("1", true)}
        calc2.setOnClickListener { addToExpression("2", true)}
        calc3.setOnClickListener { addToExpression("3", true)}
        calc4.setOnClickListener { addToExpression("4", true)}
        calc5.setOnClickListener { addToExpression("5", true)}
        calc6.setOnClickListener { addToExpression("6", true)}
        calc7.setOnClickListener { addToExpression("7", true)}
        calc8.setOnClickListener { addToExpression("8", true)}
        calc9.setOnClickListener { addToExpression("9", true)}

        //Get Operators
        calcPlus.setOnClickListener { addToExpression("+", true) }
        calcMinus.setOnClickListener { addToExpression("-", true) }
        calcTimes.setOnClickListener { addToExpression("*", true) }
        calcDivide.setOnClickListener { addToExpression("/", true) }
        tvOpen.setOnClickListener { addToExpression("(", true) }
        calcClose.setOnClickListener { addToExpression(")", true) }
        calcDot.setOnClickListener { addToExpression(".", true) }

        calcClear.setOnClickListener {
            calcExpression.text = " "
            calcResult.text = " "
        }

        calcBack.setOnClickListener {
            val string = calcExpression.text.toString()
            if(string.isNotEmpty()){
                calcExpression.text = string.substring(0, string.length-1)
            }
            calcResult.text = " "
        }

        calcEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(calcExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()){
                    calcResult.text = longResult.toString()
                }else
                    calcResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception", "message" + e.message)
            }
        }
        Toast.makeText(applicationContext, "Application Created", Toast.LENGTH_LONG).show()
        
    }

    fun addToExpression(string: String, canClear: Boolean){



        if(canClear) {
            calcResult.text = " "
            calcExpression.append(string)
        } else{
            calcExpression.append(calcResult.text)
            calcExpression.append(string)
            calcResult.text = " "
        }
    }

}
