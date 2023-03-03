package com.example.fooddelivery.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R

class CategoriesAdapter(private val imgList: ArrayList<Int>, private val nameList: ArrayList<String>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val img : ImageView
        val tvName: TextView

        init {

            img = view.findViewById(R.id.img_item_categories)
            tvName = view.findViewById(R.id.tv_item_name_categories)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.img.setImageResource(imgList[position])
        holder.tvName.text = nameList[position]
    }

    override fun getItemCount(): Int {

        return imgList.size
    }

}


