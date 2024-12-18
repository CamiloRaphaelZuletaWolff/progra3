package com.example.sinnombre

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = binding.videoView

        val videoUri = Uri.parse("android.resource://${packageName}/raw/gif")
        videoView.setVideoURI(videoUri)


        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)


        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = false
            videoView.start()

        }
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
