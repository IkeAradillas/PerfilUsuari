package com.example.perfilusuari

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nomUser = findViewById<EditText>(R.id.etNomUser)
        var nom = findViewById<EditText>(R.id.etNombre)
        var cognom = findViewById<EditText>(R.id.etApellidos)
        var email = findViewById<EditText>(R.id.etEmail)
        var bio = findViewById<EditText>(R.id.etBio)
        var url = findViewById<EditText>(R.id.etUrl)
        var btnSend = findViewById<Button>(R.id.Enviar)

        val user = intent.getStringExtra("USER")
        val nombre = intent.getStringExtra("NOM")
        val apellido =intent.getStringExtra("COGNOM")
        val mail = intent.getStringExtra("EMAIL")
        val biog = intent.getStringExtra("BIO")
        val urlImg = intent.getStringExtra("URL")

        nomUser.setText(user)
        nom.setText(nombre)
        cognom.setText(apellido)
        email.setText(mail)
        bio.setText(biog)
        url.setText(urlImg)


        btnSend.setOnClickListener {
            val nextPantalla = Intent(this, PerfilUsuari::class.java)
            nextPantalla.putExtra("USER", nomUser.text.toString())
            nextPantalla.putExtra("NOM", nom.text.toString())
            nextPantalla.putExtra("COGNOM", cognom.text.toString())
            nextPantalla.putExtra("EMAIL", email.text.toString())
            nextPantalla.putExtra("BIO", bio.text.toString())
            nextPantalla.putExtra("URL", url.text.toString())

            startActivity(nextPantalla)
        }



    }
}