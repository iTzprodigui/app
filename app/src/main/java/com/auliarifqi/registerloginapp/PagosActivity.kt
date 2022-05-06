package com.auliarifqi.registerloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auliarifqi.registerloginapp.PagosAdapter
import com.auliarifqi.registerloginapp.R

class PagosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_pagos)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPagos)
        val adapter = PagosAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}