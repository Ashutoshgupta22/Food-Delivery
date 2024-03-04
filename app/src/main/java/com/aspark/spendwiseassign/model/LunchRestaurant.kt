package com.aspark.spendwiseassign.model

data class LunchRestaurant(
    val name: String,
    val rating: Double,
    val deliveryTime: String,
    val distance: String,
    val startingPrice: Int,
    val menuList: List<Dish> = listOf()
)

data class Dish(
    val name: String,
    val description: String,
    val price: Int,
    val rating: Double,
    val noOfReviews: Int,
    val veg: Boolean
)

val lunchRestaurants = listOf(
    LunchRestaurant(
        "Aruna Mess",
        4.2,
        "19 min",
        "1.2 km",
        99,
        listOf(
            Dish(
                "Non Veg Thali",
                "Chicken Masala + 3 Roti",
                125,
                4.7,
                78,
                false
            ),
            Dish(
                "Veg Thali",
                "Paneer Masala + 3 Roti",
                115,
                4.4,
                78,
                true
            )
        )
    ),
    LunchRestaurant(
        "Chef Shweta",
        4.8,
        "21 min",
        "1.5 km",
        80,
        listOf(
            Dish(
                "Tawa  Pulao",
                "Cooked with basmati rice",
                80,
                4.8,
                65,
                true
            ),
            Dish(
                "Non Veg Thali",
                "Chicken Masala + 3 Roti",
                125,
                4.9,
                78,
                false
            )
        )
    ),
    LunchRestaurant(
        "Annapurna Mess",
        4.2,
        "19 min",
        "1.2 km",
        99,
        listOf(
            Dish(
                "Non Veg Thali",
                "Chicken Masala + 3 Roti",
                125,
                4.7,
                78,
                false
            ),
            Dish(
                "Veg Thali",
                "Paneer Masala + 3 Roti",
                115,
                4.4,
                78,
                true
            )
        )
    )
)
