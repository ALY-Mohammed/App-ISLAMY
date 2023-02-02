package com.example.islamy.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.AhadethDetailsActivity
import com.example.islamy.Fragment.Adapters.AhadethAdapter
import com.example.islamy.R
import java.io.BufferedReader
import java.io.InputStreamReader

class AhadethFragment : Fragment() {

    lateinit var hadapter:AhadethAdapter
    lateinit var hadethrecyclerView:RecyclerView
    var listAhadeth = mutableListOf(" حديث رقم  1 ")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hadethrecyclerView=view.findViewById(R.id.ahadeth_recycler_View)
        listtime(listAhadeth)
        hadapter=AhadethAdapter(listAhadeth)
        hadethrecyclerView.adapter=hadapter

        hadapter.hadethCliked=object :AhadethAdapter.OnItemHadethClick{
            override fun itemClicked(itemview: String, position: Int) {

                val intent = Intent(requireContext(),AhadethDetailsActivity::class.java)
                intent.putExtra("name",itemview)
                intent.putExtra("number","ahadethfile.txt")
                intent.putExtra("textnumber","$position")
                startActivity(intent)

            }
        }

    }


    fun listtime(list: MutableList<String>){

        for (i in 2..50)
        {
            list.add( " حديث رقم $i ")
        }

    }

}
