package com.auliarifqi.registerloginapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PagosAdapter: RecyclerView.Adapter<PagosAdapter.ViewHolder>(){

    val fechas = arrayOf("26/04/2022","26/03/2022","26/02/2022")

    val mensualidades = arrayOf("Mensualidad", "Mensualidad", "Mensualidad")

    val cantidadPago = arrayOf("$1000", "$1000", "$1000")



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemFecha: TextView
        var itemMensualidad: TextView
        var itemCantidadPago: TextView

        init {
            itemFecha = itemView.findViewById(R.id.item_fecha)
            itemMensualidad = itemView.findViewById(R.id.item_mensualidad)
            itemCantidadPago = itemView.findViewById(R.id.item_cantidadPago)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_pagos, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemFecha.text = fechas[i]
        viewHolder.itemMensualidad.text = mensualidades[i]
        viewHolder.itemCantidadPago.text = cantidadPago[i]
    }

    override fun getItemCount(): Int {
        return fechas.size
    }

}