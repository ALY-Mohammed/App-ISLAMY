package com.example.islamy.Fragment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamy.R

class AhadethAdapter (var itemsV:MutableList<String>) : Adapter<AhadethAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view :View = LayoutInflater.from(parent.context)
            .inflate(R.layout.ahadethrecyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textview.text = itemsV.get(position)

        holder.itemView.setOnClickListener {
            hadethCliked?.itemClicked(itemsV.get(position), position)
        }

    }
    override fun getItemCount(): Int {
        return itemsV.size
    }

    class ViewHolder(itemview: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview){
        var textview:TextView=itemView.findViewById(R.id.text_Hadeth_Recycler)
    }

    var hadethCliked:OnItemHadethClick?=null

    interface OnItemHadethClick{
        fun itemClicked(itemview:String,position: Int)
    }

}