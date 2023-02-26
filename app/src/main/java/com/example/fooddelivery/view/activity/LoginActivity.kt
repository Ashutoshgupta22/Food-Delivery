package com.example.fooddelivery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddelivery.databinding.ActivityLoginBinding
import com.example.fooddelivery.presenter.LoginPresenter

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetOtp.setOnClickListener {

            val loginPresenter = LoginPresenter()
            loginPresenter.getOtpBtnClickListener(it)

        }
    }
}