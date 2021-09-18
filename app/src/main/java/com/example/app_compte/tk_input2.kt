package com.example.app_compte
import androidx.appcompat.app.AppCompatActivity
import android.content.Context;
import android.content.Intent
import android.os.Bundle;
import android.text.Editable
import android.view.View;
import android.widget.Button;
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast;
import java.lang.StringBuilder
//tk_input2 est pour supprimer de l'argent

class tk_input2 : AppCompatActivity() {

    //Declaration de mon bouton
    lateinit var Retour : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input)





        //initialisation
        Retour = findViewById(R.id.btn_retour)


        // creation de notre intent
        val monIntentRetour : Intent =  Intent(this,MainActivity::class.java)

        //clic sur le bouton
        Retour.setOnClickListener {
            startActivity(monIntentRetour)
        }
    }
}