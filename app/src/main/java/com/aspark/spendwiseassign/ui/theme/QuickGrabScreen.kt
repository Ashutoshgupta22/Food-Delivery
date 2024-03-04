package com.aspark.spendwiseassign.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun QuickGrabScreen(navController: NavController) {
    QuickGrabTopBar(navController)

    DetailCard()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickGrabTopBar(navController: NavController) {

    Column {

        LargeTopAppBar(
            modifier = Modifier,
            title = {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .padding(end = 16.dp)
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                    query = "",
                    onQueryChange = {},
                    onSearch = {},
                    active = false,
                    onActiveChange = {},
                    placeholder = {
                        Text(
                            modifier = Modifier.wrapContentSize(),
                            text = "Search for meals, chefs and more", color = Color.Gray,
                            fontSize = 17.sp
                        )
                    },
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.wrapContentSize(),
                            imageVector = Icons.Outlined.Search, contentDescription = "",
                            tint = Color.Gray
                        )
                    },
                    colors = SearchBarDefaults.colors(
                        containerColor = Color.Transparent
                    )
                ) {
                }
            },
            navigationIcon = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "")
                        }

//                    Spacer(modifier = Modifier.width(135.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Lunch", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 45.dp)
                        )
                    }
                }
            }
        )
    }

}


@Composable
fun DetailCard() {



}
