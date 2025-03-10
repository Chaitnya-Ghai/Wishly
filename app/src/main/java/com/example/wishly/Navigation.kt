package com.example.wishly

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation( viewModel: WishViewModel = viewModel() , navController: NavHostController = rememberNavController()){
    NavHost(navController = navController,startDestination = Screen.HomeScreen.route ) {
        composable(Screen.HomeScreen.route){
            HomeView(navController,viewModel)
        }
        composable("${Screen.AddScreen.route}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ) { value ->
            val id = value.arguments?.getLong("id") ?: 0L
            AddEditWishView(id = id, viewModel, navController)
        }

    }
}