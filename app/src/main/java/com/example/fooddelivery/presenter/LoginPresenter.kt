package com.example.fooddelivery.presenter


import android.content.Intent
import android.view.View
import com.example.fooddelivery.Contract
import com.example.fooddelivery.view.activity.OtpActivity

class LoginPresenter : Contract.Presenter.LoginPresenter {

    override fun getOtpBtnClickListener(view: View) {

        val intent = Intent(view.context,OtpActivity::class.java)
        view.context.startActivity(intent)

        //TODO add finish

    }

    override fun signupBtnClickListener(view: View) {
        TODO("Not yet implemented")
    }
}