package com.softsquared.template.kotlin.src.main.home.models

data class ArticleModel(
    val sellerId : String,
    val title: String,
    val createdAt: Long,
    val price: String,
    val imageUrl: String
)
