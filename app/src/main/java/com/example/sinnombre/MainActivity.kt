package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sinnombre.databinding.ActivityMainBinding
import com.example.sinnombre.databinding.ActivityMenuBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.prueba.setOnClickListener{
            val intentJuegoCartas = Intent(this, LogicaCartasActivity::class.java)
//            intentJuegoCartas.putExtra(ID_PASO_DIFICULTAD,9)
            startActivity(intentJuegoCartas)
        }
    }
}