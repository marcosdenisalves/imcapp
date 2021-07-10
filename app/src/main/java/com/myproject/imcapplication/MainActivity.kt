package com.myproject.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relative_main)
        setListeners()
    }

    private fun setListeners() {
        inputTxtOne?.doAfterTextChanged { text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        inputTxtOne?.doOnTextChanged { text, _, _, _ ->
        }
        btnCalc?.setOnClickListener {
            calculateIMC(inputTxtOne.text.toString(), inputTxtTwo.text.toString())
        }
    }

    private fun calculateIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            textResult.text = """
                Seu IMC é %.2f
            """.trimIndent().format(imc)
        }
    }
}