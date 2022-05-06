package com.auliarifqi.registerloginapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BitacoraAdapter(private val bitacoralist: ArrayList<Bitacora>): RecyclerView.Adapter<BitacoraAdapter.ViewHolder>(){

    val maestras = arrayOf("Ana Martinez", "Rosa Mendez", "Samantha Reyes")

    val fechasBitacora = arrayOf("26/04/2022","26/03/2022","26/02/2022")

    val textBitacora = arrayOf("Este es el texto que la profesora escribe como las anotaciones para la bitacora del alumno.",
        "Este es el texto que la profesora escribe como las anotaciones para la bitacora del alumno.",
        "Este es el texto que la profesora escribe como las anotaciones para la bitacora del alumno.")



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemMaestra: TextView
        var itemFechaBitacora: TextView
        var itemTextBitacora: TextView

        init {
            itemMaestra = itemView.findViewById(R.id.item_maestra)
            itemFechaBitacora = itemView.findViewById(R.id.item_fechaBitacora)
            itemTextBitacora = itemView.findViewById(R.id.item_textBitacora)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_bitacora, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {


        viewHolder.itemMaestra.text = bitacoralist[i].maestra.toString()
        viewHolder.itemFechaBitacora.text = bitacoralist[i].fecha.toString()
        viewHolder.itemTextBitacora.text = bitacoralist[i].mensaje.toString()


    }

    override fun getItemCount(): Int {
        return maestras.size
    }

}