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
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.StringBuilder



//tk_input1 est pour ajouter de l'argent

class tk_input1 : AppCompatActivity() {




    //Declaration de mon bouton
    lateinit var Retour : Button
    var euro_str = ""
    var euro_int = 0
    var euro_tot = 0

    //essayer de transférer euro_tot_str entre les différents layout/activiy

    var euro_tot_str ="0"
    var saisie : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input)

        //algo calculatrice

        var btn_click_zero = findViewById(R.id.btn_zero) as Button
        var btn_click_un = findViewById(R.id.btn_un) as Button
        var btn_click_deux = findViewById(R.id.btn_deux) as Button
        var btn_click_trois = findViewById(R.id.btn_trois) as Button
        val btn_click_quatre = findViewById(R.id.btn_quatre) as Button
        val btn_click_cinq = findViewById(R.id.btn_cinq) as Button
        val btn_click_six = findViewById(R.id.btn_six) as Button
        val btn_click_sept = findViewById(R.id.btn_sept) as Button
        val btn_click_huit = findViewById(R.id.btn_huit) as Button
        val btn_click_neuf = findViewById(R.id.btn_neuf) as Button
        val btn_click_point = findViewById(R.id.btn_point) as Button
        val btn_click_valider = findViewById(R.id.btn_valider) as Button

        //var euro_int = euro.code



        var tv = findViewById(R.id.tv_saisie) as TextView



        btn_click_zero.setOnClickListener {
            saisie = 0
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)

        }
        btn_click_un.setOnClickListener {
            saisie = 1
             euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_deux.setOnClickListener {
            saisie =  2
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_trois.setOnClickListener {
            saisie =  3
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_quatre.setOnClickListener {
            saisie =  4
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_cinq.setOnClickListener {
            saisie =   5
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_six.setOnClickListener {
            saisie =   6
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_sept.setOnClickListener {
            saisie =   7
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_huit.setOnClickListener {
            saisie =   8
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_neuf.setOnClickListener {
            saisie =   9
            euro_str = "$euro_str$saisie"
            tv.setText(euro_str)
        }
        btn_click_point.setOnClickListener {
            euro_str = "$euro_str."
            tv.setText(euro_str)
        }

        var tv_result = findViewById(R.id.tv_resultat) as TextView

        btn_click_valider.setOnClickListener {
            euro_int = euro_str.toInt()
            euro_tot = euro_tot + euro_int
            euro_tot_str = euro_tot.toString()
            euro_tot_str = "$euro_tot_str €"
            tv_result.setText(euro_tot_str)
            euro_str = ""
            tv.setText(euro_str)


             }

        //initialisation
        Retour = findViewById(R.id.btn_retour)


        // creation de notre intent
        val monIntentRetour : Intent =  Intent(this,MainActivity::class.java)

        //clic sur le bouton

        Retour.setOnClickListener {
            startActivity(monIntentRetour)
            Toast.makeText(this@tk_input1, "$euro_tot_str", Toast.LENGTH_SHORT).show()
        }
    }
}