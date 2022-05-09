package com.auliarifqi.registerloginapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Usuario(
    var bitacora: List<Bitacora>? = null,
    var ciclo_escolar: String? = null,
    var email: String? = null,
    var first_name: String? = null,
    var grado: Long? = null,
    var grupo: String? = null,
    var last_name: String? = null,
    var matricula: Long? = null,
    var pagos: List<Pago>? = null,

)
