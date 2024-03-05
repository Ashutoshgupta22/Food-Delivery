package com.aspark.spendwiseassign.ui.screen

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyMealScreen() {

    Log.i("Screens", "MyMealScreen: called")
    Text(text = "My Meals", color = Color.Black)
}


@Composable
fun ProfileScreen() {
    Log.i("Screens", "ProfileScreen: called")
    Text(text = "Profile screen", color = Color.Black)
}