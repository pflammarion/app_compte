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




class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialisation de la "calulatrice"

        var eurotest = 0
        //var euro_tot_int =



        val btn_click_AddEuro = findViewById(R.id.btnAddEuro) as Button
        val monIntent : Intent =  Intent(this,tk_input1::class.java)

// set on-click listener
        btn_click_AddEuro.setOnClickListener {
            startActivity(monIntent);
        }

        val btn_click_DeleteEuro = findViewById(R.id.btnDeleteEuro) as Button
        val monIntent2 : Intent =  Intent(this,tk_input2::class.java)

// set on-click listener
        btn_click_DeleteEuro.setOnClickListener {
            startActivity(monIntent2);
        }

        val btn_click_history = findViewById(R.id.btnHistory) as Button
        val monIntent3 : Intent =  Intent(this,history::class.java)

// set on-click listener
        btn_click_history.setOnClickListener {
            startActivity(monIntent3);
        }

        val btn_click_test = findViewById(R.id.btntest) as Button
        var tvtest = findViewById(R.id.tvTotalEuro) as TextView


// set on-click listener
        btn_click_test.setOnClickListener {
            tvtest.visibility = View.GONE
        }




        //get value of global var used getApplication
        /*var mApp = tk_input1()
        var strGlobalVar = mApp.euro_tot_int

        var tv_total = findViewById(R.id.tvTotalEuro) as TextView
        tv_total.setText(strGlobalVar)*/



    }
}

















