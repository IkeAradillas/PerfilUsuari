package com.example.perfilusuari

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        val nomUser = findViewById<EditText>(R.id.etNomUser)
        val nom = findViewById<EditText>(R.id.etNombre)
        val cognom = findViewById<EditText>(R.id.etApellidos)
        val email = findViewById<EditText>(R.id.etEmail)
        val bio = findViewById<EditText>(R.id.etBio)
        val url = findViewById<EditText>(R.id.etUrl)
        val btnSend = findViewById<Button>(R.id.Enviar)

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
            if (comprobarNull(nomUser) || comprobarNull(nom) || comprobarNull(cognom) || comprobarNull(email) || comprobarNull(bio) || comprobarNull(url)){
                Toast.makeText(this, "Rellena todos los campos!", Toast.LENGTH_SHORT).show()
            }
            else if(nomUser.text.length >18) Toast.makeText(this, "Nombre de usuario con mas de 18 caracteres, escoja uno mas corto", Toast.LENGTH_SHORT).show()
            else if(!email.text.toString().contains("@")) Toast.makeText(this, "Introduce un email valido! No contiene el \"@\"", Toast.LENGTH_SHORT).show()
            else {
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

    fun comprobarNull(a: EditText) : Boolean{
        return a.text.toString().isEmpty()
    }
}