package com.auliarifqi.registerloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos.*

class DatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        val usuario = intent.getSerializableExtra("usuario") as Usuario

        txt_nombre.setText(usuario.first_name.toString() +' '+ usuario.last_name.toString())
        txt_grado.setText(usuario.grado.toString())
        txt_grupo.setText(usuario.grupo.toString())
        txt_matricula.setText(usuario.matricula.toString())
        txt_ciclo_escolar.setText(usuario.ciclo_escolar.toString())

//        textView.setText(name)
//        textView2.setText(lastName)

    }
}