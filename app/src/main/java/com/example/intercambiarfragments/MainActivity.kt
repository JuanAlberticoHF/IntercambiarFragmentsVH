package com.example.intercambiarfragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    private lateinit var boton1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Crear una instancia del fragmento
        val firstFragment = FragmentUno()
        boton1 = findViewById(R.id.button1)


        if (findViewById<FragmentContainerView>(R.id.fragment) != null) {
            // Usar supportFragmentManager para manejar transacciones de fragmento
            var transaction = supportFragmentManager.beginTransaction()
            boton1.setOnClickListener {
                firstFragment.actualizarTexto("Toma!")
            }
            transaction.replace(R.id.fragment, firstFragment)
            transaction.commit()
        } else {
            // Estamos en móvil, mostramos solo el main activity origianl
            boton1.setOnClickListener {
                val intent = Intent(this, ActividadFragmentoDos::class.java)
                startActivity(intent)
            }
        }
    }
}
