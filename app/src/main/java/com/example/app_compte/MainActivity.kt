package com.example.app_compte

import androidx.appcompat.app.AppCompatActivity
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast;
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intEuro : Int = 0

        var etValeurSaisie = findViewById(R.id.etEnterAmount) as EditText

        var getValeurSaisie = etValeurSaisie.getText()
         var b: Int = etValeurSaisie




        //var getValeurSaisie2 = getValeurSaisie.setTe()




        /*var etNombreSaisi = strValeurSaisie.text as Int

        intEuro = intEuro + etNombreSaisi

        intEuro.toString()

         var strEuro = strValeurSaisie

        var strEuro = StringBuilder().append(intEuro).toString()*/






        val btn_click_AddEuro = findViewById(R.id.btnAddEuro) as Button



// set on-click listener
        btn_click_AddEuro.setOnClickListener {
            Toast.makeText(this@MainActivity, "L'argent a été ajouté", Toast.LENGTH_SHORT).show()

            //var strEuro = intEuro.toString()


            var test: TextView = findViewById(R.id.tvTotalEuro) as TextView
            test.setText(getValeurSaisie)
        }
    }
}















