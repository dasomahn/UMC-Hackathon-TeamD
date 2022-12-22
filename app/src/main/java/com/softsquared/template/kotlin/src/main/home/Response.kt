package com.softsquared.template.kotlin.src.main.home

import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

data class HomeArticleListResponse(
    val isSuccess: Boolean,
    val code: Int,
    val message: String,
    val result: ArrayList<HomeArticleListResult>
)

data class HomeArticleListResult(
    val idx: Int,
    val imgURL: String,
    val title: String,
    val region: String,
    val createdAt : Date,
    val type: String,
    val price: Int
    )

data class HomeArticleResponse(
    val isSuccess: Boolean,
    val code: Int,
    val message: String,
    val result: HomeArticleResult
)

data class HomeArticleResult(
    val idx: Int,
    val sellerIdx: Int,
    val nickname: String,
    val region: String,
    val manner: Float,
    val type: String,
    val title: String,
    val categoryIdx: Int,
    val cateName: String,
    val createdAt: Timestamp,
    val content: String,
    val imgURL: String,
    val price: Int,
    val wantNego: String
)
