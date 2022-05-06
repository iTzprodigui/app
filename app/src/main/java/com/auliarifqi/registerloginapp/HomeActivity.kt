package com.auliarifqi.registerloginapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var mUserRef: FirebaseDatabase
    private lateinit var nombre :String
    private lateinit var apellido :String
    private lateinit var grado :String
    private lateinit var grupo :String
    private lateinit var matricula :String
    private lateinit var ciclo_escolar :String
    private lateinit var maestra: String
    private lateinit var fecha: String
    private lateinit var mensaje: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()
        mUserRef = FirebaseDatabase.getInstance()
        var bitacoralist = ArrayList<Bitacora>()

        tvLogout.setOnClickListener{
            auth.signOut()
            sendToStart()
        }

        if (auth.getCurrentUser() != null)
        {
            val ref = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)
            ref.keepSynced(true)
            val menuListener = object: ValueEventListener{
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    //get data
                    nombre = Objects.requireNonNull(dataSnapshot.child("first_name").value).toString()
                    apellido = Objects.requireNonNull(dataSnapshot.child("last_name").value).toString()
                    grado = Objects.requireNonNull(dataSnapshot.child("grado").value).toString()
                    grupo = Objects.requireNonNull(dataSnapshot.child("grupo").value).toString()
                    matricula = Objects.requireNonNull(dataSnapshot.child("matricula").value).toString()
                    ciclo_escolar = Objects.requireNonNull(dataSnapshot.child("ciclo_escolar").value).toString()
                    bitacoralist.add( Bitacora(
                            Objects.requireNonNull(dataSnapshot.child("bitacora").child("Fecha").value).toString() as String?,
                            Objects.requireNonNull(dataSnapshot.child("bitacora").child("Maestra").value).toString() as String?,
                            Objects.requireNonNull(dataSnapshot.child("bitacora").child("Mensaje").value).toString() as String?
                        )
                    )

                    //bitacora = (Objects.requireNonNull(dataSnapshot.child("bitacora").value) as ArrayList<String>?)!!
                    //set data
                    tvNama2.setText(nombre)
//                    tvEmail2.setText(email)
//                    tvPhone2.setText(phone)
                }
                override fun onCancelled(databaseError: DatabaseError) {}
            }
            ref.addListenerForSingleValueEvent(menuListener)
        }

        textAlumno.setOnClickListener {
            val intent = Intent(this,DatosActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("apellido", apellido)
            intent.putExtra("grado", grado)
            intent.putExtra("grupo", grupo)
            intent.putExtra("matricula", matricula)
            intent.putExtra("ciclo_escolar", ciclo_escolar)

            startActivity(intent)
        }

        textPagos.setOnClickListener {
            startActivity(Intent(this,PagosActivity::class.java))
        }

        textBitacora.setOnClickListener {
            val intent = Intent(this,BitacoraActivity::class.java)
            intent.putExtra("list", bitacoralist)
////            intent.putExtra("maestra", maestra)
////            intent.putExtra("fecha", fecha)
////            intent.putExtra("mensaje", mensaje)
//            //BitacoraActivity
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser == null) {
            sendToStart()
        }
    }

    private fun sendToStart() {
        Intent(this, LoginActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

}