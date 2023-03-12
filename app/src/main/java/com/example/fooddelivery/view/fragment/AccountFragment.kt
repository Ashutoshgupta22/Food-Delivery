package com.example.fooddelivery.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.FragmentAccountBinding
import com.example.fooddelivery.databinding.FragmentHomeBinding
import com.example.fooddelivery.model.AccountModel
import com.example.fooddelivery.presenter.AccountAdapter

class AccountFragment : Fragment(R.layout.fragment_account){

    private lateinit var binding: FragmentAccountBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding  = FragmentAccountBinding.bind(view)

        binding.rvAccount.apply {

            layoutManager =  LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = AccountAdapter(AccountModel().sectionArrayList)
        }


    }

}