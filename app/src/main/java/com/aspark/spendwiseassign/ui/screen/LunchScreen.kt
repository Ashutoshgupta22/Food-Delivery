package com.aspark.spendwiseassign.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aspark.spendwiseassign.ui.MultiSelectFilterChip

@Composable
fun LunchScreen(navController: NavController) {

    Column {
        LunchTopBar(navController = navController) {
            MultiSelectFilterChip()
        }
    }
}