package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityIniciosesionBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class IniciarSesionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIniciosesionBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.textoNoTengoCuenta.setOnClickListener{
            val intent = Intent(this, CrearCuentaActivity::class.java)
            startActivity(intent)
        }

        binding.botonIniciarSesion.setOnClickListener {
            iniciarSesion(
                binding.editTextCorreo.text.toString(),
                binding.editTextContrasena.text.toString()
            )
        }
    }

    fun iniciarSesion(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser
                    val intent = Intent(this, PantallaDeInicioActivity::class.java)
                    startActivity(intent)

                } else {
                    println(email)
                    println(password)
                }
            }
    }
}