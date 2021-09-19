package com.example.app_compte

import androidx.appcompat.app.AppCompatActivity
import android.content.Context;
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle;
import android.preference.PreferenceManager
import android.provider.Settings.Global.getString
import android.provider.Settings.System.getString
import android.text.Editable
import android.view.View;
import android.widget.Button;
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast;
import java.lang.StringBuilder
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.core.content.res.TypedArrayUtils.getString

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_click_zero = findViewById(R.id.btn_zero) as Button
        val btn_click_un = findViewById(R.id.btn_un) as Button
        val btn_click_deux = findViewById(R.id.btn_deux) as Button
        val btn_click_trois = findViewById(R.id.btn_trois) as Button
        val btn_click_quatre = findViewById(R.id.btn_quatre) as Button
        val btn_click_cinq = findViewById(R.id.btn_cinq) as Button
        val btn_click_six = findViewById(R.id.btn_six) as Button
        val btn_click_sept = findViewById(R.id.btn_sept) as Button
        val btn_click_huit = findViewById(R.id.btn_huit) as Button
        val btn_click_neuf = findViewById(R.id.btn_neuf) as Button
        val btn_click_point = findViewById(R.id.btn_point) as Button
        val btn_click_valider_add = findViewById(R.id.btn_valider_add) as Button
        val btn_click_valider_del = findViewById(R.id.btn_valider_del) as Button
        val btn_click_retour = findViewById(R.id.btn_retour) as Button
        val btn_click_clear = findViewById(R.id.btn_Clear) as Button
        val tv_saisie = findViewById(R.id.tv_saisie) as TextView
        val btn_click_AddEuro = findViewById(R.id.btnAddEuro) as Button
        val btn_click_DeleteEuro = findViewById(R.id.btnDeleteEuro) as Button
        val btn_click_History = findViewById(R.id.btnHistory) as Button
        val df = DecimalFormat("#.##")

        btn_click_zero.visibility = View.GONE
        btn_click_un.visibility = View.GONE
        btn_click_deux.visibility = View.GONE
        btn_click_trois.visibility = View.GONE
        btn_click_quatre.visibility = View.GONE
        btn_click_cinq.visibility = View.GONE
        btn_click_six.visibility = View.GONE
        btn_click_sept.visibility = View.GONE
        btn_click_huit.visibility = View.GONE
        btn_click_neuf.visibility = View.GONE
        btn_click_point.visibility = View.GONE
        btn_click_valider_add.visibility = View.GONE
        btn_click_valider_del.visibility = View.GONE
        btn_click_clear.visibility = View.GONE
        btn_click_retour.visibility = View.GONE
        tv_saisie.visibility = View.GONE
        btn_click_History.visibility = View.GONE

        btn_click_AddEuro.setOnClickListener {

            btn_click_AddEuro.visibility = View.GONE
            btn_click_DeleteEuro.visibility = View.GONE
            btn_click_History.visibility = View.GONE
            btn_click_zero.visibility = View.VISIBLE
            btn_click_un.visibility = View.VISIBLE
            btn_click_deux.visibility = View.VISIBLE
            btn_click_trois.visibility = View.VISIBLE
            btn_click_quatre.visibility = View.VISIBLE
            btn_click_cinq.visibility = View.VISIBLE
            btn_click_six.visibility = View.VISIBLE
            btn_click_sept.visibility = View.VISIBLE
            btn_click_huit.visibility = View.VISIBLE
            btn_click_neuf.visibility = View.VISIBLE
            btn_click_point.visibility = View.VISIBLE
            btn_click_valider_add.visibility = View.VISIBLE
            btn_click_valider_del.visibility = View.GONE
            btn_click_clear.visibility = View.VISIBLE
            btn_click_retour.visibility = View.VISIBLE
            tv_saisie.visibility = View.VISIBLE
        }

        btn_click_retour.setOnClickListener {
            btn_click_zero.visibility = View.GONE
            btn_click_un.visibility = View.GONE
            btn_click_deux.visibility = View.GONE
            btn_click_trois.visibility = View.GONE
            btn_click_quatre.visibility = View.GONE
            btn_click_cinq.visibility = View.GONE
            btn_click_six.visibility = View.GONE
            btn_click_sept.visibility = View.GONE
            btn_click_huit.visibility = View.GONE
            btn_click_neuf.visibility = View.GONE
            btn_click_point.visibility = View.GONE
            btn_click_valider_add.visibility = View.GONE
            btn_click_valider_del.visibility = View.GONE
            btn_click_clear.visibility = View.GONE
            btn_click_retour.visibility = View.GONE
            tv_saisie.visibility = View.GONE
            btn_click_AddEuro.visibility = View.VISIBLE
            btn_click_DeleteEuro.visibility = View.VISIBLE
            btn_click_History.visibility = View.GONE
        }

        btn_click_DeleteEuro.setOnClickListener {
            btn_click_AddEuro.visibility = View.GONE
            btn_click_DeleteEuro.visibility = View.GONE
            btn_click_History.visibility = View.GONE
            btn_click_zero.visibility = View.VISIBLE
            btn_click_un.visibility = View.VISIBLE
            btn_click_deux.visibility = View.VISIBLE
            btn_click_trois.visibility = View.VISIBLE
            btn_click_quatre.visibility = View.VISIBLE
            btn_click_cinq.visibility = View.VISIBLE
            btn_click_six.visibility = View.VISIBLE
            btn_click_sept.visibility = View.VISIBLE
            btn_click_huit.visibility = View.VISIBLE
            btn_click_neuf.visibility = View.VISIBLE
            btn_click_point.visibility = View.VISIBLE
            btn_click_valider_add.visibility = View.GONE
            btn_click_valider_del.visibility = View.VISIBLE
            btn_click_clear.visibility = View.VISIBLE
            btn_click_retour.visibility = View.VISIBLE
            tv_saisie.visibility = View.VISIBLE
        }

        var euro_str = ""
        var euro_int: Double = 0.00
        var tv_result = findViewById(R.id.tv_resultat) as TextView
        var sharedPreferences = getSharedPreferences("EURO", Context.MODE_PRIVATE)
        var euro_tot_str = sharedPreferences.getString("EURO", "0")
        tv_result.setText("$euro_tot_str €")
        var euro_transit = "$euro_tot_str"
        var euro_tot = euro_transit.toDouble()
        var saisie: Int = 0

        btn_click_clear.setOnClickListener {
            euro_str = ""
            tv_saisie.setText(euro_str)
        }

        btn_click_zero.setOnClickListener {
            saisie = 0
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_un.setOnClickListener {
            saisie = 1
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_deux.setOnClickListener {
            saisie = 2
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_trois.setOnClickListener {
            saisie = 3
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_quatre.setOnClickListener {
            saisie = 4
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_cinq.setOnClickListener {
            saisie = 5
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_six.setOnClickListener {
            saisie = 6
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_sept.setOnClickListener {
            saisie = 7
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_huit.setOnClickListener {
            saisie = 8
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_neuf.setOnClickListener {
            saisie = 9
            euro_str = "$euro_str$saisie"
            tv_saisie.setText(euro_str)
        }
        btn_click_point.setOnClickListener {
            euro_str = "$euro_str."
            tv_saisie.setText(euro_str)
        }

        btn_click_valider_add.setOnClickListener {
            if (euro_str == "") {
                Toast.makeText(this@MainActivity, "Veuillez entrer une valeur", Toast.LENGTH_SHORT)
                    .show()
            } else {
                euro_int = euro_str.toDouble()
                euro_tot = euro_int + euro_tot
                euro_tot_str = (df.format(euro_tot)).toString()
                val editor = sharedPreferences.edit()
                editor.putString("EURO", euro_tot_str).apply()
                euro_tot_str = "$euro_tot_str €"
                tv_result.setText(euro_tot_str)
                euro_str = ""
                tv_saisie.setText(euro_str)
                btn_click_zero.visibility = View.GONE
                btn_click_un.visibility = View.GONE
                btn_click_deux.visibility = View.GONE
                btn_click_trois.visibility = View.GONE
                btn_click_quatre.visibility = View.GONE
                btn_click_cinq.visibility = View.GONE
                btn_click_six.visibility = View.GONE
                btn_click_sept.visibility = View.GONE
                btn_click_huit.visibility = View.GONE
                btn_click_neuf.visibility = View.GONE
                btn_click_point.visibility = View.GONE
                btn_click_valider_add.visibility = View.GONE
                btn_click_valider_del.visibility = View.GONE
                btn_click_clear.visibility = View.GONE
                btn_click_retour.visibility = View.GONE
                tv_saisie.visibility = View.GONE
                btn_click_AddEuro.visibility = View.VISIBLE
                btn_click_DeleteEuro.visibility = View.VISIBLE
                btn_click_History.visibility = View.GONE
            }
        }

        btn_click_valider_del.setOnClickListener {
            if (euro_str == "") {
                Toast.makeText(this@MainActivity, "Veuillez entrer une valeur", Toast.LENGTH_SHORT)
                    .show()
            } else {
                euro_int = euro_str.toDouble()
                if (euro_tot < (euro_int)) {
                    Toast.makeText(
                        this@MainActivity,
                        "Tu ne dois rien à personne",
                        Toast.LENGTH_SHORT
                    ).show()
                    euro_str = ""
                    tv_saisie.setText(euro_str)
                } else {
                    euro_tot = euro_tot - euro_int
                    euro_tot_str = (df.format(euro_tot)).toString()
                    val editor = sharedPreferences.edit()
                    editor.putString("EURO", euro_tot_str).apply()
                    euro_tot_str = "$euro_tot_str €"
                    tv_result.setText(euro_tot_str)
                    euro_str = ""
                    tv_saisie.setText(euro_str)
                    btn_click_zero.visibility = View.GONE
                    btn_click_un.visibility = View.GONE
                    btn_click_deux.visibility = View.GONE
                    btn_click_trois.visibility = View.GONE
                    btn_click_quatre.visibility = View.GONE
                    btn_click_cinq.visibility = View.GONE
                    btn_click_six.visibility = View.GONE
                    btn_click_sept.visibility = View.GONE
                    btn_click_huit.visibility = View.GONE
                    btn_click_neuf.visibility = View.GONE
                    btn_click_point.visibility = View.GONE
                    btn_click_valider_add.visibility = View.GONE
                    btn_click_valider_del.visibility = View.GONE
                    btn_click_clear.visibility = View.GONE
                    btn_click_retour.visibility = View.GONE
                    tv_saisie.visibility = View.GONE
                    btn_click_AddEuro.visibility = View.VISIBLE
                    btn_click_DeleteEuro.visibility = View.VISIBLE
                    btn_click_History.visibility = View.GONE
                }
            }
        }
    }
}

















