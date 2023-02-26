package com.example.fooddelivery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddelivery.databinding.ActivityOtpBinding
import com.example.fooddelivery.presenter.OtpPresenter

class OtpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{

            val otpPresenter = OtpPresenter()
            otpPresenter.loginBtnClickListener(it)

        }
    }
}