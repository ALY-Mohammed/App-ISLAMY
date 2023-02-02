package com.example.islamy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.islamy.Fragment.AhadethFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.log
import kotlin.streams.toList

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var backAro: ImageView
    lateinit var tittel: TextView
    lateinit var details: TextView
    var hadethDetails = ""
    var list:List<String> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahadeth_details)
        backAro = findViewById(R.id.icon_hadeth_back_Aro)
        tittel = findViewById(R.id.hdeth_Number)
        details = findViewById(R.id.hadeth)
        val textTittel = intent.getStringExtra("name")
        val fileName = intent.getStringExtra("number")
        val testfile = intent.getStringExtra("textnumber")
        tittel.text = textTittel
        val num = testfile?.toInt()
        readSuraDetails(fileName?:"")
        details.text= num?.let { list.get(it) }

        backAro.setOnClickListener {
            val intentBack = Intent(this@AhadethDetailsActivity, HomeActivity::class.java)
            startActivity(intentBack)

        }
    }

    fun readSuraDetails(fileSura:String ){

        //Input File Py InputStreamReader
        val reader= BufferedReader(  InputStreamReader(assets.open(fileSura))  ) //this Line declerate variable take parameter
        //in type bufferReader to tack parameter as A function that read a file and open

        reader.lines().toList().joinToString {
            hadethDetails += it
            return@joinToString ""
        }
         list = hadethDetails.split("#")
    }


    }




