package com.example.fooddelivery.presenter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.R
import com.example.fooddelivery.model.CartModel

class CartAdapter(private val cartList : ArrayList<HashMap<String,Any>>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgItem : ImageView
        var tvName : TextView
        var tvAbout : TextView
        var tvPrice : TextView

        init {
            imgItem = itemView.findViewById(R.id.img_cart_item)
            tvName = itemView.findViewById(R.id.tv_cart_item_name)
            tvAbout = itemView.findViewById(R.id.tv_cart_item_about)
            tvPrice = itemView.findViewById(R.id.tv_cart_item_price)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart,parent,false)

        return ViewHolder(view)


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imgItem.clipToOutline = true

       Glide.with(holder.itemView.context)
           .load(cartList[position]["image"])
           .into(holder.imgItem)

        val price = cartList[position]["price"] as Int

        holder.tvName.text = cartList[position]["name"] as String
        holder.tvAbout.text = cartList[position]["about"] as String
        holder.tvPrice.text = "₹${price}"
    }

    override fun getItemCount(): Int {

            Log.d("CartAdapter", "getItemCount: ${cartList.size} ")
            return cartList.size

    }
}