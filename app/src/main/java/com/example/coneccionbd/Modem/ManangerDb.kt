package com.example.coneccionbd.Modem

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

data class ManangerDb(val context: Context) {

    lateinit var bd: SQLiteDatabase

    private val bdHelper = BdHelper(context)

    // Método para abrir la base de datos en modo escritura
    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    // Método para abrir la base de datos en modo lectura
    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    // Método para cerrar la base de datos
    fun closeBd() {
        bd.close()
    }

    // Método para insertar datos en la tabla "ciudad"
    fun inserData(code: Int, ciudad: String, codep: Int): Long {
        openBdWr() // Abrir la base de datos en modo escritura

        val contenedor = ContentValues().apply {
            put("cod", code)
            put("nombre", ciudad)
            put("coddep", codep)
        }

        val result = bd.insert("ciudad", null, contenedor)
        closeBd() // Cerrar la base de datos

        return result
    }

    // Método para obtener datos de la tabla "ciudad"
    fun getData(): ArrayList<Ciudad> {
        openBdRd() // Abrir la base de datos en modo lectura
        val ciudadlist = ArrayList<Ciudad>()

        val cursor: Cursor? = bd.rawQuery(Constantes.TRAER, null)
        if (cursor?.moveToFirst() == true) {
            do {
                val idCiudad = cursor.getColumnIndex("cod")
                val nombreCiudad = cursor.getColumnIndex("nombre")
                val codepCiudad = cursor.getColumnIndex("coddep")
                val id = cursor.getString(idCiudad) ?: ""
                val nombre = cursor.getString(nombreCiudad) ?: ""
                val cod = cursor.getString(codepCiudad) ?: ""

                val ciudad = Ciudad(id.toInt(), nombre, cod.toInt())
                ciudadlist.add(ciudad)
            } while (cursor.moveToNext())
        }

        cursor?.close() // Cerrar el cursor
        closeBd() // Cerrar la base de datos

        return ciudadlist
    }
}