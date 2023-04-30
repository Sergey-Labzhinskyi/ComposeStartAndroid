package com.example.composestartandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composestartandroid.ui.customview.HomeCustomViewScreen
import com.example.composestartandroid.ui.navigation.NavigationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //HomeScreen()
           // CounterScreen()
            //RecompositionScreen()
            //TextFieldScreen()
            //NavigationScreen()
            HomeCustomViewScreen()

            /* ComposeStartAndroidTheme {
                 // A surface container using the 'background' color from the theme
                 Surface(
                     modifier = Modifier.fillMaxSize(),
                     color = MaterialTheme.colorScheme.background
                 ) {
                     HomeScreen()
                 }
             }*/
        }
    }
}