package com.example.sinnombre

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sinnombre.databinding.ActivityPantalladeinicioBinding
import com.example.sinnombre.databinding.ActivityPuntajeBinding

class PantallaDeInicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantalladeinicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantalladeinicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        binding.botonJugar.setOnClickListener {
//            val intent = Intent(this, PantallaDeJuegoActivity::class.java)
//            startActivity(intent)
//        }

        binding.botonPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

        binding.botonPuntaje.setOnClickListener {
            val intent = Intent(this, PuntajeActivity::class.java)
            startActivity(intent)
        }
    }
}