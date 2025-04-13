package com.example.shoppingapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shoppingapp.AppUtil
import com.example.shoppingapp.R
import com.example.shoppingapp.viewmodel.AuthViewModel


@Composable
fun SignupScreen(modifier: Modifier = Modifier,navController : NavController,authViewModel : AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember {
        mutableStateOf(false)
    }

var context = LocalContext.current

    Column (
        modifier = modifier
            .padding(32.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Hello There!",
            modifier = Modifier.fillMaxWidth(),
            style= TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,

                fontFamily = FontFamily.SansSerif,
                ))
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Create an Account",
            modifier = Modifier.fillMaxWidth(),
            style= TextStyle(
                fontSize = 22.sp,
            ))

        Spacer(modifier = Modifier.height(16.dp))


        Image(painter = painterResource(id = R.drawable.account), contentDescription ="HomeScreen",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange ={email = it} , label = {Text(text = "Email Address")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = name, onValueChange ={name = it} , label = {Text(text = "Enter Name")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = password, onValueChange ={password= it} , label = {Text(text = "Password")}, modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            isLoading=true
            authViewModel.signup(email,name,password){success,errorMessage->
                if (success){
                    isLoading = false
                    navController.navigate("Home"){
                        popUpTo("auth"){
                            inclusive = true
                        }
                    }

                }else{
                    isLoading = false
                    AppUtil.showToast(context,errorMessage?:"something went wrong")
                }

            }



        },
            enabled = !isLoading,
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(text ="Sign Up", fontSize = 22.sp) }



    }

}