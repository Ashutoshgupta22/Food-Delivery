package com.example.fooddelivery.model

import com.example.fooddelivery.R

class VegModel {

    private var map  = hashMapOf<String,Any>()
    private var map2  = hashMapOf<String,Any>()
    private var map3  = hashMapOf<String,Any>()
    private var map4  = hashMapOf<String,Any>()
    private var map5  = hashMapOf<String,Any>()
    private var map6  = hashMapOf<String,Any>()
    private var map7  = hashMapOf<String,Any>()
    private var map8  = hashMapOf<String,Any>()
     var vegList : ArrayList<HashMap<String,Any>>
     var nonVegList : ArrayList<HashMap<String,Any>>

    init {
        map["image"] = R.drawable.pasta
        map["name"] = "Paneer"
        map["price"] = "Rs. 260"

        map2["image"] = R.drawable.pasta
        map2["name"] = "Mushroom"
        map2["price"] = "Rs. 210"

        map3["image"] = R.drawable.pasta
        map3["name"] = "Aloo jeera"
        map3["price"] = "Rs. 140"

        map4["image"] = R.drawable.pasta
        map4["name"] = "Mix Veg"
        map4["price"] = "Rs. 180"

         vegList = arrayListOf(
            map,
            map2,
            map3,
            map4
        )
    }

    init {

        map5["image"] = R.drawable.pasta
        map5["name"] = "Butter Chicken"
        map5["price"] = "Rs. 250"

        map6["image"] = R.drawable.pasta
        map6["name"] = "Chicken Masala"
        map6["price"] = "Rs. 220"

        map7["image"] = R.drawable.pasta
        map7["name"] = "Mutton Curry"
        map7["price"] = "Rs. 240"

        map8["image"] = R.drawable.pasta
        map8["name"] = "Chicken Kadhai"
        map8["price"] = "Rs. 260"

        nonVegList = arrayListOf(
            map5,
            map6,
            map7,
            map8
        )
    }




}