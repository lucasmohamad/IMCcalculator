package com.example.imccalculator_rafael

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_imccalculator.*
import android.text.TextUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

class IMCCalculatorActivity : AppCompatActivity() {


        private lateinit var EditText_altura: EditText
        private lateinit var EditText_peso: EditText
        private lateinit var textView_resultadoIMC: TextView


        override fun onCreate(savedInstanceState: Bundle?): Unit {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_imccalculator)

            EditText_altura = findViewById(R.id.EditText_altura)
            EditText_peso = findViewById(R.id.EditText_peso)
            textView_resultadoIMC = findViewById(R.id.textView_resultadoIMC)



            val calculateButton: Button = findViewById(R.id.calculate_button)
            calculateButton.setOnClickListener {
                val alturaText = EditText_altura.text.toString()
                val pesoText = EditText_peso.text.toString()
                if (TextUtils.isEmpty(alturaText)) {
                    Toast.makeText(this, "Campo de altura obrigatório", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(pesoText)) {
                    Toast.makeText(this, "Campo de peso obrigatório", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val altura = alturaText.toDoubleOrNull()
                val peso = pesoText.toDoubleOrNull()
                if (altura == null) {
                    Toast.makeText(this, "Altura inválida", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (peso == null) {
                    Toast.makeText(this, "Peso inválido", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                    }

                val imc = peso / (altura * altura)
                val nomeUsuario = intent.getStringExtra("NOME_USUARIO")
                val result = String.format("$nomeUsuario seu IMC é de %.2f", imc)
                textView_resultadoIMC.text = result
                val pesoIdealMin = 18.5 * altura * altura
                val pesoIdealMax = 25.0 * altura * altura



                if (imc < 18.5) {
                    textView_IMCideal.text = "Você está abaixo do peso ideal"
                } else if (imc >= 18.5 && imc < 25) {
                    textView_IMCideal.text = "Você está no peso ideal"
                } else if (imc >= 25 && imc < 30) {
                    textView_IMCideal.text = "Você está acima do peso ideal"
                } else if (imc >= 30 && imc < 35) {
                    textView_IMCideal.text = "Você está com obesidade grau 1"
                } else if (imc >= 35 && imc < 40) {
                    textView_IMCideal.text = "Você está com Obesidade grau 2"
                } else {
                    textView_IMCideal.text = "Você está com Obesidade grau 3"
                }

                // Esconde o teclado
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

            }


        }
    }
