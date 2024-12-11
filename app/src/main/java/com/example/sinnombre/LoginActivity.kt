package com.example.sinnombre

import android.os.Bundle
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
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth

        binding.buttonLogin.setOnClickListener {
            loginUsuario()
        }
    }

    fun loginUsuario(){
        val password: String = binding.editPassword.text.toString()
        val email: String = binding.editCorreo.text.toString()
        auth.signInWithEmailAndPassword("email","password").addOnCompleteListener(this) {
            respuesta -> if (respuesta.isSuccessful){

            } else {

            }
        }
    }
}