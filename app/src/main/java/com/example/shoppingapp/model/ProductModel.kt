package com.example.shoppingapp.model

data class ProductModel(
    val id : String = "",
    val name : String = "",
    val imageUrl : List<String> = emptyList(),
    val price : String = "",
    val actualprice: String = "",
    val description : String = "",
    val category : String = "",
)
