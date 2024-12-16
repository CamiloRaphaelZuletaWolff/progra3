package com.example.sinnombre

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sinnombre.dataClasses.Carta
import com.example.sinnombre.databinding.ActivityJuegoCartasBinding


class JuegoCartas : AppCompatActivity() {

    companion object {
        val ID_PASO_DIFICULTAD = "DIFICULTAD"

    }


    private lateinit var binding: ActivityJuegoCartasBinding
    private val recyclerJuegoCartasAdapter by lazy {JuegoCartasRecyclerAdapter()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJuegoCartasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpRecyclerView()
    }
    fun setUpRecyclerView(){
        val dificultad = intent.getIntExtra(ID_PASO_DIFICULTAD,0)
        val listaDatos = crearLista(dificultad)

        recyclerJuegoCartasAdapter.addDataToList(listaDatos)

        binding.recyclerCartas.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerJuegoCartasAdapter
        }
    }

    fun crearLista(dificultad: Int): MutableList<Carta> {
        var listita : MutableList<Carta> = mutableListOf()
        var contador = dificultad
        val limite = (dificultad + 3) / 4
        for (i in 0 until limite){
            var aux : String = "" + i
            for (j in 0..3){
                if (contador!=0) {
                    val pos: String = aux + j
                    listita.add(Carta(pos, false, 0))
                    contador--
                }
            }
        }
        return listita
    }
}