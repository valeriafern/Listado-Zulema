package com.example.coneccionbd.Modem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.coneccionbd.R
import com.example.coneccionbd.databinding.ActivityListarDatosBinding

class listarDatos : AppCompatActivity() {
   // private lateinit var binding: ActivityListarDatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_datos)

        val manager = ManangerDb(this)
        val arrayciudad= manager.getData()

        val listCiudad=findViewById<ListView>(R.id.ListVCiudad)
        val arrayAdapter = ArrayAdapter<Ciudad>(this,android.R.layout.simple_list_item_1,arrayciudad)

        listCiudad.adapter=arrayAdapter
        Toast.makeText(this, "datos listados", Toast.LENGTH_SHORT).show()

        //binding = ActivityListarDatosBinding.Inflate(LayoutInflater.From(this))
        //setContentView(binding.root)
    }
}