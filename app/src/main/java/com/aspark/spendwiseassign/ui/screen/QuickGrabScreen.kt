@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.aspark.spendwiseassign.ui.screen

import android.content.Context
import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aspark.spendwiseassign.R
import com.aspark.spendwiseassign.model.DragAnchors
import com.aspark.spendwiseassign.ui.theme.AppOrange
import com.aspark.spendwiseassign.ui.theme.SpendWiseAssignTheme
import com.aspark.spendwiseassign.ui.theme.gold
import kotlin.math.abs

@Composable
fun QuickGrabScreen(navController: NavController, context: Context) {

//    ShowInstruction()

    val dishes = listOf("Dish 1", "Dish 2", "Dish 3", "Dish 4")
    var indexState by remember { mutableIntStateOf(0) }

    Column {
        LunchTopBar(navController)

        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                val currentCard = dishes[indexState]
                val nextCard = if (indexState + 1 < dishes.size) dishes[indexState + 1] else null

                val bottomCardState = remember(currentCard) { mutableFloatStateOf(0.80f) }

                if (nextCard != null) {
                    CardSwipe(nextCard, false, bottomCardState) {}
                }

                CardSwipe(currentCard, true, bottomCardState) { isRightSwiped ->
                    indexState = (indexState + 1).coerceAtMost(dishes.lastIndex)
                    Log.i("QuickGrabScreen", "index: $indexState")
                    Log.i("QuickGrabScreen", "isRightSwiped: $isRightSwiped")

                    if (isRightSwiped)
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
//                            Toast.makeText(context, "1 item added in cart", Toast.LENGTH_SHORT).show()


//                            Snackbar(
//                                modifier = Modifier.padding(16.dp),
//                                action = {
//                                        Icon(
//                                            imageVector = Icons.AutoMirrored.Default.ArrowForward,
//                                            contentDescription = ""
//                                        )
//
//                                }
//                            ) {
//                                Text(text = "1 Item Added in cart")
//                            }
                        }
                }

            }
        }
    }
}

@Composable
fun ShowFirstInstruction(modifier: Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 18.dp, end = 18.dp, bottom = 150.dp)
            .background(AppOrange)

    ) {

        Text(text = "This")
    }
}

@Composable
fun LunchTopBar(navController: NavController) {

    Column {
        LargeTopAppBar(
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = Color.White
            ),
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
fun CardSwipe(
    currentCard: String, isTopCard: Boolean,
    bottomCardState: MutableFloatState, onSwipe: @Composable (Boolean) -> Unit
) {
    val draggableState = rememberAnchoredDraggableState(currentCard)

    val offset = draggableState.requireOffset()

    // top card changes scale of bottom card only when it is dragged
    if (isTopCard && abs(offset) != 0f) {
        bottomCardState.floatValue =  (abs(offset) / 700).coerceIn(0.80f, 1f)
    }

    if (!isTopCard) Log.i("QuickGRabScreen", "Below card recomposed")
    else Log.i("QuickGRabScreen", "Top card recomposed")

    Log.i("GrabScreen", "scale: $bottomCardState")

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.scale(if (isTopCard) 1f else bottomCardState.floatValue)
    ) {
        val modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, start = 18.dp, end = 18.dp, bottom = 150.dp)
        DetailCard(modifier, draggableState, onSwipe, currentCard)
        // ShowFirstInstruction(modifier)
    }
}

@Composable
fun DetailCard(
    modifier: Modifier,
    draggableState: AnchoredDraggableState<DragAnchors>,
    onSwipe: @Composable (Boolean) -> Unit,
    currentCard: String,
) {

    var isRightSwiped by remember(currentCard) { mutableStateOf(false) }
    var isSwipedOff by remember(currentCard) { mutableStateOf(false) }

    if (!isSwipedOff) {

        Card(
            onClick = { /*TODO*/ },
            modifier = modifier
                .offset {
                    val xStateOffset = draggableState.requireOffset()
                    val yStateOffset = calculateYOffset(xStateOffset)

                    isSwipedOff = abs(xStateOffset) >= 1200f
                    isRightSwiped = xStateOffset >= 1200f

                    IntOffset(
                        x = xStateOffset.toInt(),
                        y = yStateOffset.toInt()
                    )
                }
                .anchoredDraggable(
                    state = draggableState,
                    orientation = Orientation.Horizontal,
                )
                .rotate(calculateTilt(draggableState.requireOffset())),
            shape = RoundedCornerShape(16.dp)
        ) {
            CardContent(currentCard)
        }
    } else {
        onSwipe(isRightSwiped)
        Log.i("QuickGrabScreen", "DetailCard: is swiped off")
    }
}

@Composable
fun rememberAnchoredDraggableState(
    currentCard: String,
): AnchoredDraggableState<DragAnchors> {
    val density = LocalDensity.current

    return remember(currentCard) {
        AnchoredDraggableState(
            initialValue = DragAnchors.CENTER,
            positionalThreshold = { totalDistance: Float ->
                totalDistance * 0.4f
            },
            velocityThreshold = {
                with(density) { 1000.dp.toPx() }
            },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessVeryLow
            )
        ).apply {
            updateAnchors(
                DraggableAnchors {
                    DragAnchors.CENTER at 0f
                    DragAnchors.START at -1200f
                    DragAnchors.END at 1200f
                    DragAnchors.TOP at 0f
                    DragAnchors.BOTTOM at 1200f
                }
            )
        }
    }
}

@Composable
fun CardContent(currentCard: String) {

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
        Text(
            text = currentCard, fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Cooked with basmati rice",
            fontSize = 18.sp
        )
        Text(
            text = "Rs. 80", fontWeight = FontWeight.Medium,
            fontSize = 18.sp, modifier = Modifier.padding(vertical = 6.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "4.8", fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "",
                tint = gold
            )

            Text(
                text = "(65)",
                fontSize = 18.sp
            )
        }
    }
}

fun calculateTilt(requireOffset: Float): Float = -requireOffset.div(90)

fun calculateYOffset(xOffset: Float): Float {
    val progress = xOffset.div(600)
    return 0.2f * progress * progress * progress * (if (xOffset > 0) 1 else -1)
}

@Preview(showBackground = true)
@Composable
fun QuickGrabScreenPreview() {

    SpendWiseAssignTheme {
//        QuickGrabScreen(navController = rememberNavController())
    }
}
