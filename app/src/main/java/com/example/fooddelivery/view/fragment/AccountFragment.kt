package com.example.fooddelivery.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentAccountBinding
import com.example.fooddelivery.databinding.FragmentHomeBinding

class AccountFragment : Fragment(R.layout.fragment_account){

    private lateinit var binding: FragmentAccountBinding

    override fun onStart() {
        super.onStart()

        Log.d("HomeFragment", "onStart: called ")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding  = FragmentAccountBinding.bind(view)

        binding.textView.setOnClickListener {

            Toast.makeText(view.context, "TextView clicked", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {

        Log.d("HomeFragment", "onDestroyView: called")

        //TODO is statement below necessary
        //  binding = null
        super.onDestroyView()
    }
}