package com.example.sinnombre

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sinnombre.dataClasses.Carta
import com.example.sinnombre.databinding.ItemCartasBinding

class JuegoCartasRecyclerAdapter :
    RecyclerView.Adapter<JuegoCartasRecyclerAdapter.ViewHolder>() {

    private val listaDatos = mutableListOf<Carta>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemCartasBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ViewHolder(private val binding: ItemCartasBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: Carta) {
        }
    }

    fun addDataToList(list: List<Carta>) {
        listaDatos.clear()
        listaDatos.addAll(list)
    }

}