package com.example.perfilusuari

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class PerfilUsuari : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil_usuari)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = findViewById<TextView>(R.id.user)
        val nomcognom = findViewById<TextView>(R.id.nomcognom)
        val email = findViewById<TextView>(R.id.email)
        val bio = findViewById<TextView>(R.id.bio)
        val url = findViewById<ImageView>(R.id.Imagen)

        intent.getStringExtra("USER").apply { user.text = "$this" }
        val nom = intent.getStringExtra("NOM")
        val cognom = intent.getStringExtra("COGNOM")
        nomcognom.text = "$nom $cognom"

        intent.getStringExtra("EMAIL").apply { email.text = "$this" }
        intent.getStringExtra("BIO").apply { bio.text = "$this" }

        Glide.with(url).load(intent.getStringExtra("URL")).into(url)

        val btnEdit = findViewById<Button>(R.id.btnEditInfo)

        btnEdit.setOnClickListener {
            val nextPantalla = Intent(this, MainActivity::class.java)
            comprobarEmail(email.text.toString())
            nextPantalla.putExtra("USER", user.text.toString())
            nextPantalla.putExtra("NOM", nom)
            nextPantalla.putExtra("COGNOM", cognom)
            nextPantalla.putExtra("EMAIL", email.text.toString())
            nextPantalla.putExtra("BIO", bio.text.toString())
            nextPantalla.putExtra("URL", intent.getStringExtra("URL"))
            startActivity(nextPantalla)
        }

    }

    fun comprobarEmail(email: String) {
        if (!email.contains("@")) Toast.makeText(
            this, "Introduce un email valido! No contiene el \"@\"",
            Toast.LENGTH_SHORT
        ).show()
    }

}


