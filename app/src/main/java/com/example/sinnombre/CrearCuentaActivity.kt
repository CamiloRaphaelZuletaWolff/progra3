package com.example.sinnombre

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityCrearCuentaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CrearCuentaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearCuentaBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.botonRegistrar.setOnClickListener {
            crearCuenta(
                binding.editTextNombreCompleto.text.toString(),
                binding.editTextCorreo.text.toString(),
                binding.editTextNuevaContrasena.text.toString(),
                binding.editTextConfirmarContrasena.text.toString()
            )
        }
        binding.textoTengoUnaCuenta.setOnClickListener {
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }
    }

    fun crearCuenta(
        nombreCompleto: String,
        email: String,
        nuevaContrasena: String,
        confirmarContrasena: String
    ) {
        if (nombreCompleto.isBlank()) {
            Toast.makeText(this, "El nombre completo es obligatorio", Toast.LENGTH_SHORT).show()
            return
        }

        if (email.isBlank()) {
            Toast.makeText(this, "El correo electrónico es obligatorio", Toast.LENGTH_SHORT).show()
            return
        }

        if (nuevaContrasena.length < 5 || nuevaContrasena.length > 10) {
            Toast.makeText(
                this,
                "La contraseña debe tener entre 5 y 10 caracteres",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (nuevaContrasena != confirmarContrasena) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, nuevaContrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, IniciarSesionActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Error al registrar: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
