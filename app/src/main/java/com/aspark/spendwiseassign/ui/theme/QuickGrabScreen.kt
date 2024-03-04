package com.aspark.spendwiseassign.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aspark.spendwiseassign.R

@Composable
fun QuickGrabScreen(navController: NavController) {

    Column {
        QuickGrabTopBar(navController)
        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            DetailCard()
        }
    }
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
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
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

    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, start = 18.dp, end = 18.dp, bottom = 150.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .height(20.dp)
                    .width(20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Tawa Pulao", fontWeight = FontWeight.Bold,
                fontSize = 18.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Cooked with basmati rice",
                fontSize = 18.sp)
            Text(text = "Rs. 80", fontWeight = FontWeight.Medium,
                fontSize = 18.sp, modifier = Modifier.padding(vertical = 6.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "4.8", fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Icon(imageVector = Icons.Default.Star, contentDescription = "",
                    tint = gold
               )

                Text(
                    text = "(65)",
                    fontSize = 18.sp
                )

            }
        }

    }


}
