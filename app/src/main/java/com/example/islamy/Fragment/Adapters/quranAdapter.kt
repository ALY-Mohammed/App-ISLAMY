package com.example.islamy.Fragment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamy.R

class quranAdapter(val itemsV:List<String>):Adapter<quranAdapter.ViewHolder>() {



    class ViewHolder(itemView:View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){

        var textview=itemView.findViewById<TextView>(R.id.sura)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view :View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura_name_recyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.textview.text=itemsV.get(position)
    holder.itemView.setOnClickListener {
        setOnTextClicked?.suraNameTextclicked(itemsV.get(position), position)
    }


    }

    override fun getItemCount(): Int { return itemsV.size}


    var setOnTextClicked:setOnclickListenerSuraName?=null
    interface setOnclickListenerSuraName{
        fun suraNameTextclicked(itemsV:String,position: Int)
    }

}