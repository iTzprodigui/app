package com.auliarifqi.registerloginapp

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Bitacora(
    var fecha:String? = null,
    var maestra:String? = null,
    var mensaje:String? = null
)