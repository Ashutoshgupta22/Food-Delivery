package com.example.fooddelivery.presenter

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.fooddelivery.Contract
import com.example.fooddelivery.view.activity.MapActivity

class FragmentPresenter : Contract.Presenter.FragmentPresenter {



    override fun showMap(context: Context) {

        val intent = Intent(context,MapActivity::class.java)
        context.startActivity(intent)

    }


}