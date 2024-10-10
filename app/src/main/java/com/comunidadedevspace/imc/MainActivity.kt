package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Receber oque esta dentro dos edit text
        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaFinal = altura * altura
                val imc = peso / alturaFinal

                //Ir para a proxima tela
                // Enviar para proxima tela os resultados
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, imc)
                startActivity(intent)

            } else {
                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos.",
                    Snackbar.LENGTH_LONG
                ).show()

            }


        }
    }
}