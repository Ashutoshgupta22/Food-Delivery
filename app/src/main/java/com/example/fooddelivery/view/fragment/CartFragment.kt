package com.example.fooddelivery.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentCartBinding
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.model.CartModel
import com.example.fooddelivery.presenter.CartAdapter

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var binding: FragmentCartBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding  = FragmentCartBinding.bind(view)

       binding.rvCart.apply {

           layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
           adapter = CartAdapter(CartModel.cartList)
       }

    }


}