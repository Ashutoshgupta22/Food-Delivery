package com.example.fooddelivery.presenter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.view.activity.ItemActivity


class SpecialsAdapter(private val specialsList: ArrayList<HashMap<String,Any>>) : RecyclerView.Adapter<SpecialsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img : ImageView
        val tvName: TextView
        val tvPrice: TextView
        val tvAbout: TextView
        val card : CardView

        init {
            img = itemView.findViewById(R.id.img_specials)
            tvName = itemView.findViewById(R.id.tv_specials_name)
            tvPrice = itemView.findViewById(R.id.tv_specials_price)
            tvAbout = itemView.findViewById(R.id.tv_specials_about)
            card = itemView.findViewById(R.id.card_item_specials)

            card.setOnClickListener{

                val intent = Intent(itemView.context,ItemActivity::class.java)
                itemView.context.startActivity(intent)

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_specials,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // to fit the imageview in its background outline
        holder.img.clipToOutline = true

        Glide.with(holder.itemView)
            .load(specialsList[position]["img"] as Int)
            .into(holder.img)

        holder.tvName.text = specialsList[position]["name"].toString()
        holder.tvPrice.text = specialsList[position]["price"].toString()
        holder.tvAbout.text = specialsList[position]["about"].toString()

    }

    override fun getItemCount(): Int {

        return specialsList.size
    }
}