package com.example.shoppingapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingapp.component.Bannerview
import com.example.shoppingapp.component.CategoriesView
import com.example.shoppingapp.component.Headerview

@Composable
fun HomePages(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize().padding(16.dp)
    ){
        Headerview(modifier)
        Spacer(modifier = Modifier.height(10.dp))
        Bannerview(modifier= Modifier.height(150.dp))
        Text(
            "Categories",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        CategoriesView()

    }
}