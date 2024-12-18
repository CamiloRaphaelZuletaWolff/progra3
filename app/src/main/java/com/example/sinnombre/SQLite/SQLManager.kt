package com.example.sinnombre.SQLite
import android.content.Context
import com.example.sinnombre.DataClasses.PartidaDB
import com.example.sinnombre.DataClasses.PuntajeDB

class SQLManager(context: Context) {

    private val partidaDBManager = OperacionesPartidaDBManager(context)
    private val puntajeDBManager = OperacionesPuntajeDBManager(context)

    fun crearPartida(partida: PartidaDB): Long {
        return partidaDBManager.crearPartida(partida)
    }

    fun guardarPartida(partida: PartidaDB): Boolean {
        return partidaDBManager.guardarPartida(partida)
    }

    fun crearPuntaje(puntaje: PuntajeDB): Boolean {
        return puntajeDBManager.crearPuntaje(puntaje)
    }

    fun actualizarTiempoTotalJugado(): Boolean {
        return puntajeDBManager.actualizarTiempoTotalJugado(partidaDBManager)
    }

    fun actualizarTotalAciertos(): Boolean {
        return puntajeDBManager.actualizarTotalAciertos(partidaDBManager)
    }

    fun actualizarTotalIncorrectos(): Boolean {
        return puntajeDBManager.actualizarTotalIncorrectos(partidaDBManager)
    }

    fun actualizarTotalReinicios(): Boolean {
        return puntajeDBManager.actualizarTotalReinicios(partidaDBManager)
    }

    fun obtenerTiempoTotal(): String {
        return partidaDBManager.obtenerTiempoTotal()
    }

    fun obtenerTotalAciertos(): Int {
        return partidaDBManager.obtenerTotalAciertos()
    }

    fun obtenerTotalIncorrectos(): Int {
        return partidaDBManager.obtenerTotalIncorrectos()
    }

    fun obtenerTotalReinicios(): Int {
        return partidaDBManager.obtenerTotalReinicios()
    }
}