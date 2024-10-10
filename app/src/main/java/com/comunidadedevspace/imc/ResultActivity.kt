package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClass = findViewById<TextView>(R.id.tv_class)


        tvResult.text = result.toString()

        if (result >= 40.0) {
            tvClass.text = "Obesidade grau III"
            tvClass.setTextColor(getColor(R.color.red))

        } else if (result >= 35.0 && result <=39.99) {
            tvClass.text = "Obesidade grau II"
            tvClass.setTextColor(getColor(R.color.red))

        } else if (result >= 30.0 && result <=34.99) {
            tvClass.text = "Obesidade grau I"
            tvClass.setTextColor(getColor(R.color.orange))

        } else if (result >= 25.0 && result <=29.99) {
            tvClass.text = "Sobrepeso"
            tvClass.setTextColor(getColor(R.color.yellow))

        } else if (result >= 18.6 && result <=24.99) {
            tvClass.text = "Normal"
            tvClass.setTextColor(getColor(R.color.green))
            //Normal
        } else if (result <= 18.5) {
            tvClass.text = "Abaixo do normal"
            tvClass.setTextColor(getColor(R.color.blue))

        }

    }
}