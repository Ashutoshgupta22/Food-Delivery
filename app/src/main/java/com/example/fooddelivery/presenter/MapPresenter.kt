package com.example.fooddelivery.presenter

import android.content.Context
import android.location.Location
import android.os.Bundle
import com.example.fooddelivery.Contract
import com.example.fooddelivery.model.LocationServicesProvider

class MapPresenter : Contract.Presenter.MapPresenter {



    override fun getLastLocation(context: Context, view: Contract.View.MapView, savedInstanceState: Bundle?) {

        LocationServicesProvider(context).getLastLocation(view,savedInstanceState)

    }
}