package com.example.coneccionbd.Modem

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

data class ManangerDb(val context: Context) {

    lateinit var bd: SQLiteDatabase

    val bdHelper = BdHelper(context)//llamado a mi conexion

    //metodo para abrir bd en modo escritura
    fun openBdWr() {

        bd = bdHelper.writableDatabase
    }

    //abre base de datos modo lectura


    fun inserData(code: Int, ciudad: String, codep: Int): Long {

        openBdWr() // abrir bd en modo escritura

        //creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("cod", code)
        contenedor.put("nombre", ciudad)
        contenedor.put(
            "coddep", codep
        )
        //llamo metodo insert

        val resul = bd.insert("ciudad", null, contenedor)
        return resul


    }

    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    fun getData(): ArrayList<Ciudad> {
        // Llamar a una función para abrir una base de datos o realizar alguna operación
        openBdRd()
        val ciudadlist = ArrayList<Ciudad>()


        val cursor = bd.rawQuery(Constantes.TRAER, null)
        if (cursor.moveToFirst()) {

            do {
                val idCiudad = cursor.getColumnIndex("cod")
                val nombreCiudad = cursor.getColumnIndex("nombre")
                val codepCiudad = cursor.getColumnIndex("codep")

                val ciudad= Ciudad(idCiudad,nombreCiudad.toString(),codepCiudad)//PASO los valores obtenidos del cursor a mi ibjeto ciudad

                ciudadlist.add(ciudad)// agrego mi objeto ciudad a mi arraylist


            } while (cursor.moveToNext())// el ciclo se hace hasta que el cursor se mueva a la siguiente posicion
        }

        return  ciudadlist

    }


    //fun  inserData2():Long{

      //  openBdWr() // abrir bd en modo escritura

        //creo contenedor de valores para insertar data
       // val  contenedor =ContentValues()
       // contenedor.put("cod",1)
       // contenedor.put("nombre","cali")
       // contenedor.put("coddep",25)
        //llamo metodo insert

        //val resul = bd.insert("ciudad",null,contenedor)
       // return  resul



   // }
}