package com.example.sinnombre.SQLite
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OperacionesPartidaDBManager(context: Context) {

    private val dbHelper: DatabaseHelper = DatabaseHelper(context)

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Recuerdin.db"

        private const val TABLE_PARTIDA = "Partida"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_NIVEL = "nivel"
        private const val COLUMN_TAMANO_MATRIZ = "tamanoMatriz"
        private const val COLUMN_ACIERTOS = "aciertos"
        private const val COLUMN_INCORRECTOS = "incorrectos"
        private const val COLUMN_REINICIOS = "reincicios"
        private const val COLUMN_TIEMPO_ESTABLECIDO = "tiempoEstablecido"
        private const val COLUMN_TIEMPO_PARTIDA = "tiempoPartida"
        private const val COLUMN_CARTAS_TRAMPA = "cartasTrampa"
        private const val COLUMN_ESTADO_NIVEL = "estadoNivel"
    }

    fun crearPartida(partida: JuegoActivity): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {

        }

        val newRowId = db.insert(TABLE_PARTIDA, null, values)
        return newRowId != -1L
    }

    private class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            val SQL_CREATE_ACTIVIDAD_TABLE = """
                CREATE TABLE $TABLE_PARTIDA (
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_NIVEL TEXT NOT NULL,
                    $COLUMN_TAMANO_MATRIZ TEXT,
                    $COLUMN_ACIERTOS TEXT NOT NULL,
                    $COLUMN_INCORRECTOS TEXT NOT NULL,
                    $COLUMN_REINICIOS TEXT NOT NULL,
                    $COLUMN_TIEMPO_ESTABLECIDO
                );
            """.trimIndent()

            db.execSQL(SQL_CREATE_ACTIVIDAD_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_PARTIDA")
            onCreate(db)
        }
    }
}