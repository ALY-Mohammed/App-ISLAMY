package com.example.islamy.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.islamy.R


class SephaFragment : Fragment() {

lateinit var textnumper: TextView
lateinit var button: Button
lateinit var sepha:ImageView
    lateinit var stick:ImageView
      var counter=1
    var counterword=1
    lateinit var imagestick:ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sepha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button=view.findViewById(R.id.sephaButton)
        textnumper=view.findViewById(R.id.counter)
        imagestick=view.findViewById(R.id.stick)
        sepha=view.findViewById(R.id.sephaImage)

        button.setOnClickListener {



            if (counter<32){
                textnumper.text=counter.toString()
                counter++
            }
            else if (counter==32){
                textnumper.text=counter.toString()
                counter=0
            }


            if (counterword<=1*33-1){
                button.text="سبحان الله"
                counterword++
            }
            else if(counterword>=1*33 && counterword<=2*33-1){
                button.text="الحمد الله"
                counterword++
            }
            else if(counterword>=2*33 && counterword<=3*33-1){
                button.text="لا اله الا الله"
                counterword++
            }
            else if(counterword>=3*33 && counterword<=4*33-1){
                button.text="الله اكبر"
                counterword++
            }
            else if(counterword>=4*33 && counterword<=5*33-1){
                button.text="لا حول ولا قوه الا بالله"
                counterword++
                if (counterword==5*33){
                    counterword=0
                }
            }

            sepha.rotation=sepha.rotation +5

        }

    }

}