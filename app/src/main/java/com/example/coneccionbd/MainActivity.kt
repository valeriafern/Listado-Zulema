package com.example.coneccionbd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.coneccionbd.Modem.ManangerDb
import com.example.coneccionbd.Modem.listarDatos
import com.example.coneccionbd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnInsertar.setOnClickListener {
            val code = binding.editTextCodigo.text.toString()
            val ciudad = binding.editTextCiudad.text.toString()
            val codep = binding.editTextCodep.text.toString()

            val manager = ManangerDb(this)
            manager.inserData(code.toInt(), ciudad, codep.toInt())
            mostrarListaCiudades() // Llama a mostrarListaCiudades después de insertar los datos
        }
    }

    private fun mostrarListaCiudades() {
        val intent = Intent(this, listarDatos::class.java)
        startActivity(intent)
    }
}