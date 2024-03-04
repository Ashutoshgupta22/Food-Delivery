package com.aspark.spendwiseassign.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String,
                           val unselectedIcon: ImageVector,
                           val selectedIcon: ImageVector,
                           val label: String) {

    data object Home : BottomNavItem("home",
    Icons.Outlined.Home,
        Icons.Default.Home,
        "Home")
    data object MyMeals : BottomNavItem("myMeals",
        Icons.Outlined.DateRange,
        Icons.Default.DateRange,
        "My Meals")
    data object QuickGrab : BottomNavItem("quickGrab",
    Icons.Outlined.ShoppingCart,
        Icons.Default.ShoppingCart,
        "Quick Grab")
    data object Profile : BottomNavItem("profile",
        Icons.Outlined.Person,
        Icons.Default.Person,
        "Profile")
}