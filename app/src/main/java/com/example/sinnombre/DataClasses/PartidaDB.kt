package com.example.sinnombre.DataClasses

data class PartidaDB(
    var idPartida : Int,
    val nivel : Int,
    val tamanoMatriz : String,
    val aciertos : Int,
    val incorrectos : Int,
    val reinicios : Int,
    val tiempoEstablecido : String,
    val tiempoPartida : String,
    val cartasTrampa : String,
    val estadoNivel : Boolean
)