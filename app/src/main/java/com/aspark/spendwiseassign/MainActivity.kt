@file:OptIn(ExperimentalMaterial3Api::class)

package com.aspark.spendwiseassign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aspark.spendwiseassign.ui.theme.SpendWiseAssignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpendWiseAssignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.Home.route,
    ) {

        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.MyMeals.route) {
            HomeScreen()
        }
        composable(BottomNavItem.QuickGrab.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Profile.route) {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) {
        HomeScreenContent(it)
    }
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues) {

}

@Composable
fun TopBar() {
   LargeTopAppBar(
       modifier = Modifier.wrapContentSize(),
        title = {
            SearchBar(
                modifier = Modifier.fillMaxWidth()
                    .height(55.dp)
                    .padding(end = 16.dp)
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                query = "",
                onQueryChange = {},
                onSearch = {} ,
                active = false,
                onActiveChange = {},
                placeholder = {
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = "Search for meals, chefs and more", color = Color.Gray,
                        fontSize = 17.sp)
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.wrapContentSize(),
                        imageVector = Icons.Outlined.Search, contentDescription = "",
                        tint = Color.Gray)
                },
                colors = SearchBarDefaults.colors(
                    containerColor = Color.Transparent
                )
            ) {

            }
        },
       navigationIcon = {
           Column (
               modifier = Modifier.padding(top = 32.dp, end = 18.dp, start = 8.dp)
           ) {
               Row {
                   Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "")
                   Text(
                       modifier = Modifier.padding(horizontal = 8.dp),
                       text = "Work", fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
                   Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "")

                   Spacer(modifier = Modifier.weight(1f))
                   Text(text = "Hello, John!", fontSize = 20.sp)
               }
           }
       }
    )
}

@Composable
fun BottomBar() {
    BottomAppBar {
        Text(text = "Bottom")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpendWiseAssignTheme {
        HomeScreen()
    }
}