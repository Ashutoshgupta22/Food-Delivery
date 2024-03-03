package com.aspark.spendwiseassign

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    data object MyMeals : BottomNavItem("myMeals", Icons.Default.Home, "My Meals")
    data object QuickGrab : BottomNavItem("quickGrab", Icons.Default.ShoppingCart, "Quick Grab")
    data object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}