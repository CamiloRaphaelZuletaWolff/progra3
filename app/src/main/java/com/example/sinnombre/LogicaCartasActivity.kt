package com.example.sinnombre


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sinnombre.databinding.ActivityLogicaCartasBinding

class LogicaCartasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogicaCartasBinding
    var contador : Int = 0
    var filaActual : Int  = 0
    var columnaActual : Int = 0
    var mapa : Array<IntArray> = arrayOf()
    val vistaAnterior : View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogicaCartasBinding.inflate(layoutInflater)
        val view1 = binding.root
        setContentView(view1)
        mapa = crearMapa(2,3)
        val botones = listOf(binding.Pos00,binding.Pos01,binding.Pos02,binding.Pos10,binding.Pos11,binding.Pos12)
        val listener = View.OnClickListener { view ->
            val fila = obtenerFila(resources.getResourceEntryName(view.id))
            val columna =obtenerColumna(resources.getResourceEntryName(view.id))
            if(contador%2==0){
                view.setBackgroundColor(Color.RED)
                filaActual = fila
                columnaActual = columna
                contador++
            }else {
                contador++
                view.setBackgroundColor(Color.GREEN)
                if (mapa[filaActual][columnaActual]==mapa[fila][columna]){
                    //Son la misma carta
                    view.setBackgroundColor(Color.GREEN)
                }else{
                    //Disenio previo de la cartita
                    view.setBackgroundColor(Color.BLACK)

                }
            }
        }
        botones.forEach { imageButton ->
            imageButton.setOnClickListener(listener)
        }}



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
