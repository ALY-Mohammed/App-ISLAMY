package com.example.islamy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MovementMethod
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import kotlin.streams.toList

class QuranDetailsActivity : AppCompatActivity() {
    lateinit var name:TextView
    lateinit var details:TextView
    lateinit var backAro:ImageView
    var suraDetails=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_details)
        name=findViewById(R.id.name)
        details=findViewById(R.id.sura)
        val nameTittel =intent.getStringExtra("name")
        val fileSura =intent.getStringExtra("sura")
        name.text=nameTittel
        backAro=findViewById(R.id.icon_back_Aro)
        readSuraDetails(fileSura?:"")
        details.movementMethod=ScrollingMovementMethod()
        details.text=suraDetails

        backAro.setOnClickListener {
            val intentBack=Intent(this@QuranDetailsActivity,HomeActivity::class.java)
            startActivity(intentBack)

        }
    }

    fun readSuraDetails(fileSura:String){
        var counter =0

        //Input File Py InputStreamReader
        val reader= BufferedReader(  InputStreamReader(assets.open(fileSura))  ) //this Line declerate variable take parameter
        //in type bufferReader to tack parameter as A function that read a file and open

        reader.lines().toList().joinToString {

            suraDetails += it + "( ${++counter} )"

            return@joinToString ""
        }

    }
}