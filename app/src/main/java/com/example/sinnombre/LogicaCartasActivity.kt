package com.example.sinnombre


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sinnombre.databinding.ActivityLogicaCartasBinding

class LogicaCartasActivity : AppCompatActivity() {

    private lateinit var b: ActivityLogicaCartasBinding
    var contador : Int = 0
    var filaPrevia : Int  = 0
    var columnaPrevia : Int = 0
    var mapa : Array<IntArray> = arrayOf()
    var vistaAnterior : View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityLogicaCartasBinding.inflate(layoutInflater)
        val view1 = b.root
        val cantidadFilas = 3
        val cantidadColumnas = 2
        setContentView(view1)
        mapa = crearMapa(cantidadFilas,cantidadColumnas)
        val visitados = Array(cantidadFilas) { BooleanArray(cantidadColumnas) }
        val botones = listOf(
            b.Pos00,b.Pos01,b.Pos02,b.Pos03,b.Pos04
            ,b.Pos10,b.Pos11,b.Pos12,b.Pos13,b.Pos14
            ,b.Pos20,b.Pos21,b.Pos22,b.Pos23,b.Pos24
            ,b.Pos30,b.Pos31,b.Pos32,b.Pos33,b.Pos34
            ,b.Pos40,b.Pos41,b.Pos42,b.Pos43,b.Pos44
            ,b.Pos50,b.Pos51,b.Pos52,b.Pos53,b.Pos54
            ,b.Pos60,b.Pos61,b.Pos62,b.Pos63,b.Pos64
            ,b.Pos70,b.Pos71,b.Pos72,b.Pos73,b.Pos74
            )
        organizarImageButtons(cantidadFilas,cantidadColumnas,botones)
        val listener = View.OnClickListener { view ->
            val fila = obtenerFila(resources.getResourceEntryName(view.id))
            val columna =obtenerColumna(resources.getResourceEntryName(view.id))
            if(contador%2==0){
                if (!visitados[fila][columna]){
                    view.setBackgroundColor(Color.RED)
                    filaPrevia = fila
                    columnaPrevia = columna
                    vistaAnterior = view
                    contador++
                    visitados[fila][columna] = true
                }
            }else {
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
        }}








    private fun organizarImageButtons(filas: Int, columnas: Int, botones: List<View>) {
        val botonesUsar = reorganizarBotones(filas,columnas,botones)
        val gridLayout = GridLayout(this).apply {
            rowCount = filas
            columnCount = columnas
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                0
            ).apply {
                topToBottom = b.Recuerdin.id
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            }
        }

        botonesUsar.forEach { view ->
            val filaBoton = obtenerFila(resources.getResourceEntryName(view.id))
            val columnaBoton =obtenerColumna(resources.getResourceEntryName(view.id))
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

        val constraintLayout = b.root as ConstraintLayout
        constraintLayout.addView(gridLayout)
    }

    private fun reorganizarBotones(filas: Int, columnas: Int, matrizCompleta: List<View>): List<View> {
        val submatriz = mutableListOf<View>() // Lista para almacenar la submatriz
        val totalColumnas = matrizCompleta.size / filas // Calcula las columnas originales de la matriz principal

        for (fila in 0 until filas) {
            for (columna in 0 until columnas) {
                val indice = fila * totalColumnas + columna // Calcula el índice en la lista lineal
                submatriz.add(matrizCompleta[indice]) // Añade el elemento a la lista de la submatriz
            }
        }
        return submatriz
    }

    fun obtenerFila(id : String) : Int {
        return id[id.length - 2].toString().toInt()
    }

    fun obtenerColumna(id : String) : Int {
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
