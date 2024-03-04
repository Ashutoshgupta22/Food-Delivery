package com.aspark.spendwiseassign.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aspark.spendwiseassign.R
import com.aspark.spendwiseassign.model.Dish
import com.aspark.spendwiseassign.model.LunchRestaurant
import com.aspark.spendwiseassign.model.lunchRestaurants
import com.aspark.spendwiseassign.ui.MultiSelectFilterChip
import com.aspark.spendwiseassign.ui.theme.AppOrange
import com.aspark.spendwiseassign.ui.theme.gold

@Composable
fun LunchScreen(navController: NavController) {

    Column {
        LunchTopBar(navController = navController)
        MultiSelectFilterChip()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(lunchRestaurants) { index, restaurant ->
                RestaurantCard(restaurant)
                if (index == lunchRestaurants.lastIndex)
                    Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: LunchRestaurant) {

    ElevatedCard(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth(),
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = restaurant.name, fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowForward,
                            contentDescription = ""
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${restaurant.rating}", fontWeight = FontWeight.Bold,
                    )

                    Icon(
                        imageVector = Icons.Default.Star, contentDescription = "",
                        tint = gold, modifier = Modifier.size(22.dp)
                    )
                    Text(
                        text = "${restaurant.deliveryTime} | ${restaurant.distance}",
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "Starts from Rs.${restaurant.startingPrice} only",
                    fontSize = 15.sp, modifier = Modifier.padding(top = 6.dp)
                )
            }

            LazyRow(
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(restaurant.menuList) {
                    DishCard(dish = it)
                }
            }
        }
    }
}

@Composable
fun DishCard(dish: Dish) {

    ElevatedCard(
        modifier = Modifier
            .height(170.dp)
            .width(310.dp),
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            Column(
                Modifier.padding(end = 16.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .height(20.dp)
                        .width(20.dp)
                )

                Text(
                    text = dish.name, fontWeight = FontWeight.Bold,
                    fontSize = 16.sp, modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = dish.description,
                    fontSize = 14.sp, color = Color.Gray
                )
                Text(
                    text = "Rs.${dish.price}",
                    fontSize = 14.sp, modifier = Modifier.padding(vertical = 6.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${dish.rating}", fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )

                    Icon(
                        imageVector = Icons.Default.Star, contentDescription = "",
                        tint = gold, modifier = Modifier.size(20.dp)
                    )

                    Text(
                        text = "(${dish.noOfReviews})",
                        fontSize = 14.sp
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxHeight(),

                ) {
                Image(
                    painter = painterResource(dish.image),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .size(width = 100.dp, height = 120.dp)
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    ElevatedButton(
                        modifier = Modifier.padding(top = 95.dp),
                        shape = RoundedCornerShape(4.dp),
                        onClick = { /*TODO*/ },
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Add", fontWeight = FontWeight.Bold,
                            color = AppOrange, fontSize = 18.sp
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LunchScreenPreview() {

    LunchScreen(navController = rememberNavController())
//    DishCard(lunchRestaurants[0].menuList[0])
//    RestaurantCard(lunchRestaurants[0])

}