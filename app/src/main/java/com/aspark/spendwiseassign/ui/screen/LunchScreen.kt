package com.aspark.spendwiseassign.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.aspark.spendwiseassign.model.lunchRestaurants
import com.aspark.spendwiseassign.ui.MultiSelectFilterChip
import com.aspark.spendwiseassign.ui.RoundCornerImage
import com.aspark.spendwiseassign.ui.theme.AppOrange
import com.aspark.spendwiseassign.ui.theme.gold

@Composable
fun LunchScreen(navController: NavController) {

    Column {
        LunchTopBar(navController = navController) {
            MultiSelectFilterChip()
        }
    }
}

@Composable
fun DishCard(dish: Dish) {

    ElevatedCard(
        modifier = Modifier.height(180.dp)
            .width(340.dp),
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(24.dp)
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

                Text(text = dish.name, fontWeight = FontWeight.Bold,
                    fontSize = 18.sp, modifier = Modifier.padding(top = 8.dp))

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = dish.description,
                    fontSize = 18.sp)
                Text(text = "Rs. ${dish.price}",
                    fontSize = 18.sp, modifier = Modifier.padding(vertical = 6.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${dish.rating}", fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Icon(imageVector = Icons.Default.Star, contentDescription = "",
                        tint = gold
                    )

                    Text(
                        text = "(${dish.noOfReviews})",
                        fontSize = 18.sp
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
                        onClick = { /*TODO*/ }
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

//    LunchScreen(navController = rememberNavController())
    DishCard(lunchRestaurants[0].menuList[0])

}