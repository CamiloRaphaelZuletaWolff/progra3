package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityPantallaperderBinding

class PantallaPerderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaperderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPantallaperderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonReiniciar: ImageButton = findViewById(R.id.boton_reiniciar)
        botonReiniciar.setOnClickListener {

            val intent = Intent(this, PantallaDeInicioActivity::class.java)
            startActivity(intent)


            val botonAtras: ImageButton = findViewById(R.id.boton_inicio)
            botonAtras.setOnClickListener {

                val intent = Intent(this, PantallaDeInicioActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
