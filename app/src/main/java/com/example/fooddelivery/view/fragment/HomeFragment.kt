package com.example.fooddelivery.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.model.CategoriesModel
import com.example.fooddelivery.model.SpecialsModel
import com.example.fooddelivery.model.VegModel
import com.example.fooddelivery.presenter.CategoriesAdapter
import com.example.fooddelivery.presenter.SpecialsAdapter
import com.example.fooddelivery.presenter.VegAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onStart() {
        super.onStart()

        Log.d("HomeFragment", "onStart: called ")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding  = FragmentHomeBinding.bind(view)

        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = CategoriesAdapter(CategoriesModel().imgList, CategoriesModel().nameList)
        }

        binding.rvSpecials.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = SpecialsAdapter(SpecialsModel().specialsList)
        }

        binding.rvVeg.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = VegAdapter(VegModel().vegList)

            Log.i("HomeFragment", "onViewCreated: Veg= ${VegModel().vegList[0]["name"]}")
        }

        binding.rvNonVeg.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = VegAdapter(VegModel().nonVegList)

            Log.i("HomeFragment", "onViewCreated: Veg= ${VegModel().nonVegList[0]["name"]}")
        }

    }

    override fun onDestroyView() {

        Log.d("HomeFragment", "onDestroyView: called")

        //TODO is statement below necessary
      //  binding = null
        super.onDestroyView()
    }
}