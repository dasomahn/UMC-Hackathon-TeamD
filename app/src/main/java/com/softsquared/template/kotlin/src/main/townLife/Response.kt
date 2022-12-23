package com.softsquared.template.kotlin.src.main.townLife

import java.sql.Timestamp

data class TownLifeArticleListResponse(
    val isSuccess: Boolean,
    val code: Int,
    val message: String,
    val result: ArrayList<TownLifeArticleListResult>
)

data class TownLifeArticleListResult(
    val idx: Int,
    val categoryIdx: Int,
    val cateName: String,
    val content: String,
    val userIdx: Int,
    val nickname: String,
    val region: String,
    val createdAt: Timestamp,
    val imgURL: String
)
