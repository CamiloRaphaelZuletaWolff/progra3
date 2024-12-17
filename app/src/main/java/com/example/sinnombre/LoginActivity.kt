package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sinnombre.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Encuentra el TextView "Tengo una cuenta" por su ID
        val tvTengoUnaCuenta = findViewById<TextView>(R.id.texto_tengo_una_cuenta)

        // Configura el listener para cambiar de actividad
        tvTengoUnaCuenta.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)}


        // Encuentra el TextView "Tengo una cuenta" por su ID
        val btnRegistrar = findViewById<Button>(R.id.botonRegistrar)

        // Configura el listener para cambiar de actividad
        btnRegistrar.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }
    }
}
