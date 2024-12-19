package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityPantalladeinicioBinding
import kotlin.random.Random

class PantallaDeInicioActivity : AppCompatActivity() {

    companion object{
        val ID_PASO_FILA = "FILA"
        val ID_PASO_COLUMNA = "COLUMNA"

    }

    private lateinit var binding: ActivityPantalladeinicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantalladeinicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonJugar.setOnClickListener {
            var fila = Random.nextInt(1, 8)
            var columna = Random.nextInt(1, 5)
            while (fila*columna%2!=0||fila==columna){
                fila = Random.nextInt(1, 8)
                columna = Random.nextInt(1, 5)
            }
            val intent = Intent(this, PantallaDeJuegoActivity::class.java)
            intent.putExtra(ID_PASO_FILA,fila)
            intent.putExtra(ID_PASO_COLUMNA,columna)
            startActivity(intent)
        }

        binding.botonPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

    }
}