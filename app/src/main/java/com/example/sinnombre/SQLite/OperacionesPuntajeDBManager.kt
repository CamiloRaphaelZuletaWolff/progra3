package com.example.sinnombre.SQLite
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sinnombre.PuntajeActivity

class OperacionesPuntajeDBManager(context: Context) {

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

    private val dbHelper: DatabaseHelper = DatabaseHelper(context)

    fun actualizarPuntaje(actividad: PuntajeActivity): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {

        }

        val newRowId = db.insert(TABLE_PUNTAJE, null, values)
        return newRowId != -1L
    }

    private class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            val SQL_CREATE_ACTIVIDAD_TABLE = """
                CREATE TABLE $TABLE_PUNTAJE(
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_TIEMPO_TOTAL_JUGADO TEXT NOT NULL,
                    $COLUMN_TOTAL_ACIERTOS TEXT NOT NULL,
                    $COLUMN_TOTAL_INCORRECTOS TEXT NOT NULL,
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