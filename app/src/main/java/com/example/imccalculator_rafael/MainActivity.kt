package com.example.imccalculator_rafael

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    button_confirmar.setOnClickListener {
            val nomeUsuario = editText_usuario.text.toString()
            val intent = Intent(this, IMCCalculatorActivity::class.java).apply {
                putExtra("NOME_USUARIO", nomeUsuario)
            }
        startActivity(intent)
        }

    }

}
