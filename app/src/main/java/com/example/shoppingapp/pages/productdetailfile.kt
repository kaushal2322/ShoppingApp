package com.example.shoppingapp.pages

import android.R.attr.fontWeight
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shoppingapp.model.ProductModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType

@Composable
fun ProductDetailPage(modifier: Modifier= Modifier,productid: String) {

    var product by remember {
        mutableStateOf(ProductModel())
    }


    LaunchedEffect(key1 = Unit) {
        Firebase.firestore.collection("data").document("stock")
            .collection("product")
            .document(productid).get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    product = it.result.toObject(ProductModel::class.java) ?: ProductModel()
                }
            }
    }
    Column (
        modifier = modifier.padding(16.dp).fillMaxSize().verticalScroll(rememberScrollState())
    ){
        Text(text = product.name,modifier=modifier.padding(8.dp),fontSize = 24.sp,fontWeight = FontWeight.Bold)

        Spacer(modifier = modifier.padding(8.dp))


        Column (
        ){
            val pageState = rememberPagerState(0){

                product.imageUrl.size
            }
            HorizontalPager(state = pageState , pageSpacing = 24.dp) {
                AsyncImage(
                    model = product.imageUrl.get(it),
                    contentDescription = "product Images",modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).height(220.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            DotsIndicator(
                dotCount =  product.imageUrl.size,
                type = ShiftIndicatorType(DotGraphic(
                    color = MaterialTheme.colorScheme.primary, size = 6.dp
                )),
                pagerState = pageState
            )

        }


        Spacer(modifier = modifier.padding(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = "$"+product.actualprice,
                fontSize = 16.sp,
                style = TextStyle(textDecoration = TextDecoration.LineThrough),
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "$"+product.price,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Add to Favorite",
                )
            }
        }



        Button(onClick = { /* Handle add to cart */ },
            modifier=Modifier.fillMaxWidth().padding(8.dp),
        ) {
            Text(text = "Add to Cart",fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        Text(
            text = "Product Details:",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,

        )
        Text(
            text = product.description,
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp,
            lineHeight = 20.sp
        )


    }


}