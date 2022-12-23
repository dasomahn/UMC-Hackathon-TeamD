package com.softsquared.template.kotlin.src.main.townLife

import retrofit2.Call
import retrofit2.http.GET

interface TownLifeRetrofitInterface {
    @GET("/app/myLocal")
    fun getTownLifeArticleList() : Call<TownLifeArticleListResponse>
}