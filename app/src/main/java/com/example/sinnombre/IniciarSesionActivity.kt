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
//        val layout = findViewById<ConstraintLayout>(R.id.iniciar_sesion)
//
//        // Inicializar el GestureDetector
//        gestureDetector = GestureDetector(this, SwipeGestureListener())
//
//        // Configurar el OnTouchListener en tu layout principal
//        layout.setOnTouchListener { _, event ->
//            gestureDetector.onTouchEvent(event)
//            true



//    inner class SwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
//
//        private val SWIPE_THRESHOLD = 100      // Distancia mínima para considerar un swipe
//        private val SWIPE_VELOCITY_THRESHOLD = 100  // Velocidad mínima para el swipe
//
//        override fun onFling(
//            e1: MotionEvent?,
//            e2: MotionEvent,
//            velocityX: Float,
//            velocityY: Float
//        ): Boolean {
//            if (e1 != null && e2 != null) {
//                val diffX = e2.x - e1.x
//                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
//                    if (diffX > 0) {
//
//                        onSwipeRight()
//                    } else {
//
//                        onSwipeLeft()
//                    }
//                    return true
//                }
//            }
//            return false
//        }
//    }
//
//    private fun onSwipeRight() {
//        Toast.makeText(this, "Deslizado hacia la derecha", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun onSwipeLeft() {
//        Toast.makeText(this, "Deslizado hacia la izquierda", Toast.LENGTH_SHORT).show()
//    }
//}