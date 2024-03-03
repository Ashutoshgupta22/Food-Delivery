@file:OptIn(ExperimentalMaterial3Api::class)

package com.aspark.spendwiseassign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aspark.spendwiseassign.ui.theme.AppOrange
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
fun TopBar() {

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
                Column(
                    modifier = Modifier.padding(top = 8.dp, end = 18.dp, start = 8.dp)
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Filled.LocationOn, contentDescription = "",
                            tint = AppOrange
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = "Work", fontWeight = FontWeight.ExtraBold, fontSize = 22.sp
                        )
                        Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "")

                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "Hello, John!", fontSize = 20.sp)
                    }

                }
            }
        )
        MultiSelectFilterChip()
    }

}

@Composable
fun MultiSelectFilterChip() {
    val selected = remember { mutableStateListOf<String>() }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        itemsIndexed(listOf("Sort by", "Veg", "Non Veg", "4+ Rating", "Under ₹100"))
        { index, title ->

            ElevatedFilterChip(
                modifier = Modifier.padding(horizontal = 6.dp),
                selected = selected.contains(title),
                border = BorderStroke(1.dp, Color.Gray),
                onClick = {
                    if (selected.contains(title))
                        selected.remove(title)
                    else {
                        if (index != 0)
                            selected.add(title)
                    }
                },
                label = { Text(text = title) },
                trailingIcon = {
                    if (index == 0) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    }

}


@Composable
fun HomeScreenContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(innerPadding)
    ) {

        TextLabel("my next meal")

        Row(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(width = 75.dp, height = 80.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .wrapContentWidth()
            ) {
                Text(
                    text = "Biryani", fontWeight = FontWeight.Bold,
                    fontSize = 20.sp, modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(text = "Dinner", fontSize = 20.sp, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = "Arriving : 8:30 pm", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier.height(90.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Edit", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }

}

@Composable
fun TextLabel(label: String) {

    Box(
        modifier = Modifier.padding(
            end = 16.dp, start = 16.dp,
            top = 16.dp, bottom = 12.dp
        ),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.LightGray
        )
        Text(
            text = label.uppercase(),
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 10.dp)
        )
    }
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