package com.example.alculatorapplication_nesterov405

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.alculatorapplication_nesterov405.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)





        binding.buttonClear.setOnClickListener{
            binding.input.text = ""
            binding.output.text = ""
        }

        binding.buttonBracketLeft.setOnClickListener{
            binding.input.text = addToInputText( "(")
        }
        binding.buttonBracketRight.setOnClickListener{
            binding.input.text = addToInputText( ")")
        }
        binding.buttonDivision.setOnClickListener{
            binding.input.text = addToInputText( "÷")
        }
        binding.button0.setOnClickListener{
            binding.input.text = addToInputText( "0")
        }
        binding.button1.setOnClickListener{
            binding.input.text = addToInputText( "1")
        }
        binding.button2.setOnClickListener{
            binding.input.text = addToInputText( "2")
        }
        binding.button3.setOnClickListener{
            binding.input.text = addToInputText( "3")
        }
        binding.button4.setOnClickListener{
            binding.input.text = addToInputText( "4")
        }
        binding.button5.setOnClickListener{
            binding.input.text = addToInputText( "5")
        }
        binding.button6.setOnClickListener{
            binding.input.text = addToInputText( "6")
        }
        binding.button7.setOnClickListener{
            binding.input.text = addToInputText( "7")
        }
        binding.button8.setOnClickListener{
            binding.input.text = addToInputText( "8")
        }
        binding.button9.setOnClickListener{
            binding.input.text = addToInputText( "9")
        }
        binding.buttonPoint.setOnClickListener{
            binding.input.text = addToInputText( ".")
        }
        binding.buttonSubtraction.setOnClickListener{
            binding.input.text = addToInputText( "-")
        }
        binding.buttonAddition.setOnClickListener{
            binding.input.text = addToInputText( "+")
        }
        binding.buttonMultiply.setOnClickListener{
            binding.input.text = addToInputText( "×")
        }
        binding.buttonDivision.setOnClickListener{
            binding.input.text = addToInputText( "÷")
        }


        binding.buttonEquals.setOnClickListener{
            showResult()
        }
    }


    private fun addToInputText(buttonValue: String): String {
        return "${binding.input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = binding.input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //error
                binding.output.text= "Error"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
            } else {
                //result
                binding.output.text= DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
        }
        catch (e: Exception) {
                //error
            binding.output.text= "Error"
            binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }

}