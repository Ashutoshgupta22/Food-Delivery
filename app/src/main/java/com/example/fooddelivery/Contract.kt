package com.example.fooddelivery

import com.example.fooddelivery.databinding.FragmentCartBinding
import com.example.fooddelivery.view.fragment.CartFragment

interface Contract {

    interface Model {

    }

    interface View {

        interface CartView {
            fun hideCartEmpty(binding: FragmentCartBinding)
        }

    }

    interface Presenter {

        interface LoginPresenter {

           fun getOtpBtnClickListener(view : android.view.View)
           fun signupBtnClickListener(view: android.view.View)
        }

        interface OtpPresenter {

            fun loginBtnClickListener(view: android.view.View)
        }

        interface CartPresenter {
            fun hideCartEmpty(cartFragment: CartFragment, binding: FragmentCartBinding)
        }

    }
}