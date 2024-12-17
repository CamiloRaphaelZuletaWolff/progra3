package com.example.sinnombre
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar el VideoView
        val videoView = findViewById<VideoView>(R.id.videoView)

        val videoUri = Uri.parse("android.resource://${packageName}/raw/splash")
        videoView.setVideoURI(videoUri)

        // Agregar controles al video (opcional)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Configurar el VideoView para que reproduzca automáticamente
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // (Opcional) Hace que el video se repita automáticamente
            videoView.start() // Inicia la reproducción automáticamente
        }
    }
}