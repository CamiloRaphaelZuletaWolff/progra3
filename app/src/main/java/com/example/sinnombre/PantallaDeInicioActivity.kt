package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityPantalladeinicioBinding

class PantallaDeInicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantalladeinicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantalladeinicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonJugar.setOnClickListener {
            val intent = Intent(this, PantallaGanarActivity::class.java)
            //intentJuegoCartas.putExtra(ID_PASO_DIFICULTAD,9)
            startActivity(intent)
        }

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