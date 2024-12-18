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
        val view = binding.root
        setContentView(view)
        binding.botonJugar.setOnClickListener{
            val intentJuegoCartas = Intent(this, PantallaDeJuegoActivity::class.java)
//            intentJuegoCartas.putExtra(ID_PASO_DIFICULTAD,9)
            startActivity(intentJuegoCartas)
        }
    }
}