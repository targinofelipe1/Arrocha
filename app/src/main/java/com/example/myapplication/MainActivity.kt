package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.Jogo_Arrocha.Arrocha
import android.view.View.OnClickListener
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var tvLimMenor: TextView
    private lateinit var tvLimMaior: TextView
    private lateinit var tvStatus: TextView
    private lateinit var etChute: EditText
    private lateinit var btnChutar: Button
    private lateinit var arrocha: Arrocha


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvLimMenor = findViewById(R.id.tvLimMenor)
        this.tvLimMaior = findViewById(R.id.tvLimMaior)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.etChute = findViewById(R.id.etChute)
        this.btnChutar = findViewById(R.id.btnChutar)

        this.arrocha = Arrocha(1,100)
        f5()


        this.btnChutar.setOnClickListener(ClickBotao())
    }

    fun chutar(){
        var valor = this.etChute.text.toString().toInt()
        var resposta = this.arrocha.jogar(valor)
        if (resposta > 0){
            Toast.makeText(this, "Seu chute é maior!", Toast.LENGTH_SHORT).show()
        }else if (resposta < 0){
            Toast.makeText(this, "Seu chute é menor!", Toast.LENGTH_SHORT).show()
        }else{
        }
        f5()
    }

    fun f5(){
        this.tvLimMenor.text = this.arrocha.valormenor.toString()
        this.tvLimMaior.text = this.arrocha.valormaior.toString()
        this.tvStatus.text = this.arrocha.status.toString()
        this.etChute.text.clear()
    }

    inner class ClickBotao: OnClickListener{
        override fun onClick(v: View?) {
            var valor = this@MainActivity.etChute.text.toString().toInt()
            var resposta = this@MainActivity.arrocha.jogar(valor)
            if (resposta > 0){
                Toast.makeText(this@MainActivity, "Seu chute é maior!", Toast.LENGTH_SHORT).show()
            }else if (resposta < 0){
                Toast.makeText(this@MainActivity, "Seu chute é menor!", Toast.LENGTH_SHORT).show()
            }else{
            }
            f5()
        }

    }
}