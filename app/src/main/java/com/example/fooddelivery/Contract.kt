package com.example.fooddelivery

import android.content.Context
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fooddelivery.databinding.FragmentCartBinding
import com.example.fooddelivery.view.fragment.CartFragment

interface Contract {

    interface Model {

    }

    interface View {

        interface CartView {
            fun hideCartEmpty(binding: FragmentCartBinding)
        }

        interface MapView {
            fun showMap(savedInstanceState: Bundle?, location: Location)
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
        interface FragmentPresenter {

            fun showMap(context: Context)

        }
        interface MapPresenter {

           // fun showMap(savedInstanceState : Bundle?, location : Location, view: View.MapView)
            fun getLastLocation(context: Context,view: View.MapView,savedInstanceState: Bundle?)

            fun loadFragment(fragment: Fragment)
        }

    }
}