package com.example.fooddelivery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.ActivityFragmentBinding
import com.example.fooddelivery.view.fragment.AccountFragment
import com.example.fooddelivery.view.fragment.CartFragment
import com.example.fooddelivery.view.fragment.DeliveryFragment
import com.example.fooddelivery.view.fragment.HomeFragment

class FragmentActivity : AppCompatActivity() {

   private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId) {

                R.id.nav_home -> {

                    loadFragment(HomeFragment())
                    true
                }

                R.id.nav_shopping_bag -> {

                    loadFragment(CartFragment())
                    true
                }

                R.id.nav_account -> {

                    loadFragment(AccountFragment())
                    true
                }

                R.id.nav_delivery-> {

                    loadFragment(DeliveryFragment())
                    true
                }
                else -> {false}
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()

    }
}