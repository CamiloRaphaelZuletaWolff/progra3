package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.DataClasses.PuntajeDB
import com.example.sinnombre.SQLite.SQLManager
import com.example.sinnombre.databinding.ActivityPuntajeBinding

class PuntajeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPuntajeBinding
    private lateinit var sqlManager: SQLManager

    private lateinit var datoTiempoTotalJugado: TextView
    private lateinit var datoTotalAciertos: TextView
    private lateinit var datoTotalIncorrectos: TextView
    private lateinit var datoTotalReinicios: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPuntajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sqlManager = SQLManager(this)

        datoTiempoTotalJugado = binding.datoTiempoTotalJugado
        datoTotalAciertos = binding.datoTotalAciertos
        datoTotalIncorrectos = binding.datoTotalIncorrectos
        datoTotalReinicios = binding.datoTotalReinicios

        binding.botonAtras.setOnClickListener {
            val intent = Intent(this, PantallaDeInicioActivity::class.java)
            startActivity(intent)
        }

        inicializarPuntaje()

        actualizarYMostrarDatosPuntaje()
    }

    private fun inicializarPuntaje() {
        val puntajeInicial = PuntajeDB(
            idPuntaje = 0,
            tiempoTotalJugado = "0",
            totalAciertos = 0,
            totalIncorrectos = 0,
            totalReinicios = 0
        )
        sqlManager.crearPuntaje(puntajeInicial)
    }

    private fun actualizarYMostrarDatosPuntaje() {
        // Actualizar y mostrar los datos del tiempo total jugado
        sqlManager.actualizarTiempoTotalJugado()
        val tiempoTotal = sqlManager.obtenerTiempoTotal()
        datoTiempoTotalJugado.text = tiempoTotal

        // Actualizar y mostrar los datos del total de aciertos
        sqlManager.actualizarTotalAciertos()
        val totalAciertos = sqlManager.obtenerTotalAciertos()
        datoTotalAciertos.text = totalAciertos.toString()

        // Actualizar y mostrar los datos del total de incorrectos
        sqlManager.actualizarTotalIncorrectos()
        val totalIncorrectos = sqlManager.obtenerTotalIncorrectos()
        datoTotalIncorrectos.text = totalIncorrectos.toString()

        // Actualizar y mostrar los datos del total de reinicios
        sqlManager.actualizarTotalReinicios()
        val totalReinicios = sqlManager.obtenerTotalReinicios()
        datoTotalReinicios.text = totalReinicios.toString()
    }
}