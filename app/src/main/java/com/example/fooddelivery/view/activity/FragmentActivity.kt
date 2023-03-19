package com.example.fooddelivery.view.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.ActivityFragmentBinding
import com.example.fooddelivery.presenter.FragmentPresenter
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


        // registering runtime request
        val locationPermissionRequest =
            registerForActivityResult( ActivityResultContracts.RequestMultiplePermissions()){
                permissions ->
                when{
                    permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION,false) -> {
                        //precise location granted

                        Log.i("FragmentActivity", "onCreate: Precise location granted")
                        FragmentPresenter().showMap(this)

                    }

                    permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION,false) -> {
                        //approx location granted
                        Log.i("FragmentActivity", "onCreate: APPROX location granted")

                    }
                    else -> {
                        // no location access granted
                        Log.e("FragmentActivity", "onCreate:  location NOT granted")
                    }
                }

        }

        //check is permission is already granted
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED){

            //permission granted
            Log.i("FragmentActivity", "check: Precise location already granted")

        }
        else {
            //request permission

            Log.i("FragmentActivity", "check: Precise location already not granted")

            locationPermissionRequest.launch(arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ))
        }

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