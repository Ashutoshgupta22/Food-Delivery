package com.example.fooddelivery.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fooddelivery.databinding.FragmentDeliveryBinding

class DeliveryFragment : Fragment() {

    private lateinit var binding: FragmentDeliveryBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDeliveryBinding.bind(view)



    }
}