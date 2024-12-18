package com.example.sinnombre.SQLite
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sinnombre.DataClasses.PuntajeDB

class OperacionesPuntajeDBManager(context: Context) {

    private val dbHelper: DatabaseHelper = DatabaseHelper(context)

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Recuerdin.db"

        private const val TABLE_PUNTAJE = "Puntaje"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_TIEMPO_TOTAL_JUGADO = "tiempoTotalJugado"
        private const val COLUMN_TOTAL_ACIERTOS = "totalAciertos"
        private const val COLUMN_TOTAL_INCORRECTOS = "totalIncorrectos"
        private const val COLUMN_TOTAL_REINICIOS = "totalReinicios"
    }

    fun crearPuntaje(puntaje: PuntajeDB): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TIEMPO_TOTAL_JUGADO, puntaje.tiempoTotalJugado)
            put(COLUMN_TOTAL_ACIERTOS, puntaje.totalAciertos)
            put(COLUMN_TOTAL_INCORRECTOS, puntaje.totalIncorrectos)
            put(COLUMN_TOTAL_REINICIOS, puntaje.totalReinicios)
        }

        val newRowId = db.insert(TABLE_PUNTAJE, null, values)
        db.close()
        return newRowId != -1L
    }


    fun actualizarTiempoTotalJugado(partidaManager: OperacionesPartidaDBManager): Boolean {
        val db = dbHelper.writableDatabase

        val tiempoTotalJugado = partidaManager.obtenerTiempoTotal()

        val values = ContentValues().apply {
            put(COLUMN_TIEMPO_TOTAL_JUGADO, tiempoTotalJugado)
        }

        val rowsUpdated = db.update(TABLE_PUNTAJE, values, null, null)
        db.close()

        return rowsUpdated > 0
    }

    fun actualizarTotalAciertos(partidaManager: OperacionesPartidaDBManager): Boolean {
        val db = dbHelper.writableDatabase

        val totalAciertos = partidaManager.obtenerTotalAciertos()

        val values = ContentValues().apply {
            put(COLUMN_TOTAL_ACIERTOS, totalAciertos)
        }

        val rowsUpdated = db.update(TABLE_PUNTAJE, values, null, null)
        db.close()

        return rowsUpdated > 0
    }

    fun actualizarTotalIncorrectos(partidaManager: OperacionesPartidaDBManager): Boolean {
        val db = dbHelper.writableDatabase

        val totalIncorrectos = partidaManager.obtenerTotalIncorrectos()

        val values = ContentValues().apply {
            put(COLUMN_TOTAL_INCORRECTOS, totalIncorrectos)
        }

        val rowsUpdated = db.update(TABLE_PUNTAJE, values, null, null)
        db.close()

        return rowsUpdated > 0
    }

    fun actualizarTotalReinicios(partidaManager: OperacionesPartidaDBManager): Boolean {
        val db = dbHelper.writableDatabase

        val totalReinicios = partidaManager.obtenerTotalReinicios()

        val values = ContentValues().apply {
            put(COLUMN_TOTAL_REINICIOS, totalReinicios)
        }

        val rowsUpdated = db.update(TABLE_PUNTAJE, values, null, null)
        db.close()

        return rowsUpdated > 0
    }


    private class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            val SQL_CREATE_ACTIVIDAD_TABLE = """
                CREATE TABLE $TABLE_PUNTAJE(
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_TIEMPO_TOTAL_JUGADO TEXT NOT NULL,
                    $COLUMN_TOTAL_ACIERTOS TEXT NOT NULL,
                    $COLUMN_TOTAL_INCORRECTOS TEXT,
                    $COLUMN_TOTAL_REINICIOS TEXT
                );
            """.trimIndent()

            db.execSQL(SQL_CREATE_ACTIVIDAD_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_PUNTAJE")
            onCreate(db)
        }
    }
}