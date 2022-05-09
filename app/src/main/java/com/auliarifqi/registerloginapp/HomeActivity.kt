package com.auliarifqi.registerloginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var mUserRef: FirebaseDatabase
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()
        mUserRef = FirebaseDatabase.getInstance()
        var bitacoralist = ArrayList<Bitacora>()
        var pagoslist = ArrayList<Pago>()

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

                    // Get Data!
                    usuario = dataSnapshot.getValue(Usuario::class.java)!!

                    for(index in 0 until usuario?.bitacora!!.size) {
                        bitacoralist.add(
                            Bitacora(
                                usuario?.bitacora?.get(index)?.fecha.toString() as String?,
                                usuario?.bitacora?.get(index)?.maestra.toString() as String?,
                                usuario?.bitacora?.get(index)?.mensaje.toString() as String?
                            )
                        )
                    }

                    for(index in 0 until usuario?.pagos!!.size) {
                        pagoslist.add(
                            Pago(
                                usuario?.pagos?.get(index)?.concepto.toString() as String?,
                                usuario?.pagos?.get(index)?.fecha.toString() as String?,
                                usuario?.pagos?.get(index)?.importe.toString() as String?,
                            )
                        )
                    }

                    //    Log.d("HomeActivity", usuarios?.bitacora?.get(index)?.maestra.toString() + usuarios?.bitacora?.get(index)?.fecha.toString() + usuarios?.bitacora?.get(index)?.mensaje.toString())
                    //}

//                    if (usuarios != null) {
//                        Log.d("HomeActivity", usuarios.toString())
//                    }

                    //Set Data
                    Picasso.get().load(usuario.imagen.toString())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(profile_image)

                    tvNama2.setText(usuario.first_name.toString())
                }
                override fun onCancelled(databaseError: DatabaseError) {}
            }
            ref.addListenerForSingleValueEvent(menuListener)
        }

        textAlumno.setOnClickListener {
            val intent = Intent(this,DatosActivity::class.java)
            intent.putExtra("usuario",usuario)

            startActivity(intent)
        }

        textPagos.setOnClickListener {
            var intent = Intent(this,PagosActivity::class.java)
            intent.putExtra("listP",pagoslist)

            startActivity(intent)
        }

        textBitacora.setOnClickListener {

            val intent = Intent(this,BitacoraActivity::class.java)
            intent.putExtra("list", bitacoralist)
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