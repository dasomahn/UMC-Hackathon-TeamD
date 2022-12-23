package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeFragmentInterface {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)

    @GET("/app/home")
    fun getHomeArticleList(
    ): Call<HomeArticleListResponse>

    @GET("/app/home/{postIdx}")
    fun getHomeArticle(
        @Path("postIdx") postIdx: Int
    ): Call<HomeArticleResponse>
}