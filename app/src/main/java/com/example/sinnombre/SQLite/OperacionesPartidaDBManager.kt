package com.example.sinnombre.SQLite
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sinnombre.DataClasses.PartidaDB

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

    fun crearPartida(partida: PartidaDB): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NIVEL, partida.nivel)
            put(COLUMN_TAMANO_MATRIZ, partida.tamanoMatriz)
            put(COLUMN_TIEMPO_ESTABLECIDO, partida.tiempoEstablecido)
        }

        val newRowId = db.insert(TABLE_PARTIDA, null, values)
        db.close()
        return newRowId
    }

    fun guardarPartida(
        id: Long,
        aciertos: Int,
        incorrectos: Int,
        reinicios: Int,
        tiempoPartida: String,
        cartasTrampa: Int,
        estadoNivel: Boolean
    ): Boolean {
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_PARTIDA WHERE $COLUMN_ID = ?", arrayOf(id.toString()))
        var partidaExistente: ContentValues? = null

        if (cursor.moveToFirst()) {
            partidaExistente = ContentValues().apply {
                put(COLUMN_NIVEL, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NIVEL)))
                put(COLUMN_TAMANO_MATRIZ, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TAMANO_MATRIZ)))
                put(COLUMN_TIEMPO_ESTABLECIDO, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIEMPO_ESTABLECIDO)))
            }
        }
        cursor.close()

        if (partidaExistente == null) {
            db.close()
            return false
        }

        partidaExistente.apply {
            put(COLUMN_ACIERTOS, aciertos)
            put(COLUMN_INCORRECTOS, incorrectos)
            put(COLUMN_REINICIOS, reinicios)
            put(COLUMN_TIEMPO_PARTIDA, tiempoPartida)
            put(COLUMN_CARTAS_TRAMPA, cartasTrampa)
            put(COLUMN_ESTADO_NIVEL, estadoNivel)
        }

        val rowsAffected = db.update(
            TABLE_PARTIDA,
            partidaExistente,
            "$COLUMN_ID = ?",
            arrayOf(id.toString())
        )

        db.close()
        return rowsAffected > 0
    }

    private class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            val SQL_CREATE_ACTIVIDAD_TABLE = """
                CREATE TABLE $TABLE_PARTIDA (
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_NIVEL TEXT NOT NULL,
                    $COLUMN_TAMANO_MATRIZ TEXT NOT NULL,
                    $COLUMN_ACIERTOS INTEGER NOT NULL,
                    $COLUMN_INCORRECTOS INTEGER,
                    $COLUMN_REINICIOS INTEGER,
                    $COLUMN_TIEMPO_ESTABLECIDO TEXT NOT NULL,
                    $COLUMN_TIEMPO_PARTIDA TEXT NOT NULL,
                    $COLUMN_CARTAS_TRAMPA INTEGER,
                    $COLUMN_ESTADO_NIVEL BOOLEAN NOT NULL
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