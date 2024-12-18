package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityPuntajeBinding

class PuntajeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPuntajeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPuntajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonAtras.setOnClickListener {
            val intent = Intent(this, PantallaDeInicioActivity::class.java)
            startActivity(intent)
        }
    }
}