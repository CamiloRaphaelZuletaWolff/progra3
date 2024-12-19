package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityPantallaganarBinding // Asegúrate de que el binding esté configurado correctamente
import com.example.sinnombre.PantallaDeInicioActivity // Cambia al nombre completo del paquete donde esté declarada tu actividad

class PantallaGanarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaganarBinding // Usar ViewBinding si lo configuraste correctamente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar ViewBinding
        binding = ActivityPantallaganarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonSiguientenivel: ImageButton = findViewById(R.id.boton_siguiente_nivel)
        botonSiguientenivel.setOnClickListener {
            // Redirigir a PantallaDeInicioActivity
            val intent = Intent(this, PantallaDeInicioActivity::class.java)
            startActivity(intent)

            // Configurar el botón "Atrás"
            val botonAtras: ImageButton = findViewById(R.id.boton_inicio)
            botonAtras.setOnClickListener {
                // Redirigir a PantallaDeInicioActivity
                val intent = Intent(this, PantallaDeInicioActivity::class.java)
                startActivity(intent)
                finish() // Finaliza esta actividad
            }
        }
    }
}
