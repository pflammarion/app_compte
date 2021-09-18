package com.example.app_compte

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class history  : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var Retour : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)





        //initialisation
        Retour = findViewById(R.id.btn_retour2)


        // creation de notre intent
        val monIntentRetour : Intent =  Intent(this,MainActivity::class.java)

        //clic sur le bouton
        Retour.setOnClickListener {
            startActivity(monIntentRetour)
        }
    }
}