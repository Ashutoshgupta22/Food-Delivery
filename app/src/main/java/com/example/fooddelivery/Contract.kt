package com.example.fooddelivery

interface Contract {

    interface Model {

    }

    interface View {

    }

    interface Presenter {

        interface LoginPresenter {

           fun getOtpBtnClickListener(view : android.view.View)
           fun signupBtnClickListener(view: android.view.View)
        }

        interface OtpPresenter {

            fun loginBtnClickListener(view: android.view.View)
        }

    }
}