package com.example.fooddelivery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.ActivityItemBinding
import com.example.fooddelivery.model.CartModel
import kotlin.math.log

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgFullItem.clipToOutline = true

        binding.toolbar.setNavigationOnClickListener {

            finish()
        }

        binding.fabFullItem.setOnClickListener {

            val map = hashMapOf<String,Any>()

            map["image"] = R.drawable.pasta
            map["name"] = binding.tvFullItemName.text
            map["about"] = binding.tvFullItemAbout.text
            map["price"] = 190

            Log.d("ItemActivity", "onCreate: map name is ${map["name"]} ")

            CartModel.cartList.add(map)

            Toast.makeText(it.context, "Added to cart", Toast.LENGTH_SHORT).show()
            Log.d("ItemActivity", "onCreate: cartList size= ${CartModel.cartList.size}")

        }

    }
}