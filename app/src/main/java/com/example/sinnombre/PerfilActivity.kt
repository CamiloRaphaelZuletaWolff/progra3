package com.example.sinnombre

import android.content.Intent
import android.graphics.Color
import kotlinx.coroutines.*
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sinnombre.databinding.ActivityPantallaJuegoBinding
import com.example.sinnombre.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")

        binding.correoUsuario.text = email ?: "Correo no recibido"

        binding.botonCerrarSesion.setOnClickListener {
            finish()
        }
    }
}