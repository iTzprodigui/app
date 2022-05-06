package com.auliarifqi.registerloginapp

class Bitacora {
    var fecha:String? = null
    var maestra:String? = null
    var mensaje:String? = null

    constructor(fecha:String?,maestra: String?, mensaje: String?) {
        this.fecha = fecha
        this.maestra = maestra
        this.mensaje = mensaje
    }
}