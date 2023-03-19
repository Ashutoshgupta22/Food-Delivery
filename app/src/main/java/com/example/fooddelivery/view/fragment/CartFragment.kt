package com.example.fooddelivery.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.Contract
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentCartBinding
import com.example.fooddelivery.model.CartModel
import com.example.fooddelivery.presenter.CartAdapter
import com.example.fooddelivery.presenter.CartPresenter

class CartFragment : Fragment(R.layout.fragment_cart) , Contract.View.CartView {

    private lateinit var binding: FragmentCartBinding
    private var total =0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding  = FragmentCartBinding.bind(view)

        val spinnerAdapter = ArrayAdapter(view.context,R.layout.item_spinner, arrayListOf("UPI","Cash"))
        binding.spinnerCart.adapter = spinnerAdapter

        if (CartModel.cartList.size >0) {
            CartPresenter().hideCartEmpty(CartFragment(), binding)

            for (i in CartModel.cartList.indices)
                    total += CartModel.cartList[i]["price"] as Int

            binding.tvCartTotal.text = "₹${total}"

        }

        binding.rvCart.apply {

           layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
           adapter = CartAdapter(CartModel.cartList)
       }

        binding.btnCartPay.setOnClickListener {


        }
    }

    override fun hideCartEmpty(binding: FragmentCartBinding) {

        if (binding.tvCartEmpty.isVisible)
            binding.tvCartEmpty.visibility = View.GONE

        if (!binding.cartPayLayout.isVisible)
            binding.cartPayLayout.visibility  = View.VISIBLE
    }
}