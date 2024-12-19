package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.PantallaDeInicioActivity.Companion.ID_PASO_COLUMNA
import com.example.sinnombre.PantallaDeInicioActivity.Companion.ID_PASO_FILA
import com.example.sinnombre.databinding.ActivityPantallaperderBinding
import kotlin.random.Random

class PantallaPerderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaperderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPantallaperderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botonReiniciar: ImageButton = findViewById(R.id.boton_reiniciar)
        botonReiniciar.setOnClickListener {

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
            val botonAtras: ImageButton = findViewById(R.id.boton_inicio)
            botonAtras.setOnClickListener {

                val intent = Intent(this, PantallaDeInicioActivity::class.java)
                startActivity(intent)
                finish()
            }

    }
}
