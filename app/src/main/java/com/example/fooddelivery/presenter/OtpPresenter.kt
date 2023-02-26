package com.example.fooddelivery.presenter

import android.content.Intent
import android.view.View
import com.example.fooddelivery.Contract
import com.example.fooddelivery.view.activity.FragmentActivity

class OtpPresenter : Contract.Presenter.OtpPresenter {


    override fun loginBtnClickListener(view: View) {

        val intent = Intent(view.context,FragmentActivity::class.java)
        view.context.startActivity(intent)

        //TODO add finish()
    }
}