package com.example.fooddelivery.model

import com.example.fooddelivery.R

class SpecialsModel {


    private val map = hashMapOf<String,Any>()

    init {
        map["img"] = R.drawable.car1
        map["name"] = "Hurracan"
        map["price"] = "Rs. 350"
        map["about"] = "Rice noodles with shrimp, eggs, and spicy mexican sauce"
    }

    private val map2 = hashMapOf<String,Any>()

    init {

        map2["img"] = R.drawable.car2
        map2["name"] = "Performante"
        map2["price"] = "Rs. 400"
        map2["about"] = "With strawberry, tomato, egg"

    }


    val specialsList = arrayListOf(
        map,
        map2
    )
}