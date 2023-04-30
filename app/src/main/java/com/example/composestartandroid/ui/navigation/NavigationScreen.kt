package com.example.composestartandroid.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
internal fun NavigationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "first",
            modifier = Modifier.weight(1f)
        ) {
            composable("first") {
                FirstScreen(
                    onSecondClick = { navController.navigate("second") },
                    onThirdClick = { navController.navigate("third/${"34"}") }
                )
            }
            composable(
                route = "third/{id}",
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString("id")
                ThirdScreen(id)
            }

            navigation(startDestination = "second", route = "second_graph") {
                composable("second") {
                    SecondScreen(
                        onOneClick = { navController.navigate("second_nested_one") },
                        onTwoClick = { navController.navigate("second_nested_two") }
                    )
                }
                composable("second_nested_one") { SecondNestedOneScreen() }
                composable("second_nested_two") { SecondNestedTwoScreen() }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "First", modifier = Modifier.clickable { navController.navigate("first") })
            Text(
                text = "Second",
                modifier = Modifier.clickable { navController.navigate("second") })
            Text(
                text = "Third",
                modifier = Modifier.clickable { navController.navigate("third/${"34"}") })
        }
    }
}