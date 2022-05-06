package com.auliarifqi.registerloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos.*

class DatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        val nombre =  intent.getStringExtra("nombre")
        val apellido =  intent.getStringExtra("apellido")
        val grado =  intent.getStringExtra("grado")
        val grupo =  intent.getStringExtra("grupo")
        val matricula =  intent.getStringExtra("matricula")
        val ciclo_escolar =  intent.getStringExtra("ciclo_escolar")

        txt_nombre.setText(nombre+' '+apellido)
        txt_grado.setText(grado)
        txt_grupo.setText(grupo)
        txt_matricula.setText(matricula)
        txt_ciclo_escolar.setText(ciclo_escolar)

//        textView.setText(name)
//        textView2.setText(lastName)

    }
}