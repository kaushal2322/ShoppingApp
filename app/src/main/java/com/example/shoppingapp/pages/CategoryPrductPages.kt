package com.example.shoppingapp.pages



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppingapp.component.CategoryItem
import com.example.shoppingapp.model.ProductModel
import com.example.shoppingapp.model.catermodel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun CategoryPrductPages(modifier: Modifier = Modifier,categoryId: String) {
    val productlist  = remember {
        mutableStateOf<List<ProductModel>>(emptyList())
    }

    LaunchedEffect(key1 = Unit) {
        Firebase.firestore.collection("data").document("stock")
            .collection("product")
            .get().addOnCompleteListener(){
                if(it.isSuccessful){
                    val resultlis = it.result.documents.mapNotNull { doc ->
                        doc.toObject(ProductModel::class.java)
                    }
                    productlist.value = resultlis
                }
            }
    }
    LazyColumn {
        items (productlist.value){item ->
            Text(text = item.name)

        }
    }


}
