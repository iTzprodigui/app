package com.auliarifqi.registerloginapp

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Pago(
    var concepto: String? = null,
    var fecha: String? = null,
    var importe: String? = null
)
