package com.example.shoppingapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecom.screen.AuthScreen
import com.example.shoppingapp.screen.HomeScreen
import com.example.shoppingapp.screen.LoginScreen
import com.example.shoppingapp.screen.SignupScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val isLoggedIn = Firebase.auth.currentUser != null
    val firstperson = if (isLoggedIn) "Home" else "auth"
    NavHost(navController =navController , startDestination = firstperson) {
        composable("auth") {
            AuthScreen(modifier,navController)
        }


        composable("login") {
            LoginScreen(modifier,navController)
        }


        composable("signup") {
            SignupScreen(modifier,navController)
        }


        composable("Home") {
            HomeScreen(modifier,navController)
        }


        
    }



}