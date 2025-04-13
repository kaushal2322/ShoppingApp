package com.example.ecom.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.example.shoppingapp.R

@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(modifier = modifier
        .padding(32.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.authpic), contentDescription ="HomeScreen",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
            )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Kickstart Your Shopping Adventure Today!",
            style= TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,

                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center)
            )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("login") },
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
            ) {
            Text(text ="Login", fontSize = 22.sp) }




        OutlinedButton(onClick = { navController.navigate("signup") },
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)) {
            Text(text ="SignUp", fontSize = 22.sp)

        }


    }

}