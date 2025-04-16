package com.example.shoppingapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.pages.HomePages
import com.example.shoppingapp.pages.cartpages
import com.example.shoppingapp.pages.favpages
import com.example.shoppingapp.pages.profilepages
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController : NavController){
    val navItem = listOf(
        navlist("Home", Icons.Default.Home),
        navlist("favorite", Icons.Default.Favorite),
        navlist("Cart", Icons.Default.ShoppingCart),
        navlist("Profile", Icons.Default.Person),
    )
    var selectedItem by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                navItem.forEachIndexed{index ,navitem ->
                    NavigationBarItem(selected = index == selectedItem,
                        onClick = {
                            selectedItem = index
                        },
                        icon = {
                            Icon(imageVector = navitem.image, contentDescription = "null")
                        },
                        label = {
                            Text(text = navitem.name)
                        },

                    )
                }
            }
        }
    ){
contentScreen(modifier = modifier.padding(it),selectedItem)
    }
}


@Composable
fun contentScreen(modifier: Modifier = Modifier,selectedIndex : Int){
    when(selectedIndex){
        0 -> HomePages(modifier)
        1 -> favpages(modifier)
        2 -> cartpages(modifier)
        3 -> profilepages(modifier)
    }
}
data class navlist(
    val name: String,
        val image: ImageVector
        )
