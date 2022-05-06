package com.auliarifqi.registerloginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BitacoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_bitacora)

        val list =  intent.getSerializableExtra("list") as ArrayList<Bitacora>
//        val maestra =  intent.getStringExtra("maestra")
//        val fecha =  intent.getStringExtra("fecha")
//        val mensaje =  intent.getStringExtra("mensaje")
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewBitacora)

        val adapter = BitacoraAdapter(list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}