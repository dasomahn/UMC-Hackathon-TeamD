package com.softsquared.template.kotlin.src.main.townLife

data class KeywordItemHolder(
    val image: Int = 0,
    val keyword: String
)

data class TownLifeArticleItemHolder(
    val content: String,
    val region: String,
    val time: String,
    val commentNum: Int,
    val likeNum: Int,
    val image: String,
    val category: String
)