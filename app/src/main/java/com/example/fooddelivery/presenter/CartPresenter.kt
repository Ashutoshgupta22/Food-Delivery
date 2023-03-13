package com.example.fooddelivery.presenter

import com.example.fooddelivery.Contract
import com.example.fooddelivery.databinding.FragmentCartBinding
import com.example.fooddelivery.view.fragment.CartFragment

class CartPresenter : Contract.Presenter.CartPresenter {


    override fun hideCartEmpty(cartFragment: CartFragment, binding: FragmentCartBinding) {
        cartFragment.hideCartEmpty(binding)
    }
}