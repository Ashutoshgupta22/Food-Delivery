package com.example.fooddelivery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            map["price"] = binding.tvFullItemPrice.text

            Log.d("ItemActivity", "onCreate: map name is ${map["name"]} ")

            CartModel.cartList.add(map)

            binding.fabFullItem.text = "Added to cart"
            binding.fabFullItem.isEnabled = false

            Log.d("ItemActivity", "onCreate: cartList size= ${CartModel.cartList?.size}")

        }

    }
}