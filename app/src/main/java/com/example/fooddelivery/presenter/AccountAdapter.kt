package com.example.fooddelivery.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R

class AccountAdapter(private val sectionArrayList : ArrayList<String>) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var tvSection : TextView

        init {
            tvSection = itemView.findViewById(R.id.tv_item_account)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_account,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvSection.text = sectionArrayList[position]
    }

    override fun getItemCount(): Int = sectionArrayList.size

}