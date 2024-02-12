package com.example.coneccionbd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.coneccionbd.Modem.BdHelper
import com.example.coneccionbd.Modem.ManangerDb
import com.example.coneccionbd.Modem.listarDatos
import com.example.coneccionbd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(LayoutInflater.from(this
        ))
        setContentView(binding.root)

        binding.btnInsertar.setOnClickListener { val code=binding.editTextCodigo.text.toString()

            val ciudad=binding.editTextCiudad.text.toString()

            val codep=binding.editTextCodep.text.toString()

            val intent=Intent(this, listarDatos::class.java)

            val manager = ManangerDb(this)
            manager.inserData(code.toInt(),ciudad,codep.toInt())
            startActivity(intent)
        }



        //val bdHelper = BdHelper(this)
       // val db = bdHelper.writableDatabase// abro mi bd en mode escritura
        //Toast.makeText(this, "base de datos creada", Toast.LENGTH_SHORT).show()
      //  db.close()//cierro la base de datos


    }
}