package com.example.perfilusuari

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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


        intent.getStringExtra("USER").apply { user.text = "$this" }
        intent.getStringExtra("NOM" + " " + "COGNOM").apply { nomcognom.text = "$this" }
        intent.getStringExtra("EMAIL").apply { email.text = "$this" }
        intent.getStringExtra("BIO").apply { bio.text = "$this" }

    }
}