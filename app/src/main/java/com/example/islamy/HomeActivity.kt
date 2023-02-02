package com.example.islamy

import QuranFrahment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamy.Fragment.AhadethFragment
import com.example.islamy.Fragment.RadioFragment
import com.example.islamy.Fragment.SephaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var titteltextView: TextView
   lateinit var menuNavBar:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        menuNavBar=findViewById(R.id.bottomnavigationView)
        titteltextView=findViewById(R.id.islamy)
        pushFragment(QuranFrahment())

        menuNavBar.setOnItemSelectedListener { item->

                if (item.itemId == R.id.iconquran) {
                    titteltextView.text="Quran"
                    pushFragment(QuranFrahment())
                } else if (item.itemId == R.id.iconahades) {
                    titteltextView.text="Ahadeth"
                    pushFragment(AhadethFragment())
                } else if (item.itemId == R.id.iconsepha) {
                    titteltextView.text="Sepha"
                    pushFragment(SephaFragment())
                } else {
                    titteltextView.text="Radio"
                    pushFragment(RadioFragment())
                }

            return@setOnItemSelectedListener true
            }
    }

    fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContaner,fragment)
            .commit()

    }

}