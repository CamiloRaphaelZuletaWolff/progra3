package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sinnombre.JuegoCartas.Companion.ID_PASO_DIFICULTAD
import com.example.sinnombre.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {


    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.prueba.setOnClickListener{
            val intentJuegoCartas = Intent(this, LogicaCartasActivity::class.java)
//            intentJuegoCartas.putExtra(ID_PASO_DIFICULTAD,9)
            startActivity(intentJuegoCartas)
        }
    }
}