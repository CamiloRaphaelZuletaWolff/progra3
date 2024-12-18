package com.example.sinnombre.DataClasses

data class PuntajeDB(
    val idPuntaje : Int,
    val tiempoTotalJugado : String,
    val totalAciertos : Int,
    val totalIncorrectos : Int,
    val totalReinicios : Int
)