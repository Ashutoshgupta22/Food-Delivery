package com.aspark.spendwiseassign.ui.theme

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MyMealScreen() {

    Log.i("Screens", "MyMealScreen: called")
    Text(text = "My Meals")
}


@Composable
fun ProfileScreen() {
    Log.i("Screens", "ProfileScreen: called")
    Text(text = "Profile screen")
}