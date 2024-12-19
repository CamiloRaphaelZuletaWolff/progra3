package com.example.sinnombre

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sinnombre.databinding.ActivityPantallaJuegoBinding

class PantallaDeJuegoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaJuegoBinding
    var contador: Int = 0
    var filaPrevia: Int = 0
    var columnaPrevia: Int = 0
    var mapa: Array<IntArray> = arrayOf()
    var vistaAnterior: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaJuegoBinding.inflate(layoutInflater)
        val view1 = binding.root
        val cantidadFilas = 3
        val cantidadColumnas = 2
        setContentView(view1)
        mapa = crearMapa(cantidadFilas, cantidadColumnas)
        val visitados = Array(cantidadFilas) { BooleanArray(cantidadColumnas) }
        val botones = listOf(
            binding.Pos00,
            binding.Pos01,
            binding.Pos02,
            binding.Pos03,
            binding.Pos04,
            binding.Pos10,
            binding.Pos11,
            binding.Pos12,
            binding.Pos13,
            binding.Pos14,
            binding.Pos20,
            binding.Pos21,
            binding.Pos22,
            binding.Pos23,
            binding.Pos24,
            binding.Pos30,
            binding.Pos31,
            binding.Pos32,
            binding.Pos33,
            binding.Pos34,
            binding.Pos40,
            binding.Pos41,
            binding.Pos42,
            binding.Pos43,
            binding.Pos44,
            binding.Pos50,
            binding.Pos51,
            binding.Pos52,
            binding.Pos53,
            binding.Pos54,
            binding.Pos60,
            binding.Pos61,
            binding.Pos62,
            binding.Pos63,
            binding.Pos64,
            binding.Pos70,
            binding.Pos71,
            binding.Pos72,
            binding.Pos73,
            binding.Pos74
        )
        organizarImageButtons(cantidadFilas, cantidadColumnas, botones)
        val listener = View.OnClickListener { view ->
            val fila = obtenerFila(resources.getResourceEntryName(view.id))
            val columna = obtenerColumna(resources.getResourceEntryName(view.id))
            if (contador % 2 == 0) {
                if (!visitados[fila][columna]) {
                    view.setBackgroundColor(Color.RED)
                    filaPrevia = fila
                    columnaPrevia = columna
                    vistaAnterior = view
                    contador++
                    visitados[fila][columna] = true
                }
            } else {
                if (!visitados[fila][columna]) {
                    if (mapa[filaPrevia][columnaPrevia] == mapa[fila][columna]) {
                        //Son la misma carta
                        view.setBackgroundColor(Color.GREEN)
                        vistaAnterior?.setBackgroundColor(Color.GREEN)
                        contador++
                        visitados[fila][columna] = true
                    } else {
                        //Disenio previo de la cartita
                        view.setBackgroundColor(Color.BLACK)
                        vistaAnterior?.setBackgroundColor(Color.BLACK)
                        contador++
                        visitados[filaPrevia][columnaPrevia] = false

                    }
                }
            }
        }
        botones.forEach { imageButton ->
            imageButton.setOnClickListener(listener)
        }
    }

    private fun organizarImageButtons(filas: Int, columnas: Int, botones: List<View>) {
        val botonesUsar = reorganizarBotones(filas, columnas, botones)
        val gridLayout = GridLayout(this).apply {
            rowCount = filas
            columnCount = columnas
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                0
            ).apply {
                topToBottom = binding.Recuerdin.id
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            }
        }

        botonesUsar.forEach { view ->
            val filaBoton = obtenerFila(resources.getResourceEntryName(view.id))
            val columnaBoton = obtenerColumna(resources.getResourceEntryName(view.id))
            (view.parent as? ConstraintLayout)?.removeView(view)
            if (filaBoton < filas && columnaBoton < columnas) {
                val params = GridLayout.LayoutParams().apply {
                    width = 0
                    height = 0
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                }
                view.layoutParams = params

                // Añadir el botón al GridLayout
                gridLayout.addView(view)
            }
        }

        val constraintLayout = binding.root as ConstraintLayout
        constraintLayout.addView(gridLayout)
    }

    private fun reorganizarBotones(filas: Int, columnas: Int, botones: List<View>): List<View> {
        var listita = mutableListOf<View>()
        for (i in 0 until 40){
            val boton = botones[i]
            val filaBoton = obtenerFila(resources.getResourceEntryName(boton.id))
            val columnaBoton = obtenerColumna(resources.getResourceEntryName(boton.id))
            if (filaBoton <= filas && columnaBoton <= columnas) {
                listita.add(boton)
            }



            }
        return listita

    }


    fun obtenerFila(id: String): Int {
        return id[id.length - 2].toString().toInt()
    }

    fun obtenerColumna(id: String): Int {
        return id.last().toString().toInt()
    }

    fun crearMapa(filas: Int, columnas: Int): Array<IntArray> {
        val maxNumero = (filas * columnas) / 2
        val numeros = mutableListOf<Int>()
        for (num in 1..maxNumero) {
            numeros.add(num)
            numeros.add(num)
        }
        numeros.shuffle()
        val matriz = Array(filas) { IntArray(columnas) }
        var index = 0
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                matriz[i][j] = numeros[index]
                index++
            }
        }
        return matriz
    }

}
