package com.example.fooddelivery.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R

class VegAdapter(private val arrayList: ArrayList<HashMap<String,Any>>) : RecyclerView.Adapter<VegAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img : ImageView
        val tvName : TextView
        val tvPrice : TextView

        init {
            img = itemView.findViewById(R.id.img_veg)
            tvName = itemView.findViewById(R.id.tv_item_name_veg)
            tvPrice = itemView.findViewById(R.id.tv_item_price_veg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_veg,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.itemView)
            .load(arrayList[position]["image"] as Int)
            .into(holder.img)

        holder.tvName.text = arrayList[position]["name"] as String
        holder.tvPrice.text = arrayList[position]["price"] as String

    }

    override fun getItemCount(): Int {

        return arrayList.size
    }
}