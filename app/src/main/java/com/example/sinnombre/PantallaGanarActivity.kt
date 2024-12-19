package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityPantallaganarBinding
import com.example.sinnombre.PantallaDeInicioActivity

class PantallaGanarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaganarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPantallaganarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonSiguientenivel: ImageButton = findViewById(R.id.boton_siguiente_nivel)
        botonSiguientenivel.setOnClickListener {

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
